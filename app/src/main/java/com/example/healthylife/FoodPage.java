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

public class FoodPage extends AppCompatActivity implements View.OnClickListener {
    Context context = this;
    Button backbutton6,add_new_food_btn, food_statistics_btn;
    ImageButton add_new_food_image_btn, food_statistics_image_btn;
    LinearLayout fragment_added_food;
    FragmentManager manager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_page);
        init();
        backbutton6.setOnClickListener(this);
        add_new_food_btn.setOnClickListener(this);
        food_statistics_btn.setOnClickListener(this);
        manager2 = getSupportFragmentManager();

    }
    public void init() {
        backbutton6 = findViewById(R.id.backbutton6);
        add_new_food_btn = findViewById(R.id.add_new_food_btn);
        food_statistics_btn = findViewById(R.id.food_statistics_btn);
        add_new_food_image_btn = findViewById(R.id.add_new_food_image_btn);
        food_statistics_image_btn = findViewById(R.id.food_statistics_image_btn);
        fragment_added_food = findViewById(R.id.fragment_added_food);

    }
    public void addEgg(View v) {
        FragmentFood fragment = new FragmentFood();
        FragmentTransaction transaction = manager2.beginTransaction();
        transaction.add(R.id.fragment_added_food, fragment, "AddEgg");
        transaction.commit();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbutton6:
                Intent intent = new Intent(context, MainScreen.class);
                startActivity(intent);
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