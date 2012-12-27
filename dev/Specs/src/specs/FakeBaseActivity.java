package specs;

import com.hoffenkloffen.babymoz.AudioManager;
import com.hoffenkloffen.babymoz.BaseActivity;
import com.hoffenkloffen.babymoz.ScreenManager;
import com.hoffenkloffen.babymoz.core.Library;
import com.hoffenkloffen.babymoz.core.Preferences;

public class FakeBaseActivity extends BaseActivity {

    public void setScreenManager(ScreenManager screenManager)
    {
        super.setScreenManager(screenManager);
    }

    public ScreenManager getScreenManager()
    {
        return screenManager;
    }

    public void setAudioManager(AudioManager audioManager)
    {
        super.setAudioManager(audioManager);
    }

    public AudioManager getAudioManager()
    {
        return audioManager;
    }

    public void setPreferences(Preferences preferences)
    {
        this.preferences = preferences;
    }

    public Preferences getPreferences()
    {
        return preferences;
    }

    public void setLibrary(Library library)
    {
        this.library = library;
    }

    public Library getLibrary()
    {
        return library;
    }
}
