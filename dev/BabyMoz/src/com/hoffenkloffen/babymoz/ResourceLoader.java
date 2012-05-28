package com.hoffenkloffen.babymoz;

import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import com.hoffenkloffen.babymoz.core.*;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class ResourceLoader {

    public Set loadSet(XmlResourceParser parser) throws XmlPullParserException, IOException {

        Set set = loadSet((XmlPullParser) parser);

        parser.close();

        return set;
    }

    protected Set loadSet(XmlPullParser parser) throws XmlPullParserException, IOException {

        Set set = new Set();

        while (parser.getEventType() != XmlResourceParser.END_DOCUMENT) {
            if (parser.getEventType() == XmlResourceParser.START_TAG) {
                String name = parser.getName();

                if (name.equals("set")) {
                    String locale = parser.getAttributeValue(null, "locale");
                    String description = parser.getAttributeValue(null, "description");

                    set.setLocale(locale);
                    set.setDescription(description);

                } else if (name.equals("audio")) {
                    String filename = parser.getAttributeValue(null, "filename");
                    String duration = parser.getAttributeValue(null, "duration");

                    Audio audio = new Audio();
                    audio.setFilename(filename);
                    audio.setDuration(Integer.parseInt(duration));

                    set.setAudio(audio);

                } else if (name.equals("symbol")) {
                    String text = parser.getAttributeValue(null, "text");

                    set.addItem(new Screen(new Symbol(text)));

                } else if (name.equals("image")) {
                    String filename = parser.getAttributeValue(null, "filename");

                    set.addItem(new Screen(new Image(filename)));
                } else if (name.equals("welcome")) {
                    String filename = parser.getAttributeValue(null, "filename");

                    set.addItem(new Screen(new Welcome(filename)));
                }
            }

            parser.next();
        }

        return set;
    }

    public int[] loadColors(TypedArray typedArray) { // TODO: test

        int[] colors = new int[typedArray.length()];

        for (int i = 0; i < typedArray.length(); i++) {
            colors[i] = typedArray.getColor(i, 0);
        }

        return colors;
    }
}
