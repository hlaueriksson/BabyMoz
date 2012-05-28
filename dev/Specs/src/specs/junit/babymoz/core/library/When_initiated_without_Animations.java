package specs.junit.babymoz.core.library;

import com.hoffenkloffen.babymoz.core.Screen;
import org.junit.Test;

import static junit.framework.Assert.assertNull;

public class When_initiated_without_Animations extends Given_Library {

    protected void given() {
        super.given();

        library.setAnimations(null);
        library.init();
    }

    @Test
    public void then_no_screen_should_have_an_animation_reference()
    {
        for (Screen screen : library.getSet().getItems()) {
            assertNull(screen.getAnimation());
        }
    }
}
