package specs;

import com.hoffenkloffen.babymoz.ResourceLoader;
import com.hoffenkloffen.babymoz.core.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class FakeResourceLoader extends ResourceLoader {

    public Set loadSet(XmlPullParser parser) throws XmlPullParserException, IOException {

        return super.loadSet(parser);
    }
}
