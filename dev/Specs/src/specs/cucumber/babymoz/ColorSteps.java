package specs.cucumber.babymoz;

import com.hoffenkloffen.babymoz.core.*;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import specs.cucumber.BaseActivityContext;
import specs.cucumber.LibraryContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

public class ColorSteps {

    private LibraryContext libraryContext;
    private BaseActivityContext baseActivityContext;
    public ColorSteps(LibraryContext libraryContext, BaseActivityContext baseActivityContext)
    {
        this.libraryContext = libraryContext;
        this.baseActivityContext = baseActivityContext;
    }

    // Color initiation

    @Then("^a random background and text color is associated with the screen$")
    public void a_random_background_and_text_color_is_associated_with_the_screen() {

        Screen screen = libraryContext.getLibrary().getScreen();
        Style style = screen.getStyle();

        assertThat(style.getBackgroundColor(), not(equalTo(0)));
        assertThat(style.getTextColor(), not(equalTo(0)));
    }

    // Color contrast

    @Given("^that a screen is initiated with the same background and text color$")
    public void that_a_screen_is_initiated_with_the_same_background_and_text_color() {

        Set set = new Set();
        set.addItem(new Symbol("A"));

        Library library = new Library(set);
        library.setColors(new int[] {1}); // NOTE: with one color, the background and text color will be the same
        library.init(); // NOTE: initiates all screens

        libraryContext.setLibrary(library);
    }

    @Then("^a default background and text color should be associated with the screen$")
    public void a_default_background_and_text_color_should_be_associated_with_the_screen() {

        Screen screen = libraryContext.getLibrary().getScreen();
        Style style = screen.getStyle();

        assertEquals(Style.getDefault().getBackgroundColor(), style.getBackgroundColor());
        assertEquals(Style.getDefault().getTextColor(), style.getTextColor());
    }

    // Color display

    @Then("^the background and text color associated with the screen should be applied$")
    public void the_background_and_text_color_associated_with_the_screen_should_be_applied() {

        Library library = baseActivityContext.getActivity().getLibrary();
        Screen screen = library.getScreen();

        verify(baseActivityContext.getActivity().getScreenManager()).apply(screen.getStyle());
    }
}
