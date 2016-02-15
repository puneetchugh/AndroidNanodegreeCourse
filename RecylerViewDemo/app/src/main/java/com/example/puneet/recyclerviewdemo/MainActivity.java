package com.example.puneet.recyclerviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    private RecyclerView rv ;
    private LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recylcer_view);
        rv = (RecyclerView)findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);


        initializeData();
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);

        rv.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<Person> persons;

    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    public void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.puneet));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.puneet));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.puneet));
        persons.add(new Person("Puneet Chugh", "25 years old", R.drawable.puneet));
        persons.add(new Person("Jyoti", "26 years old", R.drawable.puneet));
        persons.add(new Person("Om Chugh", "60 years old", R.drawable.puneet));
        persons.add(new Person("Saroj Chugh", "57 years old", R.drawable.puneet));
    }

}
