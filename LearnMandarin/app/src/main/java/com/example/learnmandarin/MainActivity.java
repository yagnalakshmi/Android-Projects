package com.example.learnmandarin;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void playMe(View view){

        int id = view.getId();

        String nameId = view.getResources().getResourceEntryName(id);

      //  Log.i("msg",
      //          "color clicked is"+" "+nameId);
        int res = getResources().getIdentifier(nameId,"raw","com.example.learnmandarin");

        MediaPlayer mediaPlayer = MediaPlayer.create(this,res);

        mediaPlayer.start();



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
