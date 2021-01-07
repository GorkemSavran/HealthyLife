package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class AddBasketballPage extends AppCompatActivity implements View.OnClickListener {
    Button backbutton14, add_sport_btn;
    EditText time_of_sport;
    Spinner time_spinner;
    TextView how_much_burn;
    FragmentManager manager4;
    Context context =this;
    LinearLayout fragment_sport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_basketball_page);
        init();
        manager4 = getSupportFragmentManager();
    }
    public void init(){
        backbutton14 = findViewById(R.id.backbutton14);
        add_sport_btn = findViewById(R.id.add_sport_btn);
        time_of_sport = findViewById(R.id.time_of_sport);
        time_spinner = findViewById(R.id.time_spinner);
        how_much_burn = findViewById(R.id.how_much_burn);
        fragment_sport = findViewById(R.id.fragment_sport);
    }

    public void addSport(View view) {
        FragmentSport fragment_sports = new FragmentSport();
        FragmentTransaction transaction = manager4.beginTransaction();
        transaction.add(R.id.fragment_sport, fragment_sports, "Basketball High");
        transaction.commit();
        // tek bir tane high basketbal için hazırladığımız fragmentı göstermeli
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backbutton14) {
            Intent intent = new Intent(context, SearchSport.class);
            startActivity(intent);
        }
    }
}