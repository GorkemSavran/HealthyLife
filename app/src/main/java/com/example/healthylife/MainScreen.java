package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthylife.holders.TodayDailyFoodHolder;

public class MainScreen extends AppCompatActivity implements View.OnClickListener {
    Button weight_page_btn, food_page_btn,water_page_btn,sport_page_btn,setting_page_btn;
    ImageView weight_pic, food_pic,water_pic,sport_pic,settings_pic;
    TextView consumed_calorie, target_calorie,left_weight, taken_calorie,taken_water,burnt_calorie,settings;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        init();
        weight_page_btn.setOnClickListener(this);
        food_page_btn.setOnClickListener(this);
        water_page_btn.setOnClickListener(this);
        sport_page_btn.setOnClickListener(this);
        setting_page_btn.setOnClickListener(this);
        weight_pic.setOnClickListener(this);
        food_pic.setOnClickListener(this);
        water_pic.setOnClickListener(this);
        sport_pic.setOnClickListener(this);
        settings_pic.setOnClickListener(this);
        left_weight.setOnClickListener(this);
        taken_calorie.setOnClickListener(this);
        taken_water.setOnClickListener(this);
        burnt_calorie.setOnClickListener(this);
        settings.setOnClickListener(this);

    }
    public void init(){
        weight_page_btn = findViewById(R.id.weight_page_btn);
        food_page_btn = findViewById(R.id.food_page_btn);
        water_page_btn = findViewById(R.id.water_page_btn);
        sport_page_btn = findViewById(R.id.sport_page_btn);
        setting_page_btn = findViewById(R.id.setting_page_btn);
        weight_pic = findViewById(R.id.weight_pic);
        food_pic = findViewById(R.id.food_pic);
        water_pic = findViewById(R.id.water_pic);
        sport_pic = findViewById(R.id.sport_pic);
        settings_pic = findViewById(R.id.settings_pic);
        consumed_calorie = findViewById(R.id.consumed_calorie);
        target_calorie = findViewById(R.id.target_calorie);
        left_weight = findViewById(R.id.left_weight);
        taken_calorie = findViewById(R.id.taken_calorie);
        taken_water = findViewById(R.id.taken_water);
        burnt_calorie = findViewById(R.id.burnt_calorie);
        settings = findViewById(R.id.settings);
    }

    @Override
    protected void onResume() {
        super.onResume();
        int totalCalories = TodayDailyFoodHolder.getInstance().getTodayTotalCalories();
        consumed_calorie.setText(totalCalories + " kcal");
        taken_calorie.setText(totalCalories + " kcal taken");
    }

    @Override
    public void onClick(View v) {
        if ( v.getId() == R.id.weight_page_btn || v.getId() == R.id.weight_pic || v.getId() == R.id.left_weight ){
            Intent intent = new Intent(context, WeightPage.class);
            startActivity(intent);
        }else if(v.getId() ==R.id.food_page_btn || v.getId() == R.id.food_pic || v.getId() == R.id.taken_calorie ){
            Intent intent = new Intent(context, FoodPage.class);
            startActivity(intent);
        }else if(v.getId() ==R.id.water_page_btn || v.getId() == R.id.water_pic || v.getId() == R.id.taken_water ){
            Intent intent = new Intent(context, WaterPage.class);
            startActivity(intent);
        }else if(v.getId() ==R.id.sport_page_btn || v.getId() == R.id.sport_pic || v.getId() == R.id.burnt_calorie ){
            Intent intent = new Intent(context, SportPage.class);
            startActivity(intent);
        }else if(v.getId() ==R.id.setting_page_btn || v.getId() == R.id.settings_pic || v.getId() == R.id.settings){
            Intent intent = new Intent(context, SettingsPage.class);
            startActivity(intent);



    }
    }
}