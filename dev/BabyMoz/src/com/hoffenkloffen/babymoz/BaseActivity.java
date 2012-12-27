package com.hoffenkloffen.babymoz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.*;
import android.view.animation.AnimationUtils;
import com.hoffenkloffen.babymoz.core.*;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

// TODO:
// animation; bounce
// ViewPager
// Gradle dependencies

// DONE:
// splash screen / images
// Media volume control
// Draw welcome, icon
// Record sound
// About, Help; html content
// Google Play
// ignore.git
// Github
// Color contrast

public abstract class BaseActivity extends Activity implements UpdateManager, ResourceManager
{
    private static final String TAG = "BaseActivity";

    protected ScreenManager screenManager;
    protected AudioManager audioManager;
    protected Preferences preferences;
    protected Library library;

    // GestureDetection
    protected GestureDetector gestureDetector;
    protected View.OnTouchListener gestureListener;

    // PreferenceListener
    protected SharedPreferences.OnSharedPreferenceChangeListener preferenceListener;

    //<editor-fold desc="GestureDetection">

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    protected void initGestureDetection()
    {
        // Gesture detection
        gestureDetector = new GestureDetector(new MainGestureDetector(this));
        gestureListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        };
    }

    //</editor-fold>

    //<editor-fold desc="PreferenceListener">

    protected void initPreferenceListener()
    {
        // NOTE: do not use anonymous inner class, as it will become the target of garbage collection
        preferenceListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                reload(); // NOTE: restart after reconfiguration
                Log.d(TAG, "onSharedPreferenceChanged");
            }
        };

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.registerOnSharedPreferenceChangeListener(preferenceListener);
    }

    //</editor-fold>

    //<editor-fold desc="Menu">

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;

        int id = item.getItemId();

        if (id == R.id.menu_restart) {
            reload();
        } else if (id == R.id.menu_about) {
            intent = new Intent(getBaseContext(), AboutActivity.class);
            startActivity(intent);
        } else if (id == R.id.menu_help) {
            intent = new Intent(getBaseContext(), HelpActivity.class);
            startActivity(intent);
        } else if (id == R.id.menu_preferences) {
            intent = new Intent(getBaseContext(), MainPreferenceActivity.class);
            startActivity(intent); // NOTE: will restart if preferences changed
        }

        return super.onOptionsItemSelected(item);
    }

    //</editor-fold>

    //<editor-fold desc="Initiation">

    protected void setScreenManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    protected void setAudioManager(AudioManager audioManager) {
        this.audioManager = audioManager;
    }

    protected void init()
    {
        // Use volume keys for media
        setVolumeControlStream(android.media.AudioManager.STREAM_MUSIC);

        initGestureDetection();
        initPreferenceListener();

        load();
    }

    protected void load() {

        loadPreferences();
        loadResources();

        update(); // NOTE: displays the first screen
    }

    private void reload() {

        if(audioManager != null) audioManager.release(); // clean up

        load();
    }

    protected void loadPreferences()
    {
        Context ctx = getBaseContext();

        PreferenceLoader loader = new PreferenceLoader();

        preferences = loader.load(ctx);
    }

    protected void loadResources()
    {
        Resources res = getResources();

        ResourceLoader factory = new ResourceLoader();

        try {
            Set set = factory.loadSet(res.getXml(R.xml.set)); // TODO: better error handling
            library = new Library(set);
        } catch (XmlPullParserException e) {
            Log.e(TAG, "loadResources failed.", e);
        } catch (IOException e) {
            Log.e(TAG, "loadResources failed.", e);
        }

        library.setColors(factory.loadColors(res.obtainTypedArray(R.array.colors)));
        library.setAnimations(getAnimations());

        library.init();

        if(preferences.getShuffle()) library.shuffle();

        setAudioManager(new MainAudioManager(getApplicationContext(), getAudio()));
    }

    protected int[] getAnimations() {
        return new int[]{
                R.anim.fade_in,
                R.anim.shake_backslash,
                R.anim.shake_dash,
                R.anim.shake_pipe,
                R.anim.shake_slash,
                R.anim.slide_from_bottom,
                R.anim.slide_from_bottom_left,
                R.anim.slide_from_bottom_right,
                R.anim.slide_from_left,
                R.anim.slide_from_right,
                R.anim.slide_from_top,
                R.anim.slide_from_top_left,
                R.anim.slide_from_top_right,
                R.anim.spin_in_out,
                R.anim.zoom_in_from_bottom_left,
                R.anim.zoom_in_from_bottom_right,
                R.anim.zoom_in_from_center,
                R.anim.zoom_in_from_top_left,
                R.anim.zoom_in_from_top_right,
                R.anim.zoom_in_out,
                R.anim.zoom_out_from_bottom_left,
                R.anim.zoom_out_from_bottom_right,
                R.anim.zoom_out_from_center,
                R.anim.zoom_out_from_top_left,
                R.anim.zoom_out_from_top_right
        };
    }

    protected int getAudio() {
        return R.raw.set;
    }

    //</editor-fold>

    //<editor-fold desc="Update">

    public void update(Direction direction) {

        library.move(direction);

        update();
    }
    
    private void update() {

        Screen screen = library.getScreen();

        display(screen);
        style(screen);
        play(screen);
        animate(screen);
    }

    private void display(Screen screen)
    {
        if(screenManager == null) return;

        Content content = screen.getContent();

        if(content == null) return;

        screenManager.display(content);
    }

    private void style(Screen screen) {

        if(screenManager == null) return;

        Style style = screen.getStyle();

        if(style == null) return;

        screenManager.apply(style);
    }

    private void animate(Screen screen) {

        if(screenManager == null) return;
        if(!preferences.getAnimation()) return;

        Animation animation = screen.getAnimation();

        if(animation == null) return;

        screenManager.start(animation);
    }

    private void play(Screen screen)
    {
        if(audioManager == null) return;
        if(!preferences.getAudio()) return;

        Audio audio = screen.getAudio();

        if(audio == null) return;

        audioManager.play(audio);
    }

    //</editor-fold>

    //<editor-fold desc="Resources">

    @Override
    public int getResId(Resource resource) {

        if(resource.getResId() > 0) return resource.getResId();

        return getApplicationContext().getResources().getIdentifier(resource.getFilename(), resource.getType(), getApplicationContext().getPackageName());
    }

    @Override
    public android.view.animation.Animation getAnimation(Animation animation) {

        return AnimationUtils.loadAnimation(getApplicationContext(), getResId(animation)); // TODO: cache animations?
    }

    //</editor-fold>
}
