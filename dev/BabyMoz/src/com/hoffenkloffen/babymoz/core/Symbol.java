package com.hoffenkloffen.babymoz.core;

public class Symbol implements Content {

    private String text;

    public Symbol(String text) {
        setText(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString()
    {
        return text;
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
