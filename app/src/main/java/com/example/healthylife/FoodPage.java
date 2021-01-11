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

import com.example.healthylife.activities.SearchFood;
import com.example.healthylife.controllers.TodayDailyFoodController;
import com.example.healthylife.fragments.FoodFragment;
import com.example.healthylife.models.Food;
import com.example.healthylife.models.QuantityMeasure;

import java.util.ArrayList;

public class FoodPage extends AppCompatActivity implements View.OnClickListener {
    Context context = this;
    Button  backButton,add_new_food_btn, food_statistics_btn;
    ImageButton add_new_food_image_btn, food_statistics_image_btn;
    LinearLayout fragment_added_food;
    FragmentManager fragmentManager;
    String foodNameText;
    Integer totalCalorie, numberOfFood;
    TodayDailyFoodController DailyFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_page);
        init();
        fragmentManager = getSupportFragmentManager();

    }
    public void init() {
        backButton = findViewById(R.id.backbutton6);
        add_new_food_btn = findViewById(R.id.add_new_food_btn);
        food_statistics_btn = findViewById(R.id.food_statistics_btn);
        add_new_food_image_btn = findViewById(R.id.add_new_food_image_btn);
        food_statistics_image_btn = findViewById(R.id.food_statistics_image_btn);
        fragment_added_food = findViewById(R.id.fragment_added_food);
        backButton.setOnClickListener(this);
        add_new_food_btn.setOnClickListener(this);
        food_statistics_btn.setOnClickListener(this);
/*      instance al
        Bundle extra= getIntent().getExtras();
        assert extra != null;
        foodNameText = extra.getString("foodNameText");
        numberOfFood = extra.getInt("numberOfFood");
        totalCalorie = extra.getInt("totalCalorie",0);

        ArrayList<Food> addedFoods = new ArrayList<Food>();
        addedFoods.add(new Food(foodNameText,"0" , numberOfFood, QuantityMeasure.PIECE,totalCalorie));
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        FoodFragment addedFragment = (FoodFragment) fragmentManager.findFragmentByTag("Taken Food List");
        if(addedFragment != null){
            transaction.remove(addedFragment);
        }
        addedFragment = new FoodFragment(addedFoods, false);
        transaction.add(R.id.fragment_added_food, addedFragment, "Taken Food List");
        transaction.commit(); */

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


}