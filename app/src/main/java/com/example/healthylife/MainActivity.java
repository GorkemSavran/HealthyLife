package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.healthylife.activities.SearchFood;
import com.example.healthylife.fragments.FoodFragment;
import com.example.healthylife.models.Food;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity/* implements OnClickListener*/ {
    Button login_button;
    EditText username, password;
    TextView forgot_pass, sign_up;
    Context context =this;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(context, MainScreen.class);
        startActivity(intent);
        /*init();
        login_button.setOnClickListener(this);
        forgot_pass.setOnClickListener(this);
        sign_up.setOnClickListener(this);*/

    }
    /*
    public void init(){
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        forgot_pass = findViewById(R.id.forgot_pass);
        sign_up =  findViewById(R.id.sign_up);
        login_button= findViewById(R.id.login_button);
    }


    @Override
    public void onClick(View v) { //v tıklanan buton
        //deren bir numara <3
      switch (v.getId()){
          case R.id.login_button:
              if (username.getText().toString().equals("")  && password.getText().toString().equals("") ) {
                    Intent intent1 = new Intent (context, MainScreen.class);
                    startActivity(intent1); //explicit intent -> gideceği yer belli
                  // DATABASE 'E GİDİP BÖYLE BİR KULLANICI VAR MI DİYE BAKMALI, VARSA LOGIN -> MAIN SAYFA
                  // YOKSA DEVAMKE ->HATA
              }else{
                  Toast.makeText(context, "Kullanıcı adı veya şifre hatalı!", LENGTH_SHORT).show();

              }
              break;

          case R.id.forgot_pass:
              Intent intent2 = new Intent (context, ForgotPassword.class);
              startActivity(intent2); //explicit intent -> gideceği yer belli
              break;
          case R.id.sign_up:
              Intent intent3 = new Intent (context, SignUp.class);
              startActivity(intent3); //explicit intent -> gideceği yer belli
              break;


      }
    }*/
}