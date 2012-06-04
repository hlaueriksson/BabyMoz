package specs.junit.babymoz.core.color;

import android.graphics.Color;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class When_get_rgb_on_Gray extends Given_Color {

    protected void given() {

        super.given();
        color.setCode(Color.GRAY);
    }

    @Test
    public void then_red_should_be_136()
    {
        assertEquals(136, color.getRed());
    }

    @Test
    public void then_green_should_be_136()
    {
        assertEquals(136, color.getGreen());
    }

    @Test
    public void then_blue_should_be_136()
    {
        assertEquals(136, color.getBlue());
    }
}
