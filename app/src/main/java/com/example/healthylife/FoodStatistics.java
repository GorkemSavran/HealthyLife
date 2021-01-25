package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.healthylife.holders.TodayDailyFoodHolder;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Date;

// GÖRKEM SAVRAN
public class FoodStatistics extends AppCompatActivity implements View.OnClickListener {
    TextView today_total, todayTotalCal;
    GraphView graphFood;
    Button backButton;
    Context context = this;
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_statistics);
        init();
        Date[] dates = {
            new Date(2021,0,22),
            new Date(2021,0,23),
            new Date(2021,0,24),
            new Date(2021,0,25),
        };
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(dates[0], 900),
                new DataPoint(dates[1], 1000),
                new DataPoint(dates[2], 1200),
                new DataPoint(dates[3], 1300)

        });
        graphFood.addSeries(series);
        graphFood.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if(isValueX) {
                    return sdf.format(new Date((long) value));
                }else {
                    return super.formatLabel(value, isValueX);
                }
            }
        });
        backButton.setOnClickListener(this);
    }

    public void init() {
        graphFood = findViewById(R.id.graph_food);
        todayTotalCal = findViewById(R.id.today_total_cal);
        backButton = findViewById(R.id.backbutton9);
        todayTotalCal.setText(String.valueOf(TodayDailyFoodHolder.getInstance().getTodayTotalCalories()) + " kcal");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backbutton9) {
            finish();
        }
    }
}