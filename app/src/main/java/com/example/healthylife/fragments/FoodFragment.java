package com.example.healthylife.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.healthylife.R;
import com.example.healthylife.models.Food;
import com.example.healthylife.models.QuantityMeasure;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class FoodFragment extends Fragment {

    Activity context;
    private ArrayList<Food> foods;
    private boolean isAddingList;

    public FoodFragment(ArrayList<Food> foods, boolean isAddingList) {
        this.foods = foods;
        this.isAddingList = isAddingList;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_list, container, false);


        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new FoodRecyclerViewAdapter(foods, isAddingList));
        }
        return view;
    }

}