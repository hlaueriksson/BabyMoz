package specs.junit.babymoz.baseactivity;

import com.hoffenkloffen.babymoz.core.Preferences;
import org.mockito.Mockito;
import specs.FakeBaseActivity;
import specs.TestSupport;
import specs.junit.BaseSpec;

import static org.mockito.Mockito.mock;

public class Given_BaseActivity extends BaseSpec {

    protected FakeBaseActivity activity;

    protected void given()
    {
        activity = mock(FakeBaseActivity.class, Mockito.CALLS_REAL_METHODS);
        activity.setPreferences(Preferences.getDefault());
        activity.setLibrary(TestSupport.createLibrary());
    }
}
