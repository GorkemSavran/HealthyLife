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
import android.widget.ImageButton;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;

public class WaterPage extends AppCompatActivity implements View.OnClickListener  {
    Button backbutton10, add_water_btn, extract_water_btn;
    Context context = this;
    GraphView graph_water;
    ImageButton add_extract_water;
    FragmentManager manager5;
    TextView today_total_ml;
    EditText how_much_water;
    int today_total_ml_int=0;
    Integer control = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_page);
        init();
        backbutton10.setOnClickListener(this);
        manager5 = getSupportFragmentManager();
    }
    public void init(){
        backbutton10 = findViewById(R.id.backbutton10);
        graph_water = findViewById(R.id.graph_water);
        add_extract_water = findViewById(R.id.add_extract_water);
        add_water_btn = findViewById(R.id.add_water_btn);
        extract_water_btn = findViewById(R.id.extract_water_btn);
        today_total_ml = findViewById(R.id.today_total_ml);
        how_much_water = findViewById(R.id.how_much_water);
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
    //su mikatrını değiştirme
    public void addWater(View v){
        int how_much_water_int =  Integer.parseInt(how_much_water.getText().toString());
        today_total_ml_int = today_total_ml_int + how_much_water_int;
        today_total_ml.setText(String.valueOf(today_total_ml_int) + " ml");

    }
    public void extractWater(View v){

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backbutton10) {
            Intent intent = new Intent(context, MainScreen.class);
            startActivity(intent);
        }
    }
}