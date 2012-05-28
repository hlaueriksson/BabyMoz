package specs.junit.babymoz.core.library;

import com.hoffenkloffen.babymoz.core.Library;
import specs.TestSupport;
import specs.junit.BaseSpec;

public class Given_Library extends BaseSpec {

    protected Library library;

    protected void given() {

        library = TestSupport.createLibrary();
    }
}
