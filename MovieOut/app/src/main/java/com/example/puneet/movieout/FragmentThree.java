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

import java.util.ArrayList;

/**
 * Created by puneet on 3/25/16.
 */
public class FragmentThree extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MyAdapter adapter;
    private Context mcontext;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);

        MyMovieDataWithoutContentProvider myMovieDataWithoutContentProvider = new MyMovieDataWithoutContentProvider(getActivity());
        ArrayList<OneMovieData> movieDataArrayList = myMovieDataWithoutContentProvider.retrieveData();

        mcontext = getActivity();
        layoutManager = new GridLayoutManager(mcontext, 2, LinearLayoutManager.VERTICAL, false);
        adapter = new MyAdapter(movieDataArrayList, mcontext, new MovieItemClickListener() {
            @Override
            public void onMovieClick(OneMovieData oneMovieData) {
                // send data back to main activity
            }
        });


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstance){

        return layoutInflater.inflate(R.layout.fragment_one, container, false);
    }


}
