package specs.junit.babymoz.resourceloader;

import com.hoffenkloffen.babymoz.core.Set;
import org.junit.Test;
import org.xmlpull.v1.XmlPullParser;
import specs.TestSupport;

import static junit.framework.Assert.assertNull;

public class When_load_Set_with_no_Audio extends Given_ResourceLoader {

    protected Set set;

    protected void when() throws Exception {

        String path = "\\Specs\\src\\specs\\junit\\babymoz\\resourceloader\\set_with_no_audio.xml";
        XmlPullParser parser = TestSupport.getXmlPullParser(path);

        set = loader.loadSet(parser);
    }

    @Test
    public void then_the_set_should_include_no_audio() {

        assertNull(set.getAudio());
    }
}
