package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchSport extends AppCompatActivity implements View.OnClickListener {
    EditText searchView_sport;
    FragmentManager manager3;
    Context context = this;
    Button backbutton13, search_sport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_sport);
        init();
        manager3 = getSupportFragmentManager();
    }
    public void init(){
        backbutton13 = findViewById(R.id.backbutton13);
        searchView_sport = findViewById(R.id.searchView_sport);
        search_sport = findViewById(R.id.search_food);
    }

    public void clickSportSearch(View view) {
        if (searchView_sport.getText().toString().equals("basketball")) { //SEARCH VİEW YAPMALIYIZ BURAYI FAKAT ADAPTER FALAN GEREKLİ SANIRIM
            //DÜZELTİRİZ
            ListOfSports fragment_sport = new ListOfSports();
            FragmentTransaction transaction = manager3.beginTransaction();
            transaction.add(R.id.fragment_sport_show, fragment_sport, "BasketballList");
            transaction.commit();
        }
    }
    public void new_basketball_high(View view){
        Intent intent1 = new Intent(context, AddBasketballPage.class);
        startActivity(intent1);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backbutton13) {
            Intent intent = new Intent(context, SportPage.class);
            startActivity(intent);
        }
    }
}