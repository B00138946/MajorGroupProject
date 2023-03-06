package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//action listener for button
public class Login extends AppCompatActivity {

    FirebaseAuth mAuth;
    private TextView register1;
    private TextView forgot;
    EditText username1, email1, password1, firstname1, lastname1;
    Button buttonLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        register1 = (TextView) findViewById(R.id.register1);
        forgot = (TextView) findViewById(R.id.forgot);


        email1 = (EditText) findViewById(R.id.email);
        password1 = (EditText) findViewById(R.id.password);
        buttonLog = findViewById(R.id.buttonLog);


        //when "create account" text is pressed it redirects to register page
        register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, com.example.test.Register.class);
                startActivity(intent);
            }
        });
        //when "Forget my Password" text is pressed it redirects to forgotpass page
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, ForgotPass.class);
                startActivity(intent);
            }
        });

        buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = String.valueOf(email1.getText());
                String password = String.valueOf(password1.getText());

                //validation for fields
                //if the fields are left blank you'll get error codes
                if (email.isEmpty()) {
                    email1.setError("Please Enter Email Address");
                    return;
                }
                //validation if email is less than 8 character it will give an error
                if (email.length() < 8) {
                    email1.setError("email must be minimum 8 characters");
                    return;

                }
                if (password.isEmpty()) {
                    password1.setError("Please Enter Password");
                    return;

                }
                //validation if password is less than 8 character it will give an error
                if (password.length() < 8) {
                    password1.setError("Password must be minimum 8 characters");
                    return;


                }
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(Login.this, "You have Logged In.",Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(Login.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Login.this, "failed to Log in.",Toast.LENGTH_SHORT).show();


                                }
                            }
                        });




            }
        });




    }
}

