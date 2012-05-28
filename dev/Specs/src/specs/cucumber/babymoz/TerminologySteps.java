package specs.cucumber.babymoz;

import com.hoffenkloffen.babymoz.core.*;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;

import static org.junit.Assert.assertEquals;

public class TerminologySteps {

    private String letter;
    private Symbol symbol;

    private int resImage;
    private Image image;
    private Welcome welcome;

    private Screen screen;
    private Screen[] screens;

    private Set set;

    private Library library;

    // Symbol

    @Given("^that I have a letter$")
    public void that_I_have_a_letter() {
        letter = "A";
    }

    @Then("^a Symbol can be used to represent the letter$")
    public void a_Symbol_can_be_used_to_represent_the_letter() {
        symbol = new Symbol(letter);
        assertEquals(letter, symbol.getText());
    }

    // Image

    @Given("^that I have an image resource$")
    public void that_I_have_an_image_resource() {
        resImage = 1;
    }

    @Then("^an Image can be used to refer to the image resource$")
    public void an_Image_can_be_used_to_refer_to_the_image_resource() {
        image = new Image(resImage);
        assertEquals(resImage, image.getResId());
    }

    // Welcome

    @Given("^that I have an image resource dedicated for a splash screen$")
    public void that_I_have_an_image_resource_dedicated_for_a_splash_screen() {
        resImage = 2;
    }

    @Then("^a Welcome can be used to refer to the image resource$")
    public void a_Welcome_can_be_used_to_refer_to_the_image_resource() {
        welcome = new Welcome(resImage);
        assertEquals(resImage, welcome.getResId());
    }

    // Screen

    @Given("^that I have a Symbol and an Image$")
    public void that_I_have_a_Symbol_and_an_Image() {
        symbol = new Symbol("A");
        image = new Image(1);
    }

    @Then("^a Screen can be used to contain both the Symbol and the Image$")
    public void a_Screen_can_be_used_to_contain_both_the_Symbol_and_the_Image() {
        screen = new Screen(symbol);
        assertEquals(symbol, screen.getContent());

        screen = new Screen(image);
        assertEquals(image, screen.getContent());
    }

    // Set

    @Given("^that I have two Screens$")
    public void that_I_have_two_Screens() {
        screens = new Screen[] { new Screen(new Symbol("A")), new Screen(new Image(1)) };
    }

    @Then("^a Set can be used to list the Screens$")
    public void a_Set_can_be_used_to_list_the_Screens() {
        set = new Set();

        for (Screen screen : screens) {
            set.addItem(screen);
        }

        assertEquals(screens.length, set.getItems().size());

        for(int i = 0; i < set.getItems().size(); i++)
        {
            assertEquals(screens[i], set.getItems().get(i));
        }
    }

    // Library

    @Given("^that I have a Set with Screens$")
    public void that_I_have_a_Set_with_Screens() {
        set = new Set();
        set.addItem(new Screen(new Symbol("A")));
        set.addItem(new Screen(new Image(1)));
    }

    @Then("^a Library can be used to keep track of the Screens$")
    public void a_Library_can_be_used_to_keep_track_of_the_Screens() {
        library = new Library(set);
        library.init();

        assertEquals(set.getItems().get(0), library.getScreen());

        library.move(Direction.NEXT);

        assertEquals(set.getItems().get(1), library.getScreen());
    }
}
