package com.hoffenkloffen.babymoz;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hoffenkloffen.babymoz.core.*;

public class MainScreenManager implements ScreenManager {

    private static final String TAG = "MainScreenManager";

    protected ResourceManager manager;
    protected View layout;
    protected TextView textView;
    protected ImageView imageView;

    public MainScreenManager(ResourceManager manager, View layout, TextView textView, ImageView imageView)
    {
        this.manager = manager;
        this.layout = layout;
        this.textView = textView;
        this.imageView = imageView;
    }

    @Override
    public void display(Content content) {

        if (content instanceof Symbol) display((Symbol) content);
        if (content instanceof Image) display((Image) content);
    }

    private void display(Symbol symbol) {

        textView.setVisibility(View.VISIBLE);
        textView.setText(symbol.getText());

        imageView.setVisibility(View.GONE);

        Log.d(TAG, "Display symbol: " + symbol.getText());
    }

    private void display(Image image) {

        layout.setBackgroundColor(android.graphics.Color.WHITE);

        imageView.setVisibility(View.VISIBLE);
        imageView.setImageResource(manager.getResId(image));

        textView.setVisibility(View.GONE);

        Log.d(TAG, "Display image: " + image);
    }

    @Override
    public void apply(Style style) {

        layout.setBackgroundColor(style.getBackgroundColor());

        textView.setBackgroundColor(style.getBackgroundColor());
        textView.setTextColor(style.getTextColor());

        Log.d(TAG, "Apply style; BackgroundColor: " + style.getBackgroundColor() + " TextColor: " + style.getTextColor());
    }

    @Override
    public void start(Animation animation) {

        textView.startAnimation(manager.getAnimation(animation));

        Log.d(TAG, "Start animation: " + animation);
    }
}
