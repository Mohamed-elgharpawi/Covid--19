package com.example.covid_19.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.example.covid_19.R;
import com.example.covid_19.utilities.TypeWriter;

public class splash extends AppCompatActivity {

    TypeWriter tw;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        tw = (TypeWriter) findViewById(R.id.slogan);
        logo=findViewById(R.id.logo);
        logo.setImageResource(R.mipmap.virus);
        tw.setText("");
        tw.setCharacterDelay(100);
        tw.animateText("Stay Home Stay Save");
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
