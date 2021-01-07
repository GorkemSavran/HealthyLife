package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class WeightPage extends AppCompatActivity implements View.OnClickListener {
    GraphView graph_weight;
    EditText current_weight_update;
    Button backbutton5;
    ImageView update_weight_pic;
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
        graph_weight.addSeries(series);
        backbutton5.setOnClickListener(this);
    }
    public void init(){
        graph_weight = findViewById(R.id.graph_weight);
        current_weight_update = findViewById(R.id.current_weight_update);
        backbutton5 = findViewById(R.id.backbutton5);
        update_weight_pic = findViewById(R.id.update_weight_pic);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backbutton5) {
            Intent intent = new Intent(context, MainScreen.class);
            startActivity(intent);
        }

    }
}