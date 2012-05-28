package specs.junit.babymoz.resourceloader;

import specs.FakeResourceLoader;
import specs.junit.BaseSpec;

public class Given_ResourceLoader extends BaseSpec {

    protected FakeResourceLoader loader;

    protected void given()
    {
        loader = new FakeResourceLoader();
    }
}
