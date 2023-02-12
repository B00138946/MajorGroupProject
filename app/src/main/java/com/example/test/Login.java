package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//action listener for button
public class Login extends AppCompatActivity {

    private TextView register1;
    private TextView forgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        register1 = (TextView) findViewById(R.id.register1);
        forgot = (TextView) findViewById(R.id.forgot);


        //when "create account" text is pressed it redirects to register page
        register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
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




    }
}