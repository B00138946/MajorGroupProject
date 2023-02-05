package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//action listener for button
public class Login extends AppCompatActivity implements View.OnClickListener {

    private TextView register1;
    private TextView forgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //when "create account" text is pressed it redirects to register page
        register1 = (TextView) findViewById(R.id.register1);
        forgot = (TextView) findViewById(R.id.forgot);
        register1.setOnClickListener(this);
        forgot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register1:
                startActivity(new Intent(Login.this, Register.class));
                break;
            case R.id.forgot:
                startActivity(new Intent(Login.this, ForgotPass.class));
                break;

        }
    }
}