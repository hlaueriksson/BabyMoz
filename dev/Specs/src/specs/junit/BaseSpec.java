package specs.junit;

import org.junit.Before;

public class BaseSpec {

    @Before
    public void init() throws Exception {
        given();
        when();
    }

    protected void given() throws Exception { }
    protected void when() throws Exception { }
}
