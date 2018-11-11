package com.example.qhs.myplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

public class PlayListDialogActivity extends AppCompatActivity {

    private Button btnPlylistOK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setContentView(R.layout.activity_play_list_dialog);

        btnPlylistOK = (Button) findViewById(R.id.btnPlylistOK);
        btnPlylistOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),RecyclerActivity.class);
                startActivity(intent);
            }
        });
    }
}
