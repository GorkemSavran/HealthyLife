package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class FoodStatistics extends AppCompatActivity implements View.OnClickListener {
    TextView today_total, todayTotalCal;
    GraphView graphFood;
    Button backButton;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_statistics);
        init();
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(1, 900),
                new DataPoint(2, 1000),
                new DataPoint(3, 1200),
                new DataPoint(4, 1300)

        });
        graphFood.addSeries(series);
        backButton.setOnClickListener(this);
    }

    public void init() {
        graphFood = findViewById(R.id.graph_food);
        todayTotalCal = findViewById(R.id.today_total_cal);
        backButton = findViewById(R.id.backbutton9);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backbutton9) {
            finish();
        }
    }
}