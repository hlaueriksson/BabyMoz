package specs.cucumber.babymoz;

import com.hoffenkloffen.babymoz.core.*;
import specs.TestSupport;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

import static org.junit.Assert.assertEquals;

public class SwipeSteps {

    private Set set;
    private Library library;

    @Given("^that I have started the app$")
    public void that_I_have_started_the_app() {

        set = TestSupport.createSet();
        library = TestSupport.createLibrary(set);
    }

    // Before swipe

    @Then("^the start screen should be displayed$")
    public void the_start_screen_should_be_displayed() {
        Image image = (Image)library.getScreen().getContent();
        assertEquals(set.getItems().get(0).getContent(), image);
    }

    // Swipe left

    @When("^I swipe left$")
    public void I_swipe_left() {
        library.move(Direction.NEXT); // NOTE: left
    }

    @Then("^the first symbol should be displayed$")
    public void the_first_symbol_should_be_displayed() {
        Symbol symbol = (Symbol)library.getScreen().getContent();
        assertEquals("A", symbol.getText());
    }

    // Swipe right

    @When("^I swipe right$")
    public void I_swipe_right() {
        library.move(Direction.PREVIOUS); // NOTE: right
    }

    @Then("^the last symbol should be displayed$")
    public void the_last_symbol_should_be_displayed() {
        Symbol symbol = (Symbol)library.getScreen().getContent();
        assertEquals("C", symbol.getText());
    }

    // Swipe forward from last symbol

    @Given("^that the last symbol is displayed$")
    public void that_the_last_symbol_is_displayed() {
        that_I_have_started_the_app();

        library.move(Direction.NEXT); // to A
        library.move(Direction.NEXT); // to B
        library.move(Direction.NEXT); // NOTE: to C, the last symbol

        the_last_symbol_should_be_displayed();
    }

    @Then("^the start screen should be displayed again$")
    public void the_start_screen_should_be_displayed_again() {
        Image image = (Image)library.getScreen().getContent();
        assertEquals(set.getItems().get(0).getContent(), image);
    }

    // Swipe backward from first symbol

    @Given("^that the first symbol is displayed$")
    public void that_the_first_symbol_is_displayed() {
        that_I_have_started_the_app();

        library.move(Direction.NEXT); // NOTE: to A, the first symbol
    }
}
