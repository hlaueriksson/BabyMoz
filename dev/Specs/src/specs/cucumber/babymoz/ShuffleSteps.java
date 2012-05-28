package specs.cucumber.babymoz;

import com.hoffenkloffen.babymoz.core.*;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import specs.TestSupport;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ShuffleSteps {

    private Set set;
    private Library library;

    private void init() {

        set = TestSupport.createSet();
        library = TestSupport.createLibrary(set);
    }

    // Shuffle is disabled

    @Given("^that shuffle is disabled$")
    public void that_shuffle_is_disabled() {
        init();
    }

    @Then("^the screens should be displayed in ascending order$")
    public void the_screens_should_be_displayed_in_ascending_order() {

        for (Screen screen : set.getItems()) {

            assertEquals(screen, library.getScreen());
            library.move(Direction.NEXT);
        }
    }

    // Shuffle is enabled

    @Given("^that shuffle is enabled$")
    public void that_shuffle_is_enabled() {

        init();

        library.shuffle(); // NOTE: enable
    }

    @Then("^the screens should be displayed in random order$")
    public void the_screens_should_be_displayed_in_random_order() {

        String result = "";

        for (Screen screen : set.getItems()) {

            result += library.getScreen();
            library.move(Direction.NEXT);
        }

        assertThat(result, not(equalTo(TestSupport.toString(set))));
    }

    @Then("^the welcome screen should be first$")
    public void the_welcome_screen_should_be_first() {

        Welcome welcome = (Welcome) library.getScreen().getContent();

        assertNotNull(welcome);
    }

    // Shuffle default

    @Then("^shuffle should be disabled$")
    public void shuffle_should_be_disabled() {

        assertFalse(Preferences.getDefault().getShuffle());
    }
}
