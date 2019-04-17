package com.example.myvideoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoview = findViewById(R.id.videoView);
        videoview.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.intro);
        videoview.start();

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoview);
        videoview.setMediaController(mediaController);

    }
}
