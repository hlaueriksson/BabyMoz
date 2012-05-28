package com.hoffenkloffen.babymoz;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import com.hoffenkloffen.babymoz.core.Audio;

public class MainAudioManager implements AudioManager, MediaPlayer.OnSeekCompleteListener {

    private static final String TAG = "MainAudioManager";

    private Handler handler;
    private MediaPlayer player;
    private Audio current;

    public MainAudioManager(Context context, int resId) {

        handler = new Handler();

        player = MediaPlayer.create(context, resId);
        player.setOnSeekCompleteListener(this);

        Log.d(TAG, "Loaded audio: " + resId);
    }

    @Override
    public void play(Audio audio) {

        Log.d(TAG, "Play. Offset: " + audio.getOffset() + " Duration: " + audio.getDuration());

        current = audio;

        player.seekTo(audio.getOffset()); // NOTE: will start the player via the OnSeekCompleteListener
    }

    private void pause() {

        player.pause();

        Log.d(TAG, "Pause");
    }

    @Override
    public void onSeekComplete(MediaPlayer mediaPlayer) {

        player.start();

        handler.postDelayed(new Runnable() {
            public void run() {
                pause();
            }
        }, current.getDuration()); // NOTE: will pause the player after the given duration
    }
}
