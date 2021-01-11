package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class RegardingPage extends AppCompatActivity implements  View.OnClickListener {
    RatingBar ratingBar;
    Button cancel_btn, submit_btn;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regarding_page);
        init();
        cancel_btn.setOnClickListener(this);
        submit_btn.setOnClickListener(this);
    }
    public void init(){
        ratingBar = findViewById(R.id.ratingBar);
        cancel_btn = findViewById(R.id.cancel_btn);
        submit_btn = findViewById(R.id.submit_btn);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cancel_btn:
                Toast.makeText(context, "Remaind me later!", LENGTH_SHORT).show();
                //getActivity().finish();
                //System.exit(0);
                break;

            case R.id.submit_btn:
                //Burda yıldızlardan birine basmış olmalı -> gerçi basmazsa sıfır da olabilir
                Toast.makeText(context, "Thank you for regarding!", LENGTH_SHORT).show();
                //getActivity().finish();
                System.exit(0);
                break;

                // Bu butonlardan birine tıklayınca diğerine tıklamamalııı, uygulama kapanmalı bebek kuşum
        }
    }
}