package specs;

import com.hoffenkloffen.babymoz.AudioManager;
import com.hoffenkloffen.babymoz.ScreenManager;
import com.hoffenkloffen.babymoz.core.*;
import org.mockito.Mockito;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.mockito.Mockito.mock;

public class TestSupport {

    public static Set createSet() {

        Audio audio = new Audio();
        audio.setResId(1);
        audio.setDuration(2000);

        Set set = new Set();
        set.setAudio(audio);
        set.addItem(new Welcome(1)); // NOTE: welcome screen image
        set.addItem(new Symbol("A"));
        set.addItem(new Symbol("B"));
        set.addItem(new Symbol("C"));

        return set;
    }

    public static Library createLibrary() {

        return createLibrary(createSet());
    }

    public static Library createLibrary(Set set) {

        Library library = new Library(set);
        library.setColors(new int[] {1, 2, 3});
        library.setAnimations(new int[]{1, 2, 3});
        library.init();

        return library;
    }

    public static String toString(Set set) {

        StringBuilder sb = new StringBuilder();

        for (Screen screen : set.getItems()) {
            sb.append(screen);
        }

        return sb.toString();
    }

    public static String readFile(String path) throws IOException {

        String base = new java.io.File(".").getCanonicalPath();

        return new Scanner( new File(base + path), "UTF-8" ).useDelimiter("\\A").next();
    }

    public static Document readXml(String path) throws Exception {

        String base = new java.io.File(".").getCanonicalPath();

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        return builder.parse(new File(base + path));
    }

    public static File getFile(String path) throws IOException {

        String base = new java.io.File(".").getCanonicalPath();

        return new File(base + path);
    }

    public static XmlPullParser getXmlPullParser(String path) throws IOException, XmlPullParserException {

        InputStream stream = new FileInputStream(TestSupport.getFile(path));
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(stream, "UTF-8");

        return parser;
    }

    public static Node getNode(Document document, String expression) throws XPathExpressionException {

        XPath xpath = XPathFactory.newInstance().newXPath();
        return (Node) xpath.evaluate(expression, document, XPathConstants.NODE);
    }

    public static NodeList getNodes(Document document, String expression) throws XPathExpressionException {

        XPath xpath = XPathFactory.newInstance().newXPath();
        return (NodeList) xpath.evaluate(expression, document, XPathConstants.NODESET);
    }

    public static FakeBaseActivity fakeBaseActivity() {

        FakeBaseActivity activity = mock(FakeBaseActivity.class, Mockito.CALLS_REAL_METHODS);
        activity.setPreferences(Preferences.getDefault());
        activity.setLibrary(TestSupport.createLibrary());
        activity.setScreenManager(mock(ScreenManager.class));
        activity.setAudioManager(mock(AudioManager.class));

        return activity;
    }
}
