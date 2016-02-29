package com.example.puneet.fragmentsandloaders;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by puneet on 2/15/16.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

        public static final String TABLE_PERSON = "comments";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_NAME = "comment";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PHONE = "phone";

        private static final String DATABASE_NAME = "persons.db";
        private static final int DATABASE_VERSION = 1;

        // Database creation sql statement
        private static final String DATABASE_CREATE = "create table "
                + TABLE_PERSON + "(" + COLUMN_ID
                + " integer primary key autoincrement, " + COLUMN_NAME
                + " text not null" + COLUMN_EMAIL + "text not null" + COLUMN_PHONE + "text not null);";

        public MySQLiteHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase database) {
            database.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(MySQLiteHelper.class.getName(),
                    "Upgrading database from version " + oldVersion + " to "
                            + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);
            onCreate(db);
        }

    }
