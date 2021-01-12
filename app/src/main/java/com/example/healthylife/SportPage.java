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
import android.widget.TextView;

import com.example.healthylife.activities.SearchSport;
import com.example.healthylife.fragments.SportFragment;
import com.example.healthylife.holders.TodayDailySportHolder;
import com.example.healthylife.models.Sport;

import java.util.ArrayList;

public class SportPage extends AppCompatActivity implements View.OnClickListener {
    Button backButton, addNewSportBtn, sportStatisticsBtn;
    TextView totalBurnCalorie, sportStatistics;
    ImageButton addNewSportImageBtn, sportStatisticsImageBtn;
    Context context = this;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_page);
        fragmentManager = getSupportFragmentManager();
        init();

    }

    public void init() {
        backButton = findViewById(R.id.backbutton12);
        addNewSportBtn = findViewById(R.id.add_new_sport_btn);
        sportStatisticsBtn = findViewById(R.id.sport_statistics_btn);
        totalBurnCalorie = findViewById(R.id.total_burn_calorie);
        sportStatistics = findViewById(R.id.sport_statistics);
        addNewSportImageBtn = findViewById(R.id.add_new_sport_image_btn);
        sportStatisticsImageBtn = findViewById(R.id.sport_statistics_image_btn);

        backButton.setOnClickListener(this);
        addNewSportBtn.setOnClickListener(this);
        sportStatisticsBtn.setOnClickListener(this);

    }
    protected void onResume() {
        super.onResume();
        listSports();
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

    private void listSports() {
        ArrayList<Sport> sports = TodayDailySportHolder.getInstance().getSports();
        SportFragment sportFragment = (SportFragment) fragmentManager.findFragmentByTag("Added Sport");
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(sportFragment != null) {
            transaction.remove(sportFragment);
        }
        if(!sports.isEmpty()) {
            sportFragment = new SportFragment(sports, false);
            transaction.add(R.id.fragment_sport, sportFragment, "Added Sport");
            totalBurnCalorie.setText(TodayDailySportHolder.getInstance().getTodayTotalBurnedCalories() + " KCAL");
        }
        transaction.commit();
    }
}