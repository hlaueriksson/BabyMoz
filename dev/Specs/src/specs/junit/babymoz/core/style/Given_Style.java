package specs.junit.babymoz.core.style;

import com.hoffenkloffen.babymoz.core.Style;
import specs.junit.BaseSpec;

public class Given_Style extends BaseSpec {

    protected Style style;

    protected void given() {

        style = new Style();
    }
}
