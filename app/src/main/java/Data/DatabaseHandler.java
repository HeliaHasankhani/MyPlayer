package Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.Item;
import Util.Utils;

/**
 * Created by QHS on 27/09/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private Context ctx;

    public DatabaseHandler(@Nullable Context context) {
        super(context, Utils.DATABASE_NAME, null, Utils.DARABASE_VERSION);
        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQL - Structured Query Language
        String CREATE_PLAYLIST_TABLE = "CREATE TABLE " + Utils.TABLE_NAME + "("
                + Utils.KEY_ID + " INTEGER PRIMARY KEY," + Utils.KEY_NAME + " TEXT,"
                + Utils.KEY_MUSICS + " ARRAYLIST);";

        db.execSQL(CREATE_PLAYLIST_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Dropping id deleting the table!
        db.execSQL("DROP TABLE IF EXISTS " + Utils.TABLE_NAME);

        //CREATE TABLE AGAIN
        onCreate(db);
    }

    /**
     *  CRUD Operation - Create, Read, Update, Delete
     */
    public void addItem(Item item){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utils.KEY_NAME, item.getName());
        values.put(Utils.KEY_MUSICS, item.getMusics().toString());

        //Insert to row
        db.insert(Utils.TABLE_NAME, null, values);
        Log.d("saved!!", "Saved to DB");
        db.close();
    }

    public Item getItem(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Utils.TABLE_NAME, new String[]{Utils.KEY_ID,
                        Utils.KEY_NAME, Utils.KEY_MUSICS},
                Utils.KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Item item = new Item();
        item.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Utils.KEY_ID))));
        item.setName(cursor.getString(cursor.getColumnIndex(Utils.KEY_NAME)));
        item.setMusics(Arrays.asList(cursor.getString(cursor.getColumnIndex(Utils.KEY_MUSICS))));

        return item;
    }

    //Get all PlayLists
    public List<Item> getAllItems(){
        SQLiteDatabase db = this.getReadableDatabase();

        List<Item> playLists = new ArrayList<>();

        //Select all PlayList
        String selectAll = "SELECT * FROM " + Utils.TABLE_NAME;
        Cursor cursor = db.rawQuery(selectAll, null);

        //Loop through our Grocery
        if (cursor.moveToFirst()){
            do {
                Item item = new Item();
                item.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Utils.KEY_ID))));
                item.setName(cursor.getString(cursor.getColumnIndex(Utils.KEY_NAME)));
                item.setMusics(Arrays.asList(cursor.getString(cursor.getColumnIndex(Utils.KEY_MUSICS))));


                playLists.add(item);

            }while (cursor.moveToNext());
        }
        return playLists;
    }
    private static final String SEPARATOR = ",";

    public int updateItem(Item item){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utils.KEY_NAME, item.getName());


        StringBuilder csvBuilder = new StringBuilder();

        for(String song : item.getMusics()){
            csvBuilder.append(song);
            csvBuilder.append(SEPARATOR);
        }

        String csv = csvBuilder.toString();
        //System.out.println(csv);
        //OUTPUT: Milan,London,New York,San Francisco,

        //Remove last comma
        csv = csv.substring(0, csv.length() - SEPARATOR.length());

        //System.out.println(csv);
        //OUTPUT: Milan,London,New York,San Francisco

        //String musicsCommaSeparated = String.join(",", item.getMusics());
        values.put(Utils.KEY_MUSICS, csv);
        //values.put(Utils.KEY_MUSICS, item.getMusics().toString());

        // Update row
        return db.update(Utils.TABLE_NAME, values, Utils.KEY_ID + "=?",
                new String[]{String.valueOf(item.getId())});

    }

    public void deleteItem(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(Utils.TABLE_NAME, Utils.KEY_ID + "=?",
                new String[]{String.valueOf(id)});

        db.close();

    }

    // Get PlayLists count
    public int getPlayListCount(){
        String countQuery = "SELECT * FROM " + Utils.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        return cursor.getCount();
    }

    public List<String> getSongsOfPlaylist (int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        List<Item> playLists = new ArrayList<>();

        //Select PlayList with id
        String selectAll = "SELECT " + Utils.KEY_MUSICS + " FROM " + Utils.TABLE_NAME + " WHERE " + Utils.KEY_ID + "=" +
                new String[]{String.valueOf(id)};

        return Arrays.asList(selectAll);

    }

    public int addToPlaylist(int listID, int songID){

        String selectAll = "SELECT " + Utils.KEY_MUSICS + " FROM " + Utils.TABLE_NAME + " WHERE " + Utils.KEY_ID + "=" +
                new String[]{String.valueOf(listID)};

        List<String> listOfSongs = Arrays.asList(selectAll);
        listOfSongs.add(String.valueOf(songID));

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(Utils.KEY_MUSICS, listOfSongs.toString());


        // Update row
        return db.update(Utils.TABLE_NAME, values, Utils.KEY_ID + "=?",
                new String[]{String.valueOf(listID)});




    }
}
