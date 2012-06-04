package specs.cucumber.babymoz;

import com.hoffenkloffen.babymoz.core.*;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import specs.cucumber.BaseActivityContext;
import specs.cucumber.LibraryContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
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

    @Then("^the text color associated with the screen should be reset$")
    public void the_text_color_associated_with_the_screen_should_be_reset() {

        Screen screen = libraryContext.getLibrary().getScreen();
        Style style = screen.getStyle();

        assertEquals(1, style.getBackgroundColor());
        assertTrue(style.getTextColor() != 1);
    }

    // Color display

    @Then("^the background and text color associated with the screen should be applied$")
    public void the_background_and_text_color_associated_with_the_screen_should_be_applied() {

        Library library = baseActivityContext.getActivity().getLibrary();
        Screen screen = library.getScreen();

        verify(baseActivityContext.getActivity().getScreenManager()).apply(screen.getStyle());
    }

    // Color values contrast

    @Given("^that the colors values loaded$")
    public void that_the_colors_values_loaded() throws Exception { // TODO: implement

/*        String path = "\\BabyMoz\\res\\values\\colors.xml";
        Document document = TestSupport.readXml(path);

        NodeList nodes = TestSupport.getNodes(document, "//item");

        ArrayList<Color> colors = new ArrayList<Color>();

        for(int i = 0; i < nodes.getLength(); i++)
        {
            String hex = nodes.item(i).getTextContent();
            int color = android.graphics.Color.parseColor(hex);

            colors.add(new Color(color));
        }

        for(int i = 0; i < colors.size(); i++)
        {
            for(int j = 0; j < colors.size(); j++)
            {
                Style style = new Style();
                style.setBackgroundColor(colors.get(i).getCode());
                style.setTextColor(colors.get(j).getCode());

                System.out.println(style.getBackgroundColor() + " " + style.getTextColor() + " " + style.hasValidContrast() + " " + style.calculateContrast());
            }
        }*/
    }

    @When("^all colors combinations are evaluated$")
    public void all_colors_combinations_are_evaluated() {
    }

    @Then("^no more than (\\d+) % should have invalid contrast$")
    public void no_more_than_should_have_invalid_contrast(int arg1) {
    }
}
