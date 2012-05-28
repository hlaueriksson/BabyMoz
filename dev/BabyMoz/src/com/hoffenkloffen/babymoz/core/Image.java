package com.hoffenkloffen.babymoz.core;

public class Image extends Resource implements Content
{
    public Image(int resId) {
        setResId(resId);
    }

    public Image(String filename) {
        setFilename(filename);
    }

    @Override
    public String toString()
    {
        if(getFilename() != null) return "[" + getFilename() + "]";

        return "[" + getResId() + "]";
    }

    @Override
    public String getType() {
        return "drawable";
    }

    @Override
    public boolean enableStyle() {
        return true;
    }

    @Override
    public boolean enableAudio() {
        return true;
    }

    @Override
    public boolean enableAnimation() {
        return true;
    }
}
