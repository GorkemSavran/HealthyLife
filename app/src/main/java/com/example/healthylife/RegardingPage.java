package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class RegardingPage extends AppCompatActivity implements  View.OnClickListener {
    RatingBar ratingBar;
    Button cancelBtn, submitBtn;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regarding_page);
        init();
        cancelBtn.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
    }
    public void init(){
        ratingBar = findViewById(R.id.ratingBar);
        cancelBtn = findViewById(R.id.cancel_btn);
        submitBtn = findViewById(R.id.submit_btn);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cancel_btn:
                Toast.makeText(context, "Remaind me later!", LENGTH_SHORT).show();
                finishAffinity();
                break;

            case R.id.submit_btn:
                Toast.makeText(context, "Thank you for regarding!", LENGTH_SHORT).show();
                finishAffinity();
                break;

        }
    }
}