package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

// KIYMET DEREN TOY
public class PersonalInfo extends AppCompatActivity implements View.OnClickListener {
    Button backButton, continueBtn;
    RadioButton radioBtnMan, radioBtnWoman;
    EditText birthday;
    Spinner actSpinner;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        init();
        backButton.setOnClickListener(this);
        continueBtn.setOnClickListener(this);

        actSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



    public void init()
    {
     backButton = findViewById(R.id.backbutton3);
     continueBtn = findViewById(R.id.cont2);
     radioBtnMan = findViewById(R.id.radioBtnMan);
     radioBtnWoman = findViewById(R.id.radioBtnWoman);
     birthday = findViewById(R.id.birthday);
     actSpinner =findViewById(R.id.act_spinner);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbutton3:
                finish();
                break;
            case R.id.cont2:
                Intent intent1 = new Intent(context, PersonalInfo2.class);
                startActivity(intent1);

        }
    }

}