package com.example.qhs.myplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import Data.SampleData;
import Model.Music;
import RecyclerAdapter.PlayListAdapter;

public class RecyclerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Music> listMusics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView=(RecyclerView) findViewById(R.id.PlaylistRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        listMusics=new ArrayList<>();


        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarOther);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        //Recycler
        listMusics=SampleData.addSampleData();
        adapter=new PlayListAdapter(this,listMusics);
        recyclerView.setAdapter(adapter);
    }
}
