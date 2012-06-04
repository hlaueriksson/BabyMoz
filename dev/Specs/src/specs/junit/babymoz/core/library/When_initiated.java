package specs.junit.babymoz.core.library;

import com.hoffenkloffen.babymoz.core.Screen;
import com.hoffenkloffen.babymoz.core.Welcome;
import org.junit.Test;

import static junit.framework.Assert.*;

public class When_initiated extends Given_Library
{
    @Test
    public void then_the_current_screen_should_be_the_first_in_the_set()
    {
        Screen screen = library.getScreen();
        Welcome welcome = (Welcome) screen.getContent();

        assertEquals(1, welcome.getResId());
    }

    @Test
    public void then_the_welcome_screen_should_not_have_a_style()
    {
        Screen screen = library.getSet().getItems().get(0);

        assertNull(screen.getStyle());
    }

    @Test
    public void then_the_welcome_screen_should_not_have_an_audio_reference()
    {
        Screen screen = library.getSet().getItems().get(0);

        assertNull(screen.getAudio());
    }

    @Test
    public void then_the_welcome_screen_should_not_have_an_animation_reference()
    {
        Screen screen = library.getSet().getItems().get(0);

        assertNull(screen.getAnimation());
    }

    @Test
    public void then_all_other_screens_should_have_a_style()
    {
        for (Screen screen : library.getSet().getItems()) {

            if(screen.getContent() instanceof Welcome) continue;

            assertNotNull(screen.getStyle());
            assertTrue(screen.getStyle().getBackgroundColor() != 0);
            assertTrue(screen.getStyle().getTextColor() != 0);
        }
    }

    @Test
    public void then_all_other_screens_should_have_an_audio_reference()
    {
        for (Screen screen : library.getSet().getItems()) {

            if(screen.getContent() instanceof Welcome) continue;

            assertNotNull(screen.getAudio());
            assertTrue(screen.getAudio().getResId() > 0);
            assertTrue(screen.getAudio().getDuration() > 0);
            assertTrue(screen.getAudio().getOffset() >= 0);
        }
    }

    @Test
    public void then_all_other_screens_should_have_an_animation_reference()
    {
        for (Screen screen : library.getSet().getItems()) {

            if(screen.getContent() instanceof Welcome) continue;

            assertNotNull(screen.getAnimation());
            assertTrue(screen.getAnimation().getResId() > 0);
        }
    }
}
