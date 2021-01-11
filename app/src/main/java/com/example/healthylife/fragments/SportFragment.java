package com.example.healthylife.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthylife.R;
import com.example.healthylife.models.Sport;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class SportFragment extends Fragment {

    Activity context;
    private ArrayList<Sport> sports;
    private boolean isAddingList;

    public SportFragment(ArrayList<Sport> sports, boolean isAddingList) {
        this.sports = sports;
        this.isAddingList = isAddingList;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sport_list, container, false);


        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new SportRecyclerViewAdapter(sports, isAddingList));
        }
        return view;
    }

}