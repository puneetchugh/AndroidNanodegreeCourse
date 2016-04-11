package com.example.puneet.movieout;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by puneet on 3/7/16.
 */
public class FragmentOne extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MyAdapter adapter;
    private Context mcontext;
    private static String BASE_URL = "http://api.themoviedb.org";
    private ArrayList<OneMovieData> movieDataArrayList;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstance){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        movieDataArrayList = new ArrayList<>();
        FetchMovie fetchMovie = retrofit.create(FetchMovie.class);
        Call<MovieData> call = fetchMovie.getPopularMovies();
        call.enqueue(new Callback<MovieData>() {
            @Override
            public void onResponse(Call<MovieData> call, Response<MovieData> response) {

                if (!response.isSuccess()) {
                    // print response body if unsuccessful
                    try {
                        System.out.println(response.errorBody().string());
                    } catch (IOException e) {
                        Toast.makeText(getActivity(), "Error in receiving data\nError-code:", Toast.LENGTH_SHORT).show();
                    }
                    return;
                }
                // Log.d("Response",response);
                MovieData movieData = response.body();
                List<Result> result = movieData.getResults();
                int counter = 0;
                if (result != null) {
                    for (Result singleResult : result) {
                        OneMovieData oneMovieData = new OneMovieData(
                                singleResult.getOriginalTitle(),
                                singleResult.getPosterPath(),
                                singleResult.getOverview(),
                                singleResult.getVoteAverage(),
                                singleResult.getReleaseDate(),
                                singleResult.getId());
                        movieDataArrayList.add(counter, oneMovieData);
                    }
                }
                recyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);

                mcontext = getActivity();
                layoutManager = new GridLayoutManager(mcontext, 2, LinearLayoutManager.VERTICAL, false);
                adapter = new MyAdapter(movieDataArrayList, mcontext, new MovieItemClickListener() {
                    @Override
                    public void onMovieClick(OneMovieData oneMovieData) {
                        // send oneMovieData back to main activity here
                    }
                });


                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<MovieData> call, Throwable t) {

            }
        });




        return layoutInflater.inflate(R.layout.fragment_one, container, false);
    }
}
