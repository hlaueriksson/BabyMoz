package com.hoffenkloffen.babymoz.core;

public class Preferences {

    public static class Ids
    {
        public static String audio = "audio";
        public static String animation = "animation";
        public static String shuffle = "shuffle";
    }

    private boolean audio;
    private boolean animation;
    private boolean shuffle;

    public boolean getAudio() {
        return audio;
    }

    public void setAudio(boolean audio) {
        this.audio = audio;
    }

    public boolean getAnimation() {
        return animation;
    }

    public void setAnimation(boolean animation) {
        this.animation = animation;
    }

    public boolean getShuffle() {
        return shuffle;
    }

    public void setShuffle(boolean shuffle) {
        this.shuffle = shuffle;
    }

    public static Preferences getDefault() {

        Preferences preferences = new Preferences();
        preferences.setAudio(true);
        preferences.setAnimation(true);
        preferences.setShuffle(false);

        return preferences;
    }
}
