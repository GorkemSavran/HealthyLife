package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class FoodStatistics extends AppCompatActivity implements View.OnClickListener {
    TextView today_total, today_total_cal;
    GraphView graph_food;
    Button backbutton9;
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
        graph_food.addSeries(series);
        backbutton9.setOnClickListener(this);
    }

    public void init() {
        graph_food = findViewById(R.id.graph_food);
        today_total_cal = findViewById(R.id.today_total_cal);
        backbutton9 = findViewById(R.id.backbutton9);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backbutton9) {
            Intent intent = new Intent(context, FoodPage.class);
            startActivity(intent);
        }
    }
}