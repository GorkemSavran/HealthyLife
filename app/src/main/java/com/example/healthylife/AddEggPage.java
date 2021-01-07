package com.example.healthylife;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddEggPage extends AppCompatActivity  implements View.OnClickListener {
    Context context = this;
    Button backbutton8;
    EditText number_of_food;
    Spinner material_spinner;
    TextView how_much_calorie;
    LinearLayout fragment_added_food;
    FragmentManager manager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_egg_page);
        init();
        manager2 = getSupportFragmentManager();
        backbutton8.setOnClickListener(this);
    }
    public void init() {
        backbutton8 = findViewById(R.id.backbutton8);
        number_of_food = findViewById(R.id.number_of_food);
        material_spinner = findViewById(R.id.material_spinner);
        how_much_calorie = findViewById(R.id.how_much_calorie);
        fragment_added_food = findViewById(R.id.fragment_added_food);
    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backbutton8) {
            Intent intent = new Intent(context, SearchFood.class);
            startActivity(intent);
        }

    }



}