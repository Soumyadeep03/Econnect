package com.example.myapp;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity  {
    Button Signin;
    EditText email,password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Signin = (Button)findViewById(R.id.SignIn);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(email.getText().toString().equals("paramanicksoumyadeep@gmail.com") &&
                        password.getText().toString().equals("Soumyadeep2003")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();
                    openNewActivity();

                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                }


            }
        });

    }
    public void openNewActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}