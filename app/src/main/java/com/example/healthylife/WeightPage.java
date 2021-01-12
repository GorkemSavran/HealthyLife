package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class WeightPage extends AppCompatActivity implements View.OnClickListener {
    GraphView graphWeight;
    EditText currentWeightUpdate;
    Button backButton;
    ImageView updateWeightPic;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_page);
        init();
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(1, 70),
                new DataPoint(2, 65),
                new DataPoint(3, 60),
                new DataPoint(4, 55)

        });
        graphWeight.addSeries(series);
        backButton.setOnClickListener(this);
    }
    public void init(){
        graphWeight = findViewById(R.id.graph_weight);
        currentWeightUpdate = findViewById(R.id.current_weight_update);
        backButton = findViewById(R.id.backbutton5);
        updateWeightPic = findViewById(R.id.update_weight_pic);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backButton) {
            finish();
        }

    }
}