package specs.junit.babymoz.core.color;

import android.graphics.Color;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class When_get_contrast_color extends Given_Color {

    @Test
    public void then_it_should_be_Black_for_White()
    {
        color.setCode(Color.WHITE);

        assertEquals(Color.BLACK, color.getContrastColor());
    }

    @Test
    public void then_it_should_be_White_for_Black()
    {
        color.setCode(Color.BLACK);

        assertEquals(Color.WHITE, color.getContrastColor());
    }

    @Test
    public void then_it_should_be_Black_for_LightGray()
    {
        color.setCode(Color.LTGRAY);

        assertEquals(Color.BLACK, color.getContrastColor());
    }

    @Test
    public void then_it_should_be_White_for_DarkGray()
    {
        color.setCode(Color.DKGRAY);

        assertEquals(Color.WHITE, color.getContrastColor());
    }
}
