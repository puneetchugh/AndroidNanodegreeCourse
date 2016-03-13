package com.example.puneet.movieout;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by puneet on 3/7/16.
 */
public interface FetchMovie {

    @GET("/3/discover/movie?api_key=83e1104fe785f2505827544e570b1755&sort_by=popularity.desc")
    Call<MovieData> getPopularMovies();

    @GET("/3/discover/movie/?api_key=83e1104fe785f2505827544e570b1755&sort_by=vote_average.desc")
    Call<MovieData> getTopRatedMovies();

}

