package com.hoffenkloffen.babymoz.core;

public class Style {

    private int backgroundColor;
    private int textColor;

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public boolean hasValidContrast() {
        return backgroundColor != textColor;
    }

    public static Style getDefault() {

        Style style = new Style();
        style.setBackgroundColor(-16776961); // Blue
        style.setTextColor(-256); // Yellow

        return style; // Sweden :)
    }
}
