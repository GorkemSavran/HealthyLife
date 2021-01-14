package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.healthylife.holders.TodayDailyFoodHolder;
import com.example.healthylife.holders.TodayDailyUserHolder;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WaterPage extends AppCompatActivity implements View.OnClickListener {
    Button backButton, addWaterBtn, extractWaterBtn;
    Context context = this;
    GraphView graphWater;
    ImageButton addExtractWater;
    FragmentManager manager5;

    TextView todayTotalMlText;
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");

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
        setGraphWeight();
        updateWaterText();

    }
    public void setGraphWeight() {
        Date[] dates = {
                new Date(2021,8,22,12,0),
                new Date(2021,8,23,12,0),
                new Date(2021,8,24,12,0),
                new Date(2021,8,26,12,0),
                new Date(2021,8,28,12,0),
        };
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(dates[0], 2000),
                new DataPoint(dates[1], 2400),
                new DataPoint(dates[2], 2300),
                new DataPoint(dates[3], 2100),
                new DataPoint(dates[4], TodayDailyFoodHolder.getInstance().getTodayWater())
        });
        graphWater.removeAllSeries();
        graphWater.addSeries(series);
        graphWater.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if(isValueX) {

                    return sdf.format(new Date((long) value));
                }else {
                    return super.formatLabel(value, isValueX);
                }
            }
        });
    }

    public void  updateWaterText() {
        todayTotalMlText.setText(TodayDailyFoodHolder.getInstance().getTodayWater() + " ml");
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