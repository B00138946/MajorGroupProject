package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class ForgotPass extends AppCompatActivity {

    private EditText emailEditText;
    private Button buttonForgot;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass);


        emailEditText = (EditText) findViewById(R.id.email);
        buttonForgot = (Button) findViewById(R.id.buttonForgot);

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();


        buttonForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgetP();
            }
        });


    }

    private void forgetP() {
        String email = String.valueOf(emailEditText.getText());

        //validation for fields
        //if the fields are left blank you'll get error codes
        if (email.isEmpty()) {
            emailEditText.setError("Please Enter Email Address");
            return;
        }
        //validation if email does not match pattern it will give an error
        if (email.length() < 8) {
            emailEditText.setError("email must be minimum 8 characters");
            return;

        }

        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

                    Toast.makeText(ForgotPass.this, "A link has been sent to your email, Please check your email.", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(ForgotPass.this, "Try again, email not sent.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}