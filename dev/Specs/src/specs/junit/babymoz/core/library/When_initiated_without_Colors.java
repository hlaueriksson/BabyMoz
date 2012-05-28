package specs.junit.babymoz.core.library;

import com.hoffenkloffen.babymoz.core.Screen;
import com.hoffenkloffen.babymoz.core.Style;
import com.hoffenkloffen.babymoz.core.Welcome;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class When_initiated_without_Colors extends Given_Library {

    protected void given() {
        super.given();

        library.setColors(null);
        library.init();
    }

    @Test
    public void then_all_screens_should_have_the_default_style()
    {
        for (Screen screen : library.getSet().getItems()) {

            if(screen.getContent() instanceof Welcome) continue;

            assertNotNull(screen.getStyle());
            assertEquals(Style.getDefault().getBackgroundColor(), screen.getStyle().getBackgroundColor());
            assertEquals(Style.getDefault().getTextColor(), screen.getStyle().getTextColor());
        }
    }
}
