package com.example.musicstudio;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void playMe(View view){


        int id = view.getId();
        String nameID = view.getResources().getResourceEntryName(id);
        Log.i("msg","button id is" +" " + nameID);


        int res = getResources().getIdentifier(nameID, "raw", "com.example.musicstudio");
        MediaPlayer mediaPlayer = MediaPlayer.create(this,res );
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
