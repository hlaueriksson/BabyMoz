package com.hoffenkloffen.babymoz.core;

public abstract class Resource {

    private int resId;
    private String filename;

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public abstract String getType();
}
