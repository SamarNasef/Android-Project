package com.example.samar.easytripplannerproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button logIn;
    private Button signUp;
    private Intent loginIntent;
    private Intent signupIntent;
    public static final String shP ="login";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logIn = findViewById(R.id.Login);
        signUp =findViewById(R.id.signup);

        SharedPreferences setting = getSharedPreferences(shP,0);
        String LoginStatus = setting.getString("flag","0");

        if(LoginStatus.equals("true"))
        {
            /*
            SharedPreferences.Editor  edit=  setting.edit();
            edit.putString("flag","tru");
            edit.commit();*/
            Intent tohome = new Intent(MainActivity.this,homeActivity.class);
            startActivity(tohome);
            finish();
        }


        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginIntent = new Intent(MainActivity.this,loginActivity.class);
                //loginIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);Intent.FLAG_ACTIVITY_REORDER_TO_FRONT

                startActivity(loginIntent);
                finish();



            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //fb v = 12.0.1

                signupIntent = new Intent(MainActivity.this,signupActivity.class);

                startActivity(signupIntent);
                finish();



            }
        });

    }
}
