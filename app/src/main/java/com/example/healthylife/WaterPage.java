package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;

public class WaterPage extends AppCompatActivity implements View.OnClickListener {
    Button backButton, addWaterBtn, extractWaterBtn;
    Context context = this;
    GraphView graphWater;
    ImageButton addExtractWater;
    FragmentManager manager5;

    TextView todayTotalMlText;

    Integer control = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_page);
        init();
        backButton.setOnClickListener(this);
        manager5 = getSupportFragmentManager();

    }
    public void init(){
        backButton = findViewById(R.id.backbutton10);
        graphWater = findViewById(R.id.graph_water);
        addExtractWater = findViewById(R.id.add_extract_water);
        addWaterBtn = findViewById(R.id.add_water_btn);
        extractWaterBtn = findViewById(R.id.extract_water_btn);
        todayTotalMlText = findViewById(R.id.today_total_ml);

    }
    public void waterAddExtr(View v){
        if (control == 0) {
            FragmentWater fragment_water = new FragmentWater();
            FragmentTransaction transaction = manager5.beginTransaction();
            transaction.add(R.id.water_fragment, fragment_water, "Water");
            transaction.commit();
            control = 1;
        }else{
            FragmentWater fragment_water_remove = (FragmentWater) manager5.findFragmentByTag("Water");
            FragmentTransaction transaction = manager5.beginTransaction();
            assert fragment_water_remove != null;
            transaction.remove(fragment_water_remove);
            transaction.commit();
            control = 0;

        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backbutton10) {
            finish();
        }
    }

}