package com.hoffenkloffen.babymoz;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import com.hoffenkloffen.babymoz.core.Audio;

public class MainAudioManager implements AudioManager, MediaPlayer.OnSeekCompleteListener {

    private static final String TAG = MainAudioManager.class.getSimpleName();

    private Handler handler;
    private Runnable runnable;

    private MediaPlayer player;
    private Audio current;

    public MainAudioManager(Context context, int resId) {

        handler = new Handler();
        runnable = new Runnable() {
            public void run() {
                pause();
            }
        };

        player = MediaPlayer.create(context, resId);

        if(player == null) return;

        player.setOnSeekCompleteListener(this);

        Log.d(TAG, "Loaded audio: " + resId);
    }

    @Override
    public void play(Audio audio) {

        if(player == null) return;

        if(player.isPlaying()) pause(); // FIX: when swiping fast through the screens the sound was out of sync

        current = audio;

        player.seekTo(audio.getOffset()); // NOTE: will start the player via the OnSeekCompleteListener

        Log.d(TAG, "Play. Offset: " + audio.getOffset() + " Duration: " + audio.getDuration());
    }

    private void pause() {

        if(player == null) return;

        player.pause();

        Log.d(TAG, "Pause");
    }

    @Override
    public void onSeekComplete(MediaPlayer mediaPlayer) {

        player.start();

        handler.removeCallbacks(runnable); // FIX: when swiping fast through the screens the sound was out of sync

        handler.postDelayed(runnable, current.getDuration()); // NOTE: will pause the player after the given duration
    }

    public void release()
    {
        if(player == null) return;

        player.release();
    }
}
