package com.example.puneet.movieout;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.widget.Toast;

/**
 * Created by puneet on 3/24/16.
 */
public class MyMovieData extends ContentProvider {

    public static final String PROVIDER_NAME = "com.example.puneet.provider.Movie";
    public static final String URL = "content://"+PROVIDER_NAME+"/Movies";
    public static final Uri CONTENT_URI= Uri.parse(URL);
    // Database fields
    private SQLiteDatabase database;
    private MySQLiteDatabase dbHelper;
    private String[] allColumns = { MySQLiteDatabase.COLUMN_ID,
            MySQLiteDatabase.COLUMN_MOVIE_NAME,
            MySQLiteDatabase.COLUMN_MOVIE_DATE,
            MySQLiteDatabase.COLUMN_MOVIE_RATING,
            MySQLiteDatabase.COLUMN_MOVIE_OVERVIEW,
            MySQLiteDatabase.COLUMN_MOVIE_ID,
            MySQLiteDatabase.COLUMN_MOVIE_YOUTUBE};

    public MyMovieData(){

    }

    /*
    public MyMovieData(Context context) {
        dbHelper = new MySQLiteDatabase(context);
    }*/



    public void close() {
        dbHelper.close();
    }



    @Override
    public boolean onCreate() {
        dbHelper = new MySQLiteDatabase(getContext());
        database = dbHelper.getWritableDatabase();
        return (database == null)? false : true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();
        if(sortOrder == null || sortOrder == ""){
            sortOrder = MySQLiteDatabase.COLUMN_MOVIE_ID;
        }
        sqLiteQueryBuilder.setTables(MySQLiteDatabase.TABLE_MOVIES);

        Cursor cursor = sqLiteQueryBuilder.query(database, projection, selection, selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
        //return null;
    }

    @Override
    public String getType(Uri uri) {
        return "Movie Database";
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long rowId = database.insert(MySQLiteDatabase.TABLE_MOVIES,"",values);
        if(rowId > 0){
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(_uri,null);
            return _uri;
        }
        return null;
        //throw new SQLException();
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int count = 0;
        count = database.delete(MySQLiteDatabase.TABLE_MOVIES, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri,null);
        return count;
        //return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int count = 0;
        count = database.update(MySQLiteDatabase.TABLE_MOVIES, values, selection, selectionArgs);
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
        //return 0;
    }

    public void addMovie(){

        ContentValues contentValues = new ContentValues();
        contentValues.put(MySQLiteDatabase.COLUMN_MOVIE_NAME, "Sholay");
        contentValues.put(MySQLiteDatabase.COLUMN_MOVIE_ID, "1100");
        contentValues.put(MySQLiteDatabase.COLUMN_MOVIE_DATE, "2015-08-23");
        contentValues.put(MySQLiteDatabase.COLUMN_MOVIE_OVERVIEW, "This a new version of old movie");
        contentValues.put(MySQLiteDatabase.COLUMN_MOVIE_RATING,  "2.4");
        contentValues.put(MySQLiteDatabase.COLUMN_MOVIE_YOUTUBE, "wxyz");
        Uri uri = getContext().getContentResolver().insert(CONTENT_URI, contentValues);
        Toast.makeText(getContext(), "One Movie added to record", Toast.LENGTH_SHORT).show();
    }

    public void getMovie(){

        Cursor cursor = getContext().getContentResolver().query(CONTENT_URI, null, null, null, null);
        if(cursor == null){
            Toast.makeText(getContext(), "There are no movies in the Database", Toast.LENGTH_SHORT).show();
            return;
        }
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){

            cursor.moveToNext();

        }

    }

    public void deleteMovies(){
        String[] string = new String[2];
        string[0] = "1";
        int count = getContext().getContentResolver().delete(CONTENT_URI, MySQLiteDatabase.COLUMN_ID +" = ?", string);
    }
}


