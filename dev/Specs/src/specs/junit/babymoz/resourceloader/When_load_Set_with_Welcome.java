package specs.junit.babymoz.resourceloader;

import com.hoffenkloffen.babymoz.core.Set;
import org.junit.Test;
import org.xmlpull.v1.XmlPullParser;
import specs.TestSupport;

import static junit.framework.Assert.assertEquals;

public class When_load_Set_with_Welcome extends Given_ResourceLoader {

    protected Set set;

    protected void when() throws Exception {

        String path = "\\Specs\\src\\specs\\junit\\babymoz\\resourceloader\\set_with_welcome.xml";
        XmlPullParser parser = TestSupport.getXmlPullParser(path);

        set = loader.loadSet(parser);
    }

    @Test
    public void then_the_set_should_include_the_image() {

        assertEquals("[welcome]", set.getItems().get(0).getContent().toString());
    }
}
