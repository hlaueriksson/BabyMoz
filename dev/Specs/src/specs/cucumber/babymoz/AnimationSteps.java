package specs.cucumber.babymoz;

import com.hoffenkloffen.babymoz.core.Animation;
import com.hoffenkloffen.babymoz.core.Library;
import com.hoffenkloffen.babymoz.core.Preferences;
import com.hoffenkloffen.babymoz.core.Screen;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import specs.FakeBaseActivity;
import specs.TestSupport;
import specs.cucumber.BaseActivityContext;
import specs.cucumber.LibraryContext;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class AnimationSteps {

    private LibraryContext libraryContext;
    private BaseActivityContext baseActivityContext;
    public AnimationSteps(LibraryContext libraryContext, BaseActivityContext baseActivityContext)
    {
        this.libraryContext = libraryContext;
        this.baseActivityContext = baseActivityContext;
    }

    // Animation initiation

    @Then("^a random animation is associated with the screen$")
    public void a_random_animation_is_associated_with_the_screen() {

        Screen screen = libraryContext.getLibrary().getScreen();
        Animation animation = screen.getAnimation();

        assertNotNull(animation);
    }

    // Animation is enabled

    @Given("^that animations are enabled$")
    public void that_animations_are_enabled() {

        Preferences preferences = new Preferences();
        preferences.setAnimation(true);

        FakeBaseActivity activity = TestSupport.fakeBaseActivity();
        activity.setPreferences(preferences);

        baseActivityContext.setActivity(activity);
    }

    @Then("^the associated animation should be started$")
    public void the_associated_animation_should_be_started() {

        Library library = baseActivityContext.getActivity().getLibrary();
        Screen screen = library.getScreen();

        verify(baseActivityContext.getActivity().getScreenManager()).start(screen.getAnimation());
    }

    // Animation is disabled

    @Given("^that animations are disabled$")
    public void that_animations_are_disabled() {

        Preferences preferences = new Preferences();
        preferences.setAnimation(false);

        FakeBaseActivity activity = TestSupport.fakeBaseActivity();
        activity.setPreferences(preferences);

        baseActivityContext.setActivity(activity);
    }

    @Then("^no animation should be started$")
    public void no_animation_should_be_started() {

        verify(baseActivityContext.getActivity().getScreenManager(), never()).start(any(Animation.class));
    }

    // Animation default

    @Given("^the default preferences$")
    public void the_default_preferences() {

        // orka
    }

    @Then("^animation should be enabled$")
    public void animation_should_be_enabled() {

        assertTrue(Preferences.getDefault().getAnimation());
    }
}
