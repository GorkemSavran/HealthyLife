package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PersonalInfo2 extends AppCompatActivity implements View.OnClickListener  {
    Button backbutton4, cont3;
    EditText height_num, current_weight_num, target_weight_num;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info2);
        init();
        backbutton4.setOnClickListener(this);
        cont3.setOnClickListener(this);

    }
    public void init()
    {
        backbutton4 = findViewById(R.id.backbutton4);
        cont3 = findViewById(R.id.cont3);
        height_num = findViewById(R.id.height_num);
        current_weight_num = findViewById(R.id.current_weight_num);
        target_weight_num = findViewById(R.id.target_weight_num);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbutton4:
                Intent intent = new Intent(context, PersonalInfo.class);
                startActivity(intent); //radio butonlardan sadece 1 tanesini seçebilecek hale getirilmesi gerek
                break;
            case R.id.cont3:
                //eğer tüm bilgiler doluysa gitsin, hepsi dolu değilse toast: lütfen bilgilerinizin hepsini girdiğinizden emin olunuz!
                Intent intent1 = new Intent(context,MainScreen.class);
                startActivity(intent1);

        }

    }
}