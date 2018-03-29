package com.example.samar.easytripplannerproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class signupActivity extends AppCompatActivity {

    private Button signupBtn;
    private EditText email;
    private EditText password;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private Intent intentToLogin ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email = findViewById(R.id.loginemailTxt);
        password = findViewById(R.id.loginpassTxt);
        signupBtn = findViewById(R.id.signupBtn);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        intentToLogin = new Intent(signupActivity.this,loginActivity.class);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userEmail =  email.getText().toString();
                String userPass =  password.getText().toString();

                if(TextUtils.isEmpty(userEmail) ){

                    //email is empty
                    Toast.makeText(signupActivity.this,"Please enter your e-mail",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(! Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
                    Toast.makeText(signupActivity.this,"Please enter valid e-mail",Toast.LENGTH_SHORT).show();
                    return;

                }
                if(TextUtils.isEmpty(userPass)){
                    Toast.makeText(signupActivity.this,"Please enter your password",Toast.LENGTH_SHORT).show();
                    return;

                }

                //validation is ok
                //create progressdialog
                progressDialog.setMessage("Register user ...");
                progressDialog.show();

                //firebase
                firebaseAuth.createUserWithEmailAndPassword(userEmail,userPass).addOnCompleteListener(signupActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            //user register --> login activity
                            Toast.makeText(signupActivity.this,"register successfully",Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();

                            startActivity(intentToLogin);
                            finish();

                        }
                        else{
                            Toast.makeText(signupActivity.this," couldn't register, pls. try again...",Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }

                    }
                });














            }
        });




    }
}
