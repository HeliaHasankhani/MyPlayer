package com.example.qhs.myplayer;


import com.example.qhs.myplayer.R;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

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

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.musicCategory, android.R.layout.simple_list_item_1);

        ListView listView = (ListView) findViewById(R.id.listViewID);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        Intent intent = new Intent(this, MusicsActivity.class);

        intent.putExtra("CategoryID", position);
        intent.putExtra("CategoryName", adapterView.getItemAtPosition(position).toString());

        startActivity(intent);

    }
}
