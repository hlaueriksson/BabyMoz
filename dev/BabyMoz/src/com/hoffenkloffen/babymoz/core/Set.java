package com.hoffenkloffen.babymoz.core;

import java.util.ArrayList;

public class Set {

    private String locale;
    private String description;
    private Audio audio;

    private ArrayList<Screen> items = new ArrayList<Screen>();

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public ArrayList<Screen> getItems() {
        return items;
    }

    public void addItem(Screen screen) {
        screen.setParent(this);
        items.add(screen);
    }

    public void addItem(Symbol symbol) {
        addItem(new Screen(symbol));
    }

    public void addItem(Image image) {
        addItem(new Screen(image));
    }
}
