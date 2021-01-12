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

public class SportStatistics extends AppCompatActivity implements View.OnClickListener  {
    Button backBtn;
    GraphView graphSport;
    TextView todayTotalBurn;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_statistics);
        init();
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(1, 200),
                new DataPoint(2, 300),
                new DataPoint(3, 400),
                new DataPoint(4, 500)

        });
    }
    public void init() {
        graphSport = findViewById(R.id.graph_sport);
        todayTotalBurn = findViewById(R.id.today_total_burn);
        backBtn = findViewById(R.id.backbutton11);

    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backbutton11) {
            finish();
        }

    }
}