package com.example.healthylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    Button backButton, signInBtn;
    EditText usernameText, emailText, passwordText, confPasswordText;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
        backButton.setOnClickListener(this);
        signInBtn.setOnClickListener(this);
    }
    public void init() {
        backButton = findViewById(R.id.backbutton2);
        signInBtn = findViewById(R.id.sign_in);
        emailText = findViewById(R.id.email2);
        usernameText = findViewById(R.id.username2);
        passwordText = findViewById(R.id.password2);
        confPasswordText = findViewById(R.id.conf_password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backbutton2:
                finish();
                break;
            case R.id.sign_in:
                if (usernameText.getText().toString().equals("gorkem")  && emailText.getText().toString().equals("gorkem789@") && passwordText.getText().toString().equals("2") &&
                        confPasswordText.getText().toString().equals("2")) {
                    Intent intent2 = new Intent(context, GoalPage.class);
                    startActivity(intent2);

                }
                else {
                    Toast.makeText(context, "Kullanıcı adı kullanılmakta!", LENGTH_SHORT).show();
                }
        }
    }
}