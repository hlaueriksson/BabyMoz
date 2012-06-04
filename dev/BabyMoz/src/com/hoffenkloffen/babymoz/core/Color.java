package com.hoffenkloffen.babymoz.core;

public class Color {

    private int code;

    public Color(int code) {
        setCode(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getRed()
    {
        return (code >> 16) & 0xFF;
    }

    public int getGreen()
    {
        return (code >> 8) & 0xFF;
    }

    public int getBlue()
    {
        return (code >> 0) & 0xFF;
    }

    public int getContrastColor()
    {
        int black = -16777216;
        int white = -1;
        int gray = -8355712;

        return code > gray ? black : white;
    }

    @Override
    public String toString()
    {
        return "[" + code + "]";
    }
}
