package com.hoffenkloffen.babymoz.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Library {

    private Set set;

    private ArrayList<Screen> screens = new ArrayList<Screen>();
    
    private int index;

    private int[] colors; // TODO: change to Color[]

    private int[] animations; // TODO: change to Animation[]

    public Library(Set set) {
        setSet(set);
        index = 0;
    }

    private void setSet(Set set) {
        this.set = set;
    }

    public Set getSet() {
        return set;
    }

    public void setColors(int[] colors) {
        this.colors = colors;
    }

    public void setAnimations(int[] animations) {
        this.animations = animations;
    }

    public void init()
    {
        for (Screen screen : set.getItems()) {
            initScreen(screen);
            screens.add(screen);
        }
    }

    private void initScreen(Screen screen) {

        Content content = screen.getContent();

        if(content.enableStyle()) screen.setStyle(generateStyle());
        if(content.enableAudio()) screen.setAudio(generateAudio(screen));
        if(content.enableAnimation()) screen.setAnimation(generateAnimation());
    }

    public void shuffle()
    {
        Screen welcome = getWelcomeScreen();

        if(welcome != null) screens.remove(welcome);

        Collections.shuffle(screens);

        if(welcome != null) screens.add(getFirstScreenIndex(), welcome);
    }

    private Screen getWelcomeScreen()
    {
        Screen screen = screens.get(getFirstScreenIndex());

        if(screen.getContent() instanceof Welcome) return screen;

        return null;
    }

    public void move(Direction direction)
    {
        if(direction == Direction.NEXT && index < getLastScreenIndex()) index++;
        else if(direction == Direction.PREVIOUS && index > getFirstScreenIndex()) index--;
        else if(direction == Direction.NEXT && isLast()) index = getFirstScreenIndex();
        else if(direction == Direction.PREVIOUS && isFirst()) index = getLastScreenIndex();
    }

    private boolean isFirst()
    {
        return index == getFirstScreenIndex();
    }

    private boolean isLast()
    {
        return index == getLastScreenIndex();
    }

    private int getFirstScreenIndex()
    {
        return 0;
    }

    private int getLastScreenIndex()
    {
        return screens.size() - 1;
    }

    public Screen getScreen() {

        return screens.get(index);
    }

    private Style generateStyle() { // TODO: this should be moved somewhere else

        Style style = new Style();
        style.setBackgroundColor(getRandomColor());
        style.setTextColor(getRandomColor());

        if(!style.hasValidContrast()) style.resetTextColor();

        return style;
    }

    private int getRandomColor() {

        if(colors == null) return 0;
        if(colors.length == 0) return 0;

        Random random = new Random();
        int length = colors.length;
        int i = random.nextInt(length); // NOTE: exclusive

        return colors[i];
    }

    private Audio generateAudio(Screen screen) {

        Set parent = screen.getParent();
        Audio master = parent.getAudio();

        if(master == null) return null;

        Audio audio = new Audio();
        audio.setResId(master.getResId());
        audio.setFilename(master.getFilename());
        audio.setDuration(master.getDuration());
        audio.setOffset(master.getDuration() * parent.getItems().indexOf(screen));

        return audio;
    }

    private Animation generateAnimation() {

        int resId = getRandomAnimation();

        if(resId == 0) return null;

        Animation animation = new Animation();
        animation.setResId(resId);

        return animation;
    }

    private int getRandomAnimation() {

        if(animations == null) return 0;
        if(animations.length == 0) return 0;

        Random random = new Random();
        int length = animations.length;
        int i = random.nextInt(length); // NOTE: exclusive

        return animations[i];
    }
}
