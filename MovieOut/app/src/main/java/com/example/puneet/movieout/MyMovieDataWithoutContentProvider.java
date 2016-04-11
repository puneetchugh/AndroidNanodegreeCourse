package com.example.puneet.movieout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by puneet on 3/26/16.
 */
public class MyMovieDataWithoutContentProvider  {


    private MySQLiteDatabase mySQLiteDatabase;
    private SQLiteDatabase sqLiteDatabase;
    private Context context;

    public MyMovieDataWithoutContentProvider(Context context){
        mySQLiteDatabase = new MySQLiteDatabase(context);
        this.context = context;

    }

    public long insertData(OneMovieData oneMovieData){

        sqLiteDatabase = mySQLiteDatabase.getReadableDatabase();
        Cursor checkingCursor = sqLiteDatabase.rawQuery("SELECT * FROM " + MySQLiteDatabase.TABLE_MOVIES + " WHERE " + MySQLiteDatabase.COLUMN_MOVIE_NAME + "= " + "'" + oneMovieData.getOriginalTitle() + "';", null);

        if(checkingCursor.moveToFirst()){
            Toast.makeText(context, "This Movie already exists in the database",Toast.LENGTH_SHORT).show();
            checkingCursor.close();
            return 0;
        }

        checkingCursor.close();
        sqLiteDatabase = mySQLiteDatabase.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MySQLiteDatabase.COLUMN_MOVIE_NAME, oneMovieData.getOriginalTitle());
        contentValues.put(MySQLiteDatabase.COLUMN_MOVIE_ID, "");
        contentValues.put(MySQLiteDatabase.COLUMN_MOVIE_OVERVIEW, oneMovieData.getOverview());
        contentValues.put(MySQLiteDatabase.COLUMN_MOVIE_DATE, oneMovieData.getReleaseDate());
        contentValues.put(MySQLiteDatabase.COLUMN_MOVIE_YOUTUBE, "");
        contentValues.put(MySQLiteDatabase.COLUMN_MOVIE_RATING, oneMovieData.getUserRating());
        contentValues.put(MySQLiteDatabase.COLUMN_MOVIE_POSTER, oneMovieData.getMoviePoster());
        long id = sqLiteDatabase.insert(MySQLiteDatabase.TABLE_MOVIES, null, contentValues);
        sqLiteDatabase.close();

        return id;

    }

    public ArrayList<OneMovieData> retrieveData(){
        sqLiteDatabase = mySQLiteDatabase.getReadableDatabase();

        ArrayList<OneMovieData> arrayList = new ArrayList<>();
        OneMovieData oneMovieData;
        Cursor cursor = sqLiteDatabase.query(MySQLiteDatabase.TABLE_MOVIES, null, null, null, null, null, null);




        if(!cursor.moveToFirst()){
            Toast.makeText(context, "There's no data in the Database", Toast.LENGTH_SHORT).show();
            return null;
        }

        arrayList = cursorToMovie(cursor);
        cursor.close();
        sqLiteDatabase.close();
        return arrayList;
    }

    public ArrayList<OneMovieData> cursorToMovie(Cursor cursor){

        OneMovieData oneMovieData;
        ArrayList<OneMovieData> arrayList = new ArrayList<>();

        int nameIndex = cursor.getColumnIndex(MySQLiteDatabase.COLUMN_MOVIE_NAME);
        int dateIndex = cursor.getColumnIndex(MySQLiteDatabase.COLUMN_MOVIE_DATE);
        int ratingIndex = cursor.getColumnIndex(MySQLiteDatabase.COLUMN_MOVIE_RATING);
        int overviewIndex = cursor.getColumnIndex(MySQLiteDatabase.COLUMN_MOVIE_OVERVIEW);
        int idIndex = cursor.getColumnIndex(MySQLiteDatabase.COLUMN_MOVIE_ID);
        int youtubeIndex = cursor.getColumnIndex(MySQLiteDatabase.COLUMN_MOVIE_YOUTUBE);
        int posterIndex = cursor.getColumnIndex(MySQLiteDatabase.COLUMN_MOVIE_POSTER);
        while(!cursor.isAfterLast()){

            String name = cursor.getString(nameIndex);
            String date = cursor.getString(dateIndex);
            double rating = cursor.getDouble(ratingIndex);
            String overview = cursor.getString(overviewIndex);
            int id = cursor.getInt(idIndex);
            String youtube = cursor.getString(youtubeIndex);
            String poster = cursor.getString(posterIndex);
            oneMovieData = new OneMovieData(name, poster, overview, rating, date,id);
            arrayList.add(oneMovieData);
            cursor.moveToNext();
        }
        return arrayList;
    }

    public int deleteData(int position){

        Cursor cursor = sqLiteDatabase.query(MySQLiteDatabase.TABLE_MOVIES, null, null, null, null, null, null);
        int result = sqLiteDatabase.delete(MySQLiteDatabase.TABLE_MOVIES, MySQLiteDatabase.COLUMN_ID + "=?", new String[]{Integer.toString(position)});

        cursor.close();
        return result;



    }

}
