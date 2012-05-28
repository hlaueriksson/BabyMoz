package com.hoffenkloffen.babymoz.core;

public class Screen
{
    private Set parent;
    private Content content;
    private Style style;
    private Audio audio;
    private Animation animation;

    public Set getParent() {
        return parent;
    }

    public void setParent(Set parent) {
        this.parent = parent;
    }

    public Screen(Content content) {
        setContent(content);
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    @Override
    public String toString()
    {
        return content.toString();
    }
}
