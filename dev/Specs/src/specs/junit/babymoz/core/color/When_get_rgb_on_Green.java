package specs.junit.babymoz.core.color;

import android.graphics.Color;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class When_get_rgb_on_Green extends Given_Color {

    protected void given() {

        super.given();
        color.setCode(Color.GREEN);
    }

    @Test
    public void then_red_should_be_0()
    {
        assertEquals(0, color.getRed());
    }

    @Test
    public void then_green_should_be_255()
    {
        assertEquals(255, color.getGreen());
    }

    @Test
    public void then_blue_should_be_0()
    {
        assertEquals(0, color.getBlue());
    }
}
