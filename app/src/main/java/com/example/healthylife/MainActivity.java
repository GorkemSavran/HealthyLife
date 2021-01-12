package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity/* implements OnClickListener*/ {
    Button loginButton;
    EditText usernameText, passwordText;
    TextView forgotPassText, signUpText;
    Context context =this;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(context, MainScreen.class);
        startActivity(intent);
        /*init();
        loginButton.setOnClickListener(this);
        forgotPassText.setOnClickListener(this);
        signUpText.setOnClickListener(this);*/

    }
   /*
    public void init(){
        usernameText = findViewById(R.id.username);
        passwordText = findViewById(R.id.password);
        forgotPassText = findViewById(R.id.forgot_pass);
        signUpText =  findViewById(R.id.sign_up);
        loginButton = findViewById(R.id.login_button);
    }


    @Override
    public void onClick(View v) { //v tıklanan buton
        //deren bir numara <3
      switch (v.getId()){
          case R.id.login_button:
              if (usernameText.getText().toString().equals("")  && passwordText.getText().toString().equals("") ) {
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