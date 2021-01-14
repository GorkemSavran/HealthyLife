package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class GoalPage extends AppCompatActivity implements View.OnClickListener {
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    Button cont;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_page);
        init();
        cont.setOnClickListener(this);
    }
    public void init(){
         radioButton1= (RadioButton) findViewById(R.id.radioButton1);
         radioButton2= (RadioButton) findViewById(R.id.radioButton2);
         radioButton3= (RadioButton) findViewById(R.id.radioButton3);
         cont = (Button) findViewById(R.id.cont);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cont) {
            Intent intent = new Intent(context, PersonalInfo.class);
            startActivity(intent);
        }
    }


}