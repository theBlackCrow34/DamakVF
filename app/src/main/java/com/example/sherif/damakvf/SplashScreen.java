package com.example.sherif.damakvf;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class SplashScreen extends AppCompatActivity {

    public static ArrayList<Request> arrayList;
    private final int SPLASH_DISPLAY_LENGHT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //no horizonal
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        arrayList =new ArrayList<>();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),LogIn.class);
                startActivity(intent);
            }
        },SPLASH_DISPLAY_LENGHT);
    }
}
