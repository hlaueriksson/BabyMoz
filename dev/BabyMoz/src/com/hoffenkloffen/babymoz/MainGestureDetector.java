package com.hoffenkloffen.babymoz;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.hoffenkloffen.babymoz.core.Direction;

public class MainGestureDetector extends GestureDetector.SimpleOnGestureListener {

    private static final String TAG = "MainGestureDetector";

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

    private UpdateManager manager;

    public MainGestureDetector(UpdateManager manager) {
        setManager(manager);
    }

    public void setManager(UpdateManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        try {
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH) return false;

            // right to left swipe
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
                manager.update(Direction.NEXT);

            // left to right swipe
            if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY)
                manager.update(Direction.PREVIOUS);
        } catch (Exception e) {
            Log.e(TAG, "onFling failed", e);
        }

        return false;
    }
}
