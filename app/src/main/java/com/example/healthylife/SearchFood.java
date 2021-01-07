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
import android.widget.SearchView;

public class SearchFood extends AppCompatActivity implements View.OnClickListener  {
    Context context = this;
    Button backbutton7, search_food;
    EditText searchView_food;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_food);
        manager = getSupportFragmentManager();
        init();
        backbutton7.setOnClickListener(this);

    }
    public void init(){
        backbutton7 = findViewById(R.id.backbutton7);
        searchView_food = findViewById(R.id.searchView_food);
        search_food = findViewById(R.id.search_food);
    }
    public void click_Search(View v) {
        if (searchView_food.getText().toString().equals("egg")) { //SEARCH VİEW YAPMALIYIZ BURAYI FAKAT ADAPTER FALAN GEREKLİ SANIRIM
            //DÜZELTİRİZ
            ListOfFoods fragment_list = new ListOfFoods();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.fragment_show, fragment_list, "EggList");
            transaction.commit();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backbutton7) {
            Intent intent = new Intent(context, FoodPage.class);
            startActivity(intent);
        }
    }
    public void new_egg_boiled(View view) {
        Intent intent1 = new Intent(context, AddEggPage.class);
        startActivity(intent1);
    }


}