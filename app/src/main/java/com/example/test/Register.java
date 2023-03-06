package com.example.test;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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


public class Register extends AppCompatActivity{

    FirebaseAuth mAuth;

    private EditText username1, email1, password1, firstname1, lastname1;
    private Button createAccBt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


        username1 = (EditText) findViewById(R.id.username);
        email1 = (EditText) findViewById(R.id.email);
        password1 = (EditText) findViewById(R.id.password);
        firstname1 = (EditText) findViewById(R.id.Name);
        lastname1 = (EditText) findViewById(R.id.LastName);
        createAccBt = findViewById(R.id.button1);

        //when the fields are left blank and register button is clicked then youll get erros
        createAccBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username, email, password, firstname, lastname;
                username = String.valueOf(username1.getText());
                email = String.valueOf(email1.getText());
                password = String.valueOf(password1.getText());
                firstname = String.valueOf(firstname1.getText());
                lastname = String.valueOf(lastname1.getText());

                //if the fields are left blank you'll get error codes
                //validation for fields
                if (username.isEmpty()) {
                    username1.setError("Please Enter Username");
                    return;
                }
                if (email.isEmpty()) {
                    email1.setError("Please Enter Email Address");
                    return;

                }
                if (password.isEmpty()) {
                    password1.setError("Please Enter Password");
                    return;
                }
                if (firstname.isEmpty()) {
                    firstname1.setError("Please Enter First Name");
                    return;

                }
                if (lastname.isEmpty()) {
                    lastname1.setError("Please Enter Last Name");
                    return;

                }

                //validation if fields are less than 8 character it will give an error
                if (username.length() < 5) {
                    username1.setError("Username must be minimum 5 characters");
                    return;
                }

                if (email.length() < 8) {
                    email1.setError("Email must be minimum 8 characters");
                    return;
                }

                if (password.length() < 8) {
                    password1.setError("Password must be minimum 8 characters");
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {


                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(Register.this, "You have created an account.",
                                            Toast.LENGTH_SHORT).show();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Register.this, "failed to Create account.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });



            }
        });

    }
}