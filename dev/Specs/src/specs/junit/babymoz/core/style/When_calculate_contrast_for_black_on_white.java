package specs.junit.babymoz.core.style;

import android.graphics.Color;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class When_calculate_contrast_for_black_on_white extends Given_Style {

    private double result;

    protected void when() {

        style.setTextColor(Color.BLACK);
        style.setBackgroundColor(Color.WHITE);

        result = style.calculateContrast();
    }

    @Test
    public void then_the_contrast_should_be_high()
    {
        assertTrue(result > 5);
    }
}
