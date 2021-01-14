package com.example.healthylife;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.healthylife.holders.TodayDailyFoodHolder;

public class FragmentWater extends Fragment {


    public FragmentWater() {

    }

    public static FragmentWater newInstance(String param1, String param2) {
        FragmentWater fragment = new FragmentWater();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_water, container, false);
        final EditText howMuchWater = (EditText) view.findViewById(R.id.how_much_water);
        Button addWaterBtn = (Button) view.findViewById(R.id.add_water_btn);
        Button extractWaterBtn = (Button) view.findViewById(R.id.extract_water_btn);

        addWaterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodayDailyFoodHolder.getInstance().incrementTodayWater(Integer.parseInt(howMuchWater.getText().toString()));
                ((WaterPage)getActivity()).updateWaterText();
            }
        });

        extractWaterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodayDailyFoodHolder.getInstance().decrementTodayWater(Integer.parseInt(howMuchWater.getText().toString()));
                ((WaterPage)getActivity()).updateWaterText();
            }
        });

        return view;

    }



}