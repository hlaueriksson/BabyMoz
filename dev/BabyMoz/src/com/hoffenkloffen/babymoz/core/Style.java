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
        return calculateContrast() > 5;
    }

    public double calculateContrast() {

        // NOTE: Luminosity Contrast

        Color background = getBackground();
        Color text = getText();

        double luminosity1 =
                0.2126 * Math.pow(background.getRed() / 255, 2.2) +
                0.7152 * Math.pow(background.getGreen() / 255, 2.2) +
                0.0722 * Math.pow(background.getBlue() / 255, 2.2);

        double luminosity2 =
                0.2126 * Math.pow(text.getRed() / 255, 2.2) +
                0.7152 * Math.pow(text.getGreen() / 255, 2.2) +
                0.0722 * Math.pow(text.getBlue() / 255, 2.2);

        if (luminosity1 > luminosity2) return (luminosity1 + 0.05) / (luminosity2 + 0.05);

        return (luminosity2 + 0.05) / (luminosity1 + 0.05);
    }

    private Color getBackground() {
        return new Color(getBackgroundColor());
    }

    private Color getText() {
        return new Color(getTextColor());
    }

    public static Style getDefault() {

        Style style = new Style();
        style.setBackgroundColor(-16776961); // Blue
        style.setTextColor(-256); // Yellow

        return style; // Sweden :)
    }

    public void resetTextColor() {
        setTextColor(getBackground().getContrastColor());
    }
}
