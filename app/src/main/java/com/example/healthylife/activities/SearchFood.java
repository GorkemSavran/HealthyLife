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
import com.example.healthylife.dummy.FoodStore;
import com.example.healthylife.fragments.FoodFragment;
import com.example.healthylife.models.Food;

import java.util.ArrayList;

// GÖRKEM SAVRAN
public class SearchFood extends AppCompatActivity implements View.OnClickListener  {
    Context context = this;
    Button backButton, searchButton;
    EditText searchFoodTextView;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_food);
        manager = getSupportFragmentManager();
        init();
    }
    public void init(){
        backButton = findViewById(R.id.backbutton);
        searchFoodTextView = findViewById(R.id.search_food_textView);
        searchButton = findViewById(R.id.search_btn);
        searchButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_btn:
                String searchString = searchFoodTextView.getText().toString();
                System.out.println("Search String: " + searchString);
                ArrayList<Food> filteredFoods = FoodStore.getDummyFoods(searchString);
                FragmentTransaction transaction = manager.beginTransaction();
                FoodFragment foodFragment = (FoodFragment) manager.findFragmentByTag("Food List");
                if(foodFragment != null){
                    transaction.remove(foodFragment);
                }
                foodFragment = new FoodFragment(filteredFoods, true);
                transaction.add(R.id.fragment_show, foodFragment, "Food List");
                transaction.commit();
                break;
            case R.id.backbutton:
                finish();
                break;
        }
    }

}