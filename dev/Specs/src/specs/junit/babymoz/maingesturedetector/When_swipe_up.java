package specs.junit.babymoz.maingesturedetector;

import com.hoffenkloffen.babymoz.core.Direction;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class When_swipe_up extends Given_MainGestureDetector {

    protected void when()
    {
        detector.onFling(getMotionEvent(0, 400), getMotionEvent(0, 100), 0, 300);
    }

    @Test
    public void then_the_screen_should_not_be_changed()
    {
        verify(updateManager, never()).update(any(Direction.class));
    }
}
