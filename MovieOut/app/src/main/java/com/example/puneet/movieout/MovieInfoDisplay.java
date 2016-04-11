package com.example.puneet.movieout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class MovieInfoDisplay extends AppCompatActivity  {

    private ImageView moviePoster;
    private TextView movieName;
    private TextView actualMovieName;
    private TextView userRating;
    private TextView actualuserRating;
    private TextView releaseDate;
    private TextView actualReleaseDate;
    private TextView overview;
    private TextView actualOverview;
    private Intent intent;
    private OneMovieData oneMovieData;
    private Toolbar toolbar;
    private ImageButton imageButton;

    private MyMovieDataWithoutContentProvider myMovieDataWithoutContentProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info_display);


        moviePoster = (ImageView) findViewById(R.id.imageView);
        actualMovieName = (TextView) findViewById(R.id.textView2);
        userRating = (TextView) findViewById(R.id.textView3);
        actualuserRating = (TextView) findViewById(R.id.textView4);
        releaseDate = (TextView)findViewById(R.id.textView5);
        actualReleaseDate = (TextView) findViewById(R.id.textView6);
        overview = (TextView)findViewById(R.id.textView7);
        actualOverview = (TextView) findViewById(R.id.textView8);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.actionbarT);
        imageButton = (ImageButton)findViewById(R.id.favorite_star);
        setSupportActionBar(toolbar);


        intent = getIntent();

        oneMovieData = intent.getExtras().getParcelable("MOVIE_DATA");

        myMovieDataWithoutContentProvider = new MyMovieDataWithoutContentProvider(getApplicationContext());


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton.setSelected(true);
                myMovieDataWithoutContentProvider.insertData(oneMovieData);
            }
        });

        if(oneMovieData.getMoviePoster() == null){
            moviePoster.setImageResource(R.drawable.noposter);
        }
        else {
            Picasso.with(getApplicationContext())
                    .load("http://image.tmdb.org/t/p/w500/" + oneMovieData.getMoviePoster())
                    .into(moviePoster);
        }

        actualMovieName.setText(oneMovieData.getOriginalTitle());
        actualuserRating.setText(oneMovieData.getUserRating().toString());
        actualReleaseDate.setText(oneMovieData.getReleaseDate());
        if(oneMovieData.getOverview() == null){
            actualOverview.setText("No overview available");
        }
        else {
            actualOverview.setText(oneMovieData.getOverview());
        }

        moviePoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MyYouTubePlayer.class);
                startActivity(intent);
                //moviePoster.setVisibility(View.INVISIBLE);
                //youTubeView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie_info_display, menu);
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



}
