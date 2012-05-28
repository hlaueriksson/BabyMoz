package com.hoffenkloffen.babymoz.core;

public class Audio extends Resource {

    private int offset;
    private int duration;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String getType() {
        return "raw";
    }
}
