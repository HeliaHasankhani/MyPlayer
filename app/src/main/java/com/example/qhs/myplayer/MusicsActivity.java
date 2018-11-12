package com.example.qhs.myplayer;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import RecyclerAdapter.ImageAdapter;

public class MusicsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private AlertDialog.Builder alertDialogBuilder;
    private AlertDialog dialog;
    private LayoutInflater inflater;
    private int categoryID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musics);

        //int categoryID = -1;
        String categoryName = "";
        Bundle bundle = getIntent().getExtras();

        if ( bundle != null ){
            categoryID = bundle.getInt("CategoryID");
            categoryName = bundle.getString("CategoryName");
        }


        GridView gridView = (GridView) findViewById(R.id.gridViewID);
        gridView.setAdapter(new ImageAdapter(this, categoryID));

        Toast.makeText(this, categoryName, Toast.LENGTH_LONG).show();

        gridView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View v, int position, long l) {
        // create an AlertDialog
        alertDialogBuilder = new AlertDialog.Builder(this);

        inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.alert_download, null);

        Button noButton = (Button) view.findViewById(R.id.noButton);
        Button yesButton = (Button) view.findViewById(R.id.yesButton);

        alertDialogBuilder.setView(view);
        dialog = alertDialogBuilder.create();
        dialog.show();




//        noButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.dismiss();
//            }
//        });
//
//        yesButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //delete the item.
//                DatabaseHandler db = new DatabaseHandler(context);
//                db.deleteItem(id);
//                groceryItems.remove(getAdapterPosition());
//                notifyItemRemoved(getAdapterPosition());
//
//                dialog.dismiss();
//
//            }
//        });

        Intent intent = new Intent(this, Play1Activity.class);

        String musicID = String.valueOf(categoryID)+String.valueOf(position);

        intent.putExtra("MusicID", musicID);
        //intent.putExtra("CategoryName", adapterView.getItemAtPosition(position).toString());

        startActivity(intent);

    }
}
