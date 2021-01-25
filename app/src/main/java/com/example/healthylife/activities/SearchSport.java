package com.example.healthylife.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.healthylife.R;
import com.example.healthylife.dummy.SportStore;
import com.example.healthylife.fragments.FoodFragment;
import com.example.healthylife.fragments.SportFragment;
import com.example.healthylife.models.Sport;

import java.util.ArrayList;

// KIYMET DEREN TOY
public class SearchSport extends AppCompatActivity implements View.OnClickListener  {
    Context context = this;
    Button backButton, searchSportButton;
    EditText searchSportEditText;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_sport);
        manager = getSupportFragmentManager();
        init();
    }
    public void init(){
        backButton = findViewById(R.id.backbutton);
        searchSportEditText = findViewById(R.id.search_sport_editText);
        searchSportButton = findViewById(R.id.search_sport_btn);
        searchSportButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_sport_btn:
                String searchString = searchSportEditText.getText().toString();
                System.out.println("Search String: " + searchString);
                ArrayList<Sport> filteredSports = SportStore.getDummySports(searchString);
                FragmentTransaction transaction = manager.beginTransaction();
                SportFragment sportFragment = (SportFragment) manager.findFragmentByTag("Sport List");
                if(sportFragment != null){
                    transaction.remove(sportFragment);
                }
                sportFragment = new SportFragment(filteredSports, true);
                transaction.add(R.id.fragment_sport_show, sportFragment, "Sport List");
                transaction.commit();
                break;
            case R.id.backbutton:
                finish();
                break;
        }
    }

}