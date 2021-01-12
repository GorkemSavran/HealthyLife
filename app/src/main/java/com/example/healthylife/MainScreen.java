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
import com.example.healthylife.holders.TodayDailySportHolder;

public class MainScreen extends AppCompatActivity implements View.OnClickListener {
    Button weightPageBtn, foodPageBtn, waterPageBtn, sportPageBtn, settingPageBtn;
    ImageView weightPic, foodPic, waterPic, sportPic, settingsPic;
    TextView consumedCalorie, targetCalorie, leftWeight, takenCalorie, takenWater, burntCalorie,settings;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        init();


    }
    public void init(){
        weightPageBtn = findViewById(R.id.weight_page_btn);
        foodPageBtn = findViewById(R.id.food_page_btn);
        waterPageBtn = findViewById(R.id.water_page_btn);
        sportPageBtn = findViewById(R.id.sport_page_btn);
        settingPageBtn = findViewById(R.id.setting_page_btn);
        weightPic = findViewById(R.id.weight_pic);
        foodPic = findViewById(R.id.food_pic);
        waterPic = findViewById(R.id.water_pic);
        sportPic = findViewById(R.id.sport_pic);
        settingsPic = findViewById(R.id.settings_pic);
        consumedCalorie = findViewById(R.id.consumed_calorie);
        targetCalorie = findViewById(R.id.target_calorie);
        leftWeight = findViewById(R.id.left_weight);
        takenCalorie = findViewById(R.id.taken_calorie);
        takenWater = findViewById(R.id.taken_water);
        burntCalorie = findViewById(R.id.burnt_calorie);
        settings = findViewById(R.id.settings);

        weightPageBtn.setOnClickListener(this);
        foodPageBtn.setOnClickListener(this);
        waterPageBtn.setOnClickListener(this);
        sportPageBtn.setOnClickListener(this);
        settingPageBtn.setOnClickListener(this);
        weightPic.setOnClickListener(this);
        foodPic.setOnClickListener(this);
        waterPic.setOnClickListener(this);
        sportPic.setOnClickListener(this);
        settingsPic.setOnClickListener(this);
        leftWeight.setOnClickListener(this);
        takenCalorie.setOnClickListener(this);
        takenWater.setOnClickListener(this);
        burntCalorie.setOnClickListener(this);
        settings.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        int totalCalories = TodayDailyFoodHolder.getInstance().getTodayTotalCalories();
        consumedCalorie.setText(totalCalories + " kcal");
        takenCalorie.setText(totalCalories + " kcal taken");
        int totalBurnedCalories = TodayDailySportHolder.getInstance().getTodayTotalBurnedCalories();
        burntCalorie.setText(totalBurnedCalories + " kcal burn");
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