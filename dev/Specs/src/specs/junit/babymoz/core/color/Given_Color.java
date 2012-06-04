package specs.junit.babymoz.core.color;

import com.hoffenkloffen.babymoz.core.Color;
import specs.junit.BaseSpec;

public class Given_Color extends BaseSpec {

    protected Color color;

    protected void given() {

        color = new Color(0);
    }
}
