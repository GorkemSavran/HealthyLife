package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity implements View.OnClickListener {
    Button backbutton, reset;
    EditText email;
    Context context = this;
    //FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        init();
        backbutton.setOnClickListener(this);
        reset.setOnClickListener(this);

    }
    public void init(){
        backbutton = findViewById(R.id.backbutton);
        reset = findViewById(R.id.reset);
        email = findViewById(R.id.email);
        //fAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backbutton:
                finish();
                break;
            //case R.id.reset:
                //EditText resetMail = new EditText(v.getContext());

                // send e-mail
                // email dolu mu diye bak database de yoksa hatalı de varsa başarılı toastı bastır
              //  break;
        }
    }
}