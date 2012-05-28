package specs.junit.babymozswedish123;

import com.hoffenkloffen.babymoz.core.Set;
import com.hoffenkloffen.babymoz.core.Symbol;
import com.hoffenkloffen.babymoz.core.Welcome;
import org.junit.Test;
import org.xmlpull.v1.XmlPullParser;
import specs.TestSupport;
import specs.junit.babymoz.resourceloader.Given_ResourceLoader;

import static junit.framework.Assert.assertNotNull;

public class When_load_Set extends Given_ResourceLoader {

    protected Set set;

    protected void when() throws Exception {

        String path = "\\BabyMozSwedish123\\res\\xml\\set.xml";
        XmlPullParser parser = TestSupport.getXmlPullParser(path);

        set = loader.loadSet(parser);
    }

    @Test
    public void then_the_set_should_include_audio() {

        assertNotNull(set.getAudio());
    }

    @Test
    public void then_the_set_should_include_1_welcome() {

        Welcome welcome = (Welcome) set.getItems().get(0).getContent();

        assertNotNull(welcome);
    }

    @Test
    public void then_the_set_should_include_9_symbols() {

        for (int i = 1; i < set.getItems().size(); i++) {
            Symbol symbol = (Symbol) set.getItems().get(i).getContent();
            assertNotNull(symbol);
        }
    }
}
