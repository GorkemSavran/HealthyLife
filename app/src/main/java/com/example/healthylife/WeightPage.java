package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.healthylife.holders.TodayDailyUserHolder;
import com.example.healthylife.models.User;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class WeightPage extends AppCompatActivity implements View.OnClickListener, TextWatcher {
    GraphView graphWeight;
    EditText currentWeightUpdate;
    Button backButton;
    Button updateWeightBtn;
    Context context = this;
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
    DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_page);
        init();

        backButton.setOnClickListener(this);
    }

    public void init(){
        graphWeight = findViewById(R.id.graph_weight);
        currentWeightUpdate = findViewById(R.id.current_weight_update);
        backButton = findViewById(R.id.backbutton5);
        updateWeightBtn = findViewById(R.id.update_weight_btn);
        setGraphWeight();
        currentWeightUpdate.setText(String.valueOf(TodayDailyUserHolder.getInstance().getCurrentWeight()));

        backButton.setOnClickListener(this);
        updateWeightBtn.setOnClickListener(this);
        currentWeightUpdate.addTextChangedListener(this);
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
                new DataPoint(dates[0], 62),
                new DataPoint(dates[1], 60),
                new DataPoint(dates[2], 60),
                new DataPoint(dates[3], 60),
                new DataPoint(dates[4], TodayDailyUserHolder.getInstance().getCurrentWeight())
        });
        graphWeight.removeAllSeries();
        graphWeight.addSeries(series);
        graphWeight.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbutton5:
                finish();
                break;
            case R.id.update_weight_btn:
                setGraphWeight();
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        try {
            float currentWeight = Float.parseFloat(currentWeightUpdate.getText().toString());
            TodayDailyUserHolder.getInstance().setCurrentWeight(currentWeight);
        }catch (NumberFormatException e){
            //System.out.println("not a number");
        }
    }
}