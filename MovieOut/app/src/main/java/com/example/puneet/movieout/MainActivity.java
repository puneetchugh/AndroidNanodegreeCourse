package com.example.puneet.movieout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import com.example.puneet.movieout.R.*;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private GridLayoutManager gridLayoutManager;
    private List<String> movieList;
  //  RecyclerViewClass rcAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayoutManager = new GridLayoutManager(MainActivity.this, 4);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(gridLayoutManager);

        movieList = testingMovies();

        RecyclerViewClass rcAdapter = new RecyclerViewClass(movieList);
        rView.setAdapter(rcAdapter);
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

    public List<String> testingMovies(){

        List<String> newList = new ArrayList<>();
        newList.add("Hum-Tim");
        newList.add("HUmSafar");
        newList.add("Gumshuda");
        newList.add("Josh");
        newList.add("Tiranga");
        newList.add("Satyam Shivam Sundaram");
        newList.add("Sholay");
        return newList;
    }
}
