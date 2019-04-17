package com.example.starapp;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class secondAcitivity extends AppCompatActivity {

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acitivity);

        TextView disColor = findViewById(R.id.displayColor);

        ImageView star = findViewById(R.id.imageView);
        star.setImageResource(R.drawable.blue);
        Intent intent = getIntent();
       String displayColor = intent.getStringExtra("name");
       disColor.setText(displayColor);

        star.setImageResource(getImageId(this, displayColor));


    }
}
