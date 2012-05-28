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

    @Override
    public String toString()
    {
        return "[" + code + "]";
    }
}
