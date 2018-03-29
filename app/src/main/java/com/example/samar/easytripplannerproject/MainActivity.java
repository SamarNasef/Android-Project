package com.example.samar.easytripplannerproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button logIn;
    Button signUp;
    Intent loginIntent;
    Intent signupIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logIn = findViewById(R.id.Login);
        signUp =findViewById(R.id.signup);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginIntent = new Intent(MainActivity.this,loginActivity.class);
                startActivity(loginIntent);



            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //fb v = 12.0.1

                signupIntent = new Intent(MainActivity.this,signupActivity.class);
                startActivity(signupIntent);



            }
        });

    }
}
