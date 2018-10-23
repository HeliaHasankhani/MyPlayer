package com.example.qhs.myplayer;


import com.example.qhs.myplayer.R;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (SplashActivity.Splash==0){
            Intent intent = new Intent(this,SplashActivity.class);
            startActivity(intent);
            super.onCreate(savedInstanceState);
            finish();
            return;
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
