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
    Button backbutton2, sign_in;
    EditText username2, email2, password2, conf_password;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
        backbutton2.setOnClickListener(this);
        sign_in.setOnClickListener(this);
    }
    public void init() {
        backbutton2 = findViewById(R.id.backbutton2);
        sign_in = findViewById(R.id.sign_in);
        email2 = findViewById(R.id.email2);
        username2 = findViewById(R.id.username2);
        password2 = findViewById(R.id.password2);
        conf_password = findViewById(R.id.conf_password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backbutton2:
                finish();
                break;
            case R.id.sign_in:
                if (username2.getText().toString().equals("gorkem")  && email2.getText().toString().equals("gorkem789@") && password2.getText().toString().equals("2") &&
                        conf_password.getText().toString().equals("2")) {
                    Intent intent2 = new Intent(context, GoalPage.class);
                    startActivity(intent2);

                }
                else {
                    Toast.makeText(context, "Kullanıcı adı kullanılmakta!", LENGTH_SHORT).show();
                }
        }
    }
}