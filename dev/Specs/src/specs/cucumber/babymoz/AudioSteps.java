package specs.cucumber.babymoz;

import com.hoffenkloffen.babymoz.core.Audio;
import com.hoffenkloffen.babymoz.core.Library;
import com.hoffenkloffen.babymoz.core.Preferences;
import com.hoffenkloffen.babymoz.core.Screen;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import specs.FakeBaseActivity;
import specs.TestSupport;
import specs.cucumber.BaseActivityContext;
import specs.cucumber.LibraryContext;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class AudioSteps {

    private LibraryContext libraryContext;
    private BaseActivityContext baseActivityContext;
    public AudioSteps(LibraryContext libraryContext, BaseActivityContext baseActivityContext)
    {
        this.libraryContext = libraryContext;
        this.baseActivityContext = baseActivityContext;
    }

    // Audio initiation

    @Then("^a audio reference is associated with the screen$")
    public void a_audio_reference_is_associated_with_the_screen() {

        Screen screen = libraryContext.getLibrary().getScreen();
        Audio audio = screen.getAudio();

        assertNotNull(audio);
        assertTrue(audio.getOffset() >= 0);
        assertTrue(audio.getDuration() > 0);
    }

    // Audio is enabled

    @Given("^that audio is enabled$")
    public void that_audio_is_enabled() {

        Preferences preferences = new Preferences();
        preferences.setAudio(true);

        FakeBaseActivity activity = TestSupport.fakeBaseActivity();
        activity.setPreferences(preferences);

        baseActivityContext.setActivity(activity);
    }

    @Then("^the associated sound should be played$")
    public void the_associated_sound_should_be_played() {

        Library library = baseActivityContext.getActivity().getLibrary();
        Screen screen = library.getScreen();

        verify(baseActivityContext.getActivity().getAudioManager()).play(screen.getAudio());
    }

    // Audio is disabled

    @Given("^that audio is disabled$")
    public void that_audio_is_disabled() {

        Preferences preferences = new Preferences();
        preferences.setAudio(false);

        FakeBaseActivity activity = TestSupport.fakeBaseActivity();
        activity.setPreferences(preferences);

        baseActivityContext.setActivity(activity);
    }

    @Then("^no sound should be played$")
    public void no_sound_should_be_played() {

        verify(baseActivityContext.getActivity().getAudioManager(), never()).play(any(Audio.class));
    }

    // Audio default

    @Then("^audio should be enabled$")
    public void audio_should_be_enabled() {

        assertTrue(Preferences.getDefault().getAudio());
    }
}
