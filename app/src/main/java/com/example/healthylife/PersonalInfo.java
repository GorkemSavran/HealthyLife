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
import android.widget.Toast;

public class PersonalInfo extends AppCompatActivity implements View.OnClickListener {
    Button backbutton3, cont2;
    RadioButton radioBtnMan, radioBtnWoman;
    EditText birthday;
    Spinner act_spinner;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        init();
        backbutton3.setOnClickListener(this);
        cont2.setOnClickListener(this);

        act_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    //position -> sırası, view -> tıklanan eleman
                //Toast.makeText(context, "Seçilen eleman: "+parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
// her seçtiğimiz kaldırıldığında çalışan metod -> seçilecek eleman kalmadı gibi bir şey
            }
        });
    }



    public void init()
    {
     backbutton3 = findViewById(R.id.backbutton3);
     cont2 = findViewById(R.id.cont2);
     radioBtnMan = findViewById(R.id.radioBtnMan);
     radioBtnWoman = findViewById(R.id.radioBtnWoman);
     birthday = findViewById(R.id.birthday);
     act_spinner =findViewById(R.id.act_spinner);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbutton3:
                Intent intent = new Intent(context, GoalPage.class);
                startActivity(intent); //radio butonlardan sadece 1 tanesini seçebilecek hale getirilmesi gerek
                break;
            case R.id.cont2:
                //eğer tüm bilgiler doluysa gitsin, hepsi dolu değilse toast: lütfen bilgilerinizin hepsini girdiğinizden emin olunuz!
                Intent intent1 = new Intent(context, PersonalInfo2.class);
                startActivity(intent1);

        }
    }

}