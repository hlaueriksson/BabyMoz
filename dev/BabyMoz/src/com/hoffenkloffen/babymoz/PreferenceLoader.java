package com.hoffenkloffen.babymoz;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.hoffenkloffen.babymoz.core.Preferences;

public class PreferenceLoader {

    public Preferences load(Context context)
    {
        Preferences result = new Preferences();
        Preferences fallback = Preferences.getDefault();

        // Get the xml/preferences.xml
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);

        result.setAudio(preferences.getBoolean(Preferences.Ids.audio, fallback.getAudio()));
        result.setAnimation(preferences.getBoolean(Preferences.Ids.animation, fallback.getAnimation()));
        result.setShuffle(preferences.getBoolean(Preferences.Ids.shuffle, fallback.getShuffle()));

        return result;
    }
}
