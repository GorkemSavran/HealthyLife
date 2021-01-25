package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// KIYMET DEREN TOY
public class PersonalInfo2 extends AppCompatActivity implements View.OnClickListener  {
    Button backButton, continueBtn;
    EditText heightNum, currentWeightNum, targetWeightNum;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info2);
        init();
        backButton.setOnClickListener(this);
        continueBtn.setOnClickListener(this);

    }
    public void init()
    {
        backButton = findViewById(R.id.backbutton4);
        continueBtn = findViewById(R.id.cont3);
        heightNum = findViewById(R.id.height_num);
        currentWeightNum = findViewById(R.id.current_weight_num);
        targetWeightNum = findViewById(R.id.target_weight_num);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbutton4:
                finish();
                break;
            case R.id.cont3:
                Intent intent1 = new Intent(context,MainScreen.class);
                startActivity(intent1);

        }

    }
}