package com.example.puneet.movieout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by puneet on 3/24/16.
 */
public class MySQLiteDatabase extends SQLiteOpenHelper {

    public static final String TABLE_MOVIES = "movies";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_MOVIE_NAME = "movie";
    public static final String COLUMN_MOVIE_DATE = "date";
    public static final String COLUMN_MOVIE_RATING = "rating";
    public static final String COLUMN_MOVIE_OVERVIEW = "overview";
    public static final String COLUMN_MOVIE_ID = "id";
    public static final String COLUMN_MOVIE_YOUTUBE = "youtube";
    public static final String COLUMN_MOVIE_POSTER = "poster";
    //public static final String COLUMN_

    private static final String DATABASE_NAME = "movies.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table " + TABLE_MOVIES + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_MOVIE_NAME + " text not null, "
            + COLUMN_MOVIE_DATE + " text not null, "
            + COLUMN_MOVIE_RATING + " double not null, "
            + COLUMN_MOVIE_OVERVIEW + " text not null, "
            + COLUMN_MOVIE_ID + " integer not null, "
            + COLUMN_MOVIE_YOUTUBE + " text not null, "
            + COLUMN_MOVIE_POSTER + " text not null);";


    public MySQLiteDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteDatabase.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOVIES);

        onCreate(db);
    }

}