package com.example.puneet.fragmentsandloaders;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by puneet on 2/14/16.
 */
public class FragmentTwo extends Fragment{


    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstance){

        return layoutInflater.inflate(R.layout.fragment_two, container, false);
    }
}