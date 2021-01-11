package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.healthylife.activities.SearchSport;

public class SportPage extends AppCompatActivity implements View.OnClickListener {
    Button backbutton12, add_new_sport_btn, sport_statistics_btn;
    TextView total_burn_calorie, sport_statistics;
    ImageButton add_new_sport_image_btn, sport_statistics_image_btn;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_page);
        init();
        backbutton12.setOnClickListener(this);
        add_new_sport_btn.setOnClickListener(this);
        sport_statistics_btn.setOnClickListener(this);
    }

    public void init() {
        backbutton12 = findViewById(R.id.backbutton12);
        add_new_sport_btn = findViewById(R.id.add_new_sport_btn);
        sport_statistics_btn = findViewById(R.id.sport_statistics_btn);
        total_burn_calorie = findViewById(R.id.total_burn_calorie);
        sport_statistics = findViewById(R.id.sport_statistics);
        add_new_sport_image_btn = findViewById(R.id.add_new_sport_image_btn);
        sport_statistics_image_btn = findViewById(R.id.sport_statistics_image_btn);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbutton12:
                finish();
                break;
            case R.id.add_new_sport_btn:
                Intent intent1 = new Intent(context, SearchSport.class);
                startActivity(intent1);
                break;
            case R.id.sport_statistics_btn:
                Intent intent2 = new Intent(context, SportStatistics.class);
                startActivity(intent2);
                break;

        }
    }
}