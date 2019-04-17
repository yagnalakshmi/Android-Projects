package com.example.mytimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final TextView countdown = (TextView)findViewById(R.id.countdown);
      final  TextView result = (TextView)findViewById(R.id.result);

        new CountDownTimer(10000,1000){

            public void onTick(long millisecondsUntilDone){

                countdown.setText("CountDown: " + String.valueOf(millisecondsUntilDone/1000));
            }

            public void onFinish(){

                result.setText("Its Done!!!!");
            }
        }.start();
    }
}
