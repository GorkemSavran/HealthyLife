package com.example.healthylife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

// GÖRKEM SAVRAN
public class EmailVerification extends AppCompatActivity implements View.OnClickListener {
    FirebaseAuth mAuth;

    TextView emailVerifiedText;
    Button continueButton;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);
        mAuth = FirebaseAuth.getInstance();
        init();
    }

    private void init() {
        emailVerifiedText = findViewById(R.id.email_verified_text);
        continueButton = findViewById(R.id.continue_btn);

        emailVerifiedText.setText("Verification email is sent. Please verify your email and then continue.");

        continueButton.setOnClickListener(this);
    }

    private void login() {
        Intent intent = getIntent();
        String email = intent.getExtras().getString("email");
        String password = intent.getExtras().getString("password");
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            if(user.isEmailVerified()) {
                                Intent intent = new Intent (context, GoalPage.class);
                                startActivity(intent); //explicit intent -> gideceği yer belli
                            } else {
                                Toast.makeText(EmailVerification.this, "Please verify your email.",
                                        Toast.LENGTH_SHORT).show();
                            }

                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.continue_btn) {
            login();
        }
    }
}