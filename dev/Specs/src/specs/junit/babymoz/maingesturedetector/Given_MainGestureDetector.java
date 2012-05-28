package specs.junit.babymoz.maingesturedetector;

import android.view.MotionEvent;
import com.hoffenkloffen.babymoz.MainGestureDetector;
import com.hoffenkloffen.babymoz.UpdateManager;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import specs.junit.BaseSpec;

import static org.mockito.Mockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MotionEvent.class)
public class Given_MainGestureDetector extends BaseSpec {

    protected MainGestureDetector detector;
    protected UpdateManager updateManager;

    protected void given()
    {
        detector = mock(MainGestureDetector.class, Mockito.CALLS_REAL_METHODS);
        updateManager = mock(UpdateManager.class);
        detector.setManager(updateManager);
    }

    protected MotionEvent getMotionEvent(float x, float y)
    {
        MotionEvent result = PowerMockito.mock(MotionEvent.class);
        PowerMockito.when(result.getX()).thenReturn(x);
        PowerMockito.when(result.getY()).thenReturn(y);

        return result;
    }
}
