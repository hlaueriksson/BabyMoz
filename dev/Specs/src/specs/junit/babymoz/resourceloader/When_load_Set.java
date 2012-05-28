package specs.junit.babymoz.resourceloader;

import com.hoffenkloffen.babymoz.core.Set;
import org.junit.Test;
import org.xmlpull.v1.XmlPullParser;
import specs.TestSupport;

import static junit.framework.Assert.assertEquals;

public class When_load_Set extends Given_ResourceLoader {

    protected Set set;

    protected void when() throws Exception {

        String path = "\\Specs\\src\\specs\\junit\\babymoz\\resourceloader\\set.xml";
        XmlPullParser parser = TestSupport.getXmlPullParser(path);

        set = loader.loadSet(parser);
    }

    @Test
    public void then_the_set_should_include_audio() {

        assertEquals("set", set.getAudio().getFilename());
        assertEquals(2000, set.getAudio().getDuration());
    }

    @Test
    public void then_the_set_should_include_symbols() {

        assertEquals("A", set.getItems().get(0).getContent().toString());
        assertEquals("B", set.getItems().get(1).getContent().toString());
        assertEquals("C", set.getItems().get(2).getContent().toString());
    }
}
