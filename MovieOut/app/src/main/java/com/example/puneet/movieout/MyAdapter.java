package com.example.puneet.movieout;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by puneet on 3/7/16.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<OneMovieData> movieDataList;
    Context mainContext;


    MyAdapter(ArrayList<OneMovieData> movieDataList , Context context){
        this.movieDataList = movieDataList;
        this.mainContext = context;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView moviePoster;
        MyViewHolder(View view){
            super(view);
            moviePoster = (ImageView) view.findViewById(R.id.picture);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Toast.makeText(itemView.getContext(), "User clicked on movie :"+movieDataList.get(pos).getOriginalTitle(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mainContext, MovieInfoDisplay.class);
                    intent.putExtra("MOVIE_DATA", movieDataList.get(pos));
                    mainContext.startActivity(intent);
                }
            });

        }



    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.one_item, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public int getItemCount(){

        return movieDataList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position){

            Picasso.with(mainContext)
                    .load("http://image.tmdb.org/t/p/w185/"+movieDataList.get(position).getMoviePoster())
                    .into(myViewHolder.moviePoster);
    }

}

