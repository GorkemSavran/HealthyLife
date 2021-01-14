package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.healthylife.holders.TodayDailyFoodHolder;
import com.example.healthylife.holders.TodayDailySportHolder;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SportStatistics extends AppCompatActivity implements View.OnClickListener  {
    Button backBtn;
    GraphView graphSport;
    TextView todayTotalBurn;
    Context context = this;
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
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
        backBtn.setOnClickListener(this);
        todayTotalBurn.setText(String.valueOf(TodayDailySportHolder.getInstance().getTodayTotalBurnedCalories()) + " kcal");
        setGraphSport();
    }

    public void setGraphSport() {
        Date[] dates = {
                new Date(2021,8,22,12,0),
                new Date(2021,8,23,12,0),
                new Date(2021,8,24,12,0),
                new Date(2021,8,26,12,0),
                new Date(2021,8,28,12,0),
        };
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(dates[0], 200),
                new DataPoint(dates[1], 300),
                new DataPoint(dates[2], 100),
                new DataPoint(dates[3], 150),
                new DataPoint(dates[4], TodayDailySportHolder.getInstance().getTodayTotalBurnedCalories())
        });
        graphSport.removeAllSeries();
        graphSport.addSeries(series);
        graphSport.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
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
        if (v.getId() == R.id.backbutton11) {
            finish();
        }

    }
}