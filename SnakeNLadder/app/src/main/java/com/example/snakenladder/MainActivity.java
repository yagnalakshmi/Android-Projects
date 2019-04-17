package com.example.snakenladder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public void rollDice(View view){

        int[] myDice = {
                R.drawable.one,
                R.drawable.two,
                R.drawable.three,
                R.drawable.four,
                R.drawable.five,
                R.drawable.six

        };
        Random ran = new Random();
        int randomNumber = ran.nextInt(6);

        ImageView dice = (ImageView) findViewById(R.id.dice);

        dice.setImageResource(myDice[randomNumber]);




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
