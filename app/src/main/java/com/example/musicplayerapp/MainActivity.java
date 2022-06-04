package com.example.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
{
    MediaPlayer player;
    AudioManager audioManager;
    // for playing the music
    public void musicplay(View view)
    {
        player.start();
    }

    // for pausing the music
    public void musicpause(View view)
    {
        player.pause();
    }

    // for stopping the music
    public void musicstop(View view)
    {
        player.stop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = MediaPlayer.create(this, R.raw.sound);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final SeekBar seekProg = findViewById(R.id.seekBar2);
        seekProg.setMax(player.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekProg.setProgress(player.getCurrentPosition());
            }
        }, 0, 900);

        seekProg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                player.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
