package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SettingsPage extends AppCompatActivity implements View.OnClickListener {
    Button backbutton6, log_out_btn;
    TextView settings_username, settings_email, settings_change_goals;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
        init();
        log_out_btn.setOnClickListener(this);
        backbutton6.setOnClickListener(this);
        settings_change_goals.setOnClickListener(this);
    }
    public void init() {
        backbutton6 = findViewById(R.id.backbutton6);
        log_out_btn = findViewById(R.id.log_out_btn);
        settings_username = findViewById(R.id.settings_username);
        settings_email = findViewById(R.id.settings_email);
        settings_change_goals = findViewById(R.id.settings_change_goals);
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