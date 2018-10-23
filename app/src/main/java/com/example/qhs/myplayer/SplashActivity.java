package com.example.qhs.myplayer;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
    public static int Splash = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Splash++;
                callMain();
            }
        },2000);
    }

    private void callMain() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        SplashActivity.this.finish();
    }
}

