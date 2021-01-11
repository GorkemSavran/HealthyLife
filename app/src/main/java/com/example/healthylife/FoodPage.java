package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.healthylife.activities.SearchFood;
import com.example.healthylife.holders.TodayDailyFoodHolder;
import com.example.healthylife.fragments.FoodFragment;
import com.example.healthylife.models.Food;

import java.util.ArrayList;

public class FoodPage extends AppCompatActivity implements View.OnClickListener {
    Context context = this;
    Button  backButton, addNewFoodBtn, foodStatisticsBtn;
    ImageButton addNewFoodImageBtn, foodStatisticsImageBtn;
    LinearLayout fragmentAddedFood;
    FragmentManager fragmentManager;
    TextView foodTotalCalories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_page);
        fragmentManager = getSupportFragmentManager();
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        listFoods();
    }

    public void init() {
        backButton = findViewById(R.id.backbutton6);
        addNewFoodBtn = findViewById(R.id.add_new_food_btn);
        foodStatisticsBtn = findViewById(R.id.food_statistics_btn);
        addNewFoodImageBtn = findViewById(R.id.add_new_food_image_btn);
        foodStatisticsImageBtn = findViewById(R.id.food_statistics_image_btn);
        fragmentAddedFood = findViewById(R.id.fragment_added_food);
        foodTotalCalories = findViewById(R.id.total_calorie);

        backButton.setOnClickListener(this);
        addNewFoodBtn.setOnClickListener(this);
        foodStatisticsBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbutton6:
                finish();
                break;
            case R.id.add_new_food_btn:
                Intent intent1 = new Intent(context, SearchFood.class);
                startActivity(intent1);
                break;
            case R.id.food_statistics_btn:
                Intent intent2 = new Intent(context, FoodStatistics.class);
                startActivity(intent2);
                break;


        }
    }


    private void listFoods() {
        ArrayList<Food> foods = TodayDailyFoodHolder.getInstance().getFoods();
        FoodFragment foodFragment = (FoodFragment) fragmentManager.findFragmentByTag("Added Food");
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(foodFragment != null) {
            transaction.remove(foodFragment);
        }
        if(!foods.isEmpty()) {
            foodFragment = new FoodFragment(foods, false);
            transaction.add(R.id.fragment_added_food, foodFragment, "Added Food");
            foodTotalCalories.setText(TodayDailyFoodHolder.getInstance().getTodayTotalCalories() + " KCAL");
        }
        transaction.commit();
    }

}