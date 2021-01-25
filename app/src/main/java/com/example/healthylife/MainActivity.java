package com.example.healthylife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

// GÖRKEM SAVRAN
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button loginButton;
    EditText emailText, passwordText;
    TextView forgotPassText, signUpText;
    Context context =this;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goToMainScreenUserExist();
        init();
        loginButton.setOnClickListener(this);
        forgotPassText.setOnClickListener(this);
        signUpText.setOnClickListener(this);
    }

    private void goToMainScreenUserExist() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null) {
            if(currentUser.isEmailVerified()) {
                Intent intent1 = new Intent (context, MainScreen.class);
                startActivity(intent1);
            }
        }
    }

    private void login() {
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        if(email.isEmpty() || password.isEmpty()) {
            Toast.makeText(MainActivity.this, "Email and password cannot be null.",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            if(user.isEmailVerified()) {
                                Intent intent1 = new Intent (context, MainScreen.class);
                                startActivity(intent1); //explicit intent -> gideceği yer belli
                            } else {
                                Toast.makeText(MainActivity.this, "Please verify your email.",
                                        Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("", "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Email or password is wrong.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void init(){
        emailText = findViewById(R.id.email_address);
        passwordText = findViewById(R.id.password);
        forgotPassText = findViewById(R.id.forgot_pass);
        signUpText =  findViewById(R.id.sign_up);
        loginButton = findViewById(R.id.login_button);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_button:
                login();
                break;
            case R.id.forgot_pass:
                Intent intent2 = new Intent (context, ForgotPassword.class);
                startActivity(intent2);
                break;
            case R.id.sign_up:
                Intent intent3 = new Intent (context, SignUp.class);
                startActivity(intent3);
                break;


        }
    }
}