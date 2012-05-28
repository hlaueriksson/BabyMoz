package specs.junit.babymoz.core.library;

import com.hoffenkloffen.babymoz.core.Screen;
import org.junit.Test;

import static junit.framework.Assert.assertNull;

public class When_initiated_with_Set_without_Audio extends Given_Library {

    protected void given() {
        super.given();

        library.getSet().setAudio(null); // remove Audio
        library.init();
    }

    @Test
    public void then_no_screen_should_have_a_audio_reference()
    {
        for (Screen screen : library.getSet().getItems()) {
            assertNull(screen.getAudio());
        }
    }
}
