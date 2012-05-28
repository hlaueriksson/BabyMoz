package com.hoffenkloffen.babymoz.core;

public class Welcome extends Image {

    public Welcome(int resId) {
        super(resId);
    }

    public Welcome(String filename) {
        super(filename);
    }

    @Override
    public boolean enableStyle() {
        return false;
    }

    @Override
    public boolean enableAudio() {
        return false;
    }

    @Override
    public boolean enableAnimation() {
        return false;
    }
}
