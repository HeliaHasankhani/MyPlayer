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
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.support.v7.widget.SearchView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


import Model.Music;
import RecyclerAdapter.SearchListAdapter;

public class MainActivity extends AppCompatActivity  implements SearchView.OnQueryTextListener, android.widget.SearchView.OnQueryTextListener {

    // Declare Variables
    ListView listSearch;
    SearchListAdapter adapter;
    android.widget.SearchView editsearch;
    String[] musicNameList;
    ArrayList<Music> arraylist = new ArrayList<Music>();
  
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
      
      //Toolbar
        Toolbar toolbarMain = (Toolbar) findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbarMain);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
      //  Button b1=(Button) findViewById(R.id.b1);

        //Search

        // Generate sample data

        musicNameList = new String[]{"Lion", "Tiger", "Dog",
                "Cat", "Tortoise", "Rat", "Elephant", "Fox",
                "Cow","Donkey","Monkey"};

        // Locate the ListView in listview_main.xml
        listSearch = (ListView) findViewById(R.id.listviewSearch);

        for (int i = 0; i < musicNameList.length; i++) {
          Music musicNames = new Music(musicNameList[i]);
            // Binds all strings into an array
            arraylist.add(musicNames);
        }

        // Pass results to ListViewAdapter Class
        adapter = new SearchListAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        listSearch.setAdapter(adapter);
        listSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"message",Toast.LENGTH_LONG).show();
            }
        });

        // Locate the EditText in listview_main.xml
        editsearch = (android.widget.SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
  //      b1.setOnClickListener(new Button.OnClickListener(){

          //  @Override
          //  public void onClick(View v) {

           //     Intent intent=new Intent(getApplicationContext(),RecyclerActivity.class);
           //     startActivity(intent);
          //  }});
      
      
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
        R.array.musicCategory, android.R.layout.simple_list_item_1);

        ListView listView = (ListView) findViewById(R.id.listViewID);

        listView.setAdapter(adapter1);
        listView.setOnItemClickListener(this);

    }


  @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        Intent intent = new Intent(this, MusicsActivity.class);

        intent.putExtra("CategoryID", position);
        intent.putExtra("CategoryName", adapterView.getItemAtPosition(position).toString());

        startActivity(intent);
    }
        
@Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

@Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
    listSearch.setVisibility(View.VISIBLE);
    //and set listview visibility to GONE again when user erase all text from search editsearch
    if(text.length() == 0){
        listSearch.setVisibility(View.GONE);
    } else {
        listSearch.setVisibility(View.VISIBLE);
    }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
