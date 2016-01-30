package com.example.puneet.myportfolio;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    Button popularMovies1;
    Button popularMovies2;
    Button superDuo1;
    Button goUbiquitous;
    Button capstoneStage1;
    Button capstoneStage2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        popularMovies1 = (Button) findViewById(R.id.popular_movies_1);
        popularMovies1.setOnClickListener(this);
        popularMovies2 = (Button) findViewById(R.id.popular_movies_2);
        popularMovies2.setOnClickListener(this);
        superDuo1 = (Button) findViewById(R.id.super_duo_1);
        superDuo1.setOnClickListener(this);
        goUbiquitous = (Button) findViewById(R.id.go_ubiquitous);
        goUbiquitous.setOnClickListener(this);
        capstoneStage1 = (Button) findViewById(R.id.capstone_stage_1);
        capstoneStage1.setOnClickListener(this);
        capstoneStage2 = (Button) findViewById(R.id.capstone_stage_2);
        capstoneStage2.setOnClickListener(this);
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

    public void onClick(View view) {
        if (view == popularMovies1) {
            Toast.makeText(MainActivity.this, "This will show the  Popular Movies 1 App", Toast.LENGTH_SHORT).show();
        }

        if (view == popularMovies2) {
            Toast.makeText(MainActivity.this, "This will show the Popular Movies 2 App", Toast.LENGTH_SHORT).show();
        }

        if (view == superDuo1) {
            Toast.makeText(MainActivity.this, "This will show the Super Duo 1 App", Toast.LENGTH_SHORT).show();
        }

        if (view == goUbiquitous) {
            Toast.makeText(MainActivity.this, "This will show the Go Ubiquitous App", Toast.LENGTH_SHORT).show();
        }

        if (view == capstoneStage1) {
            Toast.makeText(MainActivity.this, "This will show the first stage of Capstone App", Toast.LENGTH_SHORT).show();

        }

        if(view == capstoneStage2){
            Toast.makeText(MainActivity.this, "This will show the second stage of Capstone App", Toast.LENGTH_SHORT).show();
        }
    }


}
