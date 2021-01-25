package com.example.healthylife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

// GÖRKEM SAVRAN

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;

    Button backButton, signInBtn;
    EditText usernameText, emailText, passwordText, confPasswordText;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
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

    private void registerUser() {
        final String password = passwordText.getText().toString();
        String confirmPassword = confPasswordText.getText().toString();
        final String email = emailText.getText().toString();
        final String username = usernameText.getText().toString();

        if(password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty() || username.isEmpty()) {
            Toast.makeText(SignUp.this, "Fields cannot be null.",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if(!password.equals(confirmPassword)) {
            Toast.makeText(SignUp.this, "Password and Confirm Password must be same.",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if(password.length() < 6) {
            Toast.makeText(SignUp.this, "Password length must be greater or equal than 6 characters.",
                    Toast.LENGTH_SHORT).show();
            return;
        }


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            UserProfileChangeRequest userProfileChangeRequest = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(username)
                                    .build();
                            final FirebaseUser user = mAuth.getCurrentUser();
                            user.updateProfile(userProfileChangeRequest).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Log.d("", "createUserWithEmail:success");
                                        user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                Log.d("", "Email sent.");
                                                Intent intent = new Intent (context, EmailVerification.class);
                                                intent.putExtra("email", email);
                                                intent.putExtra("password", password);
                                                startActivity(intent);
                                            }
                                        });
                                    }
                                }
                            });
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backbutton2:
                finish();
                break;
            case R.id.sign_in:
                registerUser();
                break;
        }
    }
}