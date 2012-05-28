package specs.junit.babymoz.baseactivity;

import com.hoffenkloffen.babymoz.AudioManager;
import com.hoffenkloffen.babymoz.ScreenManager;
import com.hoffenkloffen.babymoz.core.*;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class When_update extends Given_BaseActivity {

    protected ScreenManager screenManager;
    protected AudioManager audioManager;

    protected void given()
    {
        super.given();

        screenManager = mock(ScreenManager.class);
        activity.setScreenManager(screenManager);

        audioManager = mock(AudioManager.class);
        activity.setAudioManager(audioManager);
    }

    protected void when()
    {
        activity.update(Direction.NEXT);
    }

    @Test
    public void then_the_content_of_the_current_screen_should_be_displayed()
    {
        verify(screenManager).display(any(Content.class));
    }

    @Test
    public void then_the_style_of_the_current_screen_should_be_applied()
    {
        verify(screenManager).apply(any(Style.class));
    }

    @Test
    public void then_the_animation_of_the_current_screen_should_be_started()
    {
        verify(screenManager).start(any(Animation.class));
    }

    @Test
    public void then_the_audio_of_the_current_screen_should_be_played()
    {
        verify(audioManager).play(any(Audio.class));
    }
}
