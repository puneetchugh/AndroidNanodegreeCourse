package com.example.puneet.fragmentsandloaders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by puneet on 2/27/16.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    ArrayList<String> moviePostersList;

    MyAdapter(ArrayList<String> moviePostersList){
        this.moviePostersList = moviePostersList;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView moviePoster;

        MyViewHolder(View view){
            super(view);
            moviePoster = (ImageView) view.findViewById(R.id.picture);
        }


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.one_item, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public int getItemCount(){

        return moviePostersList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position){

        for(int counter=0; counter < moviePostersList.size(); counter++) {
            myViewHolder.moviePoster.setImageResource(R.drawable.puneet);
        }
    }

}
