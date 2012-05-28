package specs.junit.babymoz.maingesturedetector;

import com.hoffenkloffen.babymoz.core.Direction;
import org.junit.Test;

import static org.mockito.Mockito.verify;

public class When_swipe_right extends Given_MainGestureDetector {

    protected void when()
    {
        detector.onFling(getMotionEvent(100, 0), getMotionEvent(400, 0), 300, 0);
    }

    @Test
    public void then_the_previous_screen_should_be_displayed()
    {
        verify(updateManager).update(Direction.PREVIOUS);
    }
}
