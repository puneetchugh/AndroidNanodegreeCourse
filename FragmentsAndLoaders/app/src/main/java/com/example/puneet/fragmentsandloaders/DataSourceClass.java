package com.example.puneet.fragmentsandloaders;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by puneet on 2/15/16.
 */
public class DataSourceClass {

    private MySQLiteHelper mySQLiteHelper;
    private SQLiteDatabase sqLiteDatabase;

    public DataSourceClass(Context context){
        mySQLiteHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException{

        sqLiteDatabase = mySQLiteHelper.getWritableDatabase();
    }

    public void close(){
        mySQLiteHelper.close();

    }

    public List<Person> getAllRecords(){

        List<Person> newPerson = new ArrayList<>();
        return newPerson;

    }
/*
    public Person getARecord(){


    }*/
}

