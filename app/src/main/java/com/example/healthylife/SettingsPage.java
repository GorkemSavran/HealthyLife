package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.healthylife.holders.TodayDailyUserHolder;

// KIYMET DEREN TOY
public class SettingsPage extends AppCompatActivity implements View.OnClickListener {
    Button backButton, logOutBtn;
    TextView settingsUsername, settingsEmail, settingsChangeGoals;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
        init();
        logOutBtn.setOnClickListener(this);
        backButton.setOnClickListener(this);
        settingsChangeGoals.setOnClickListener(this);
    }
    public void init() {
        backButton = findViewById(R.id.backbutton6);
        logOutBtn = findViewById(R.id.log_out_btn);
        settingsUsername = findViewById(R.id.settings_username);
        settingsEmail = findViewById(R.id.settings_email);
        settingsChangeGoals = findViewById(R.id.settings_change_goals);

        settingsUsername.setText(TodayDailyUserHolder.getInstance().getUsername());
        settingsEmail.setText(TodayDailyUserHolder.getInstance().getEmail());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbutton6:
                finish();
                break;
            case R.id.log_out_btn:
                Intent intent1 = new Intent(context, RegardingPage.class);
                startActivity(intent1);
                break;
            case R.id.settings_change_goals:
                Intent intent2 = new Intent(context, GoalPage.class);
                startActivity(intent2);
                break;

        }
    }
}