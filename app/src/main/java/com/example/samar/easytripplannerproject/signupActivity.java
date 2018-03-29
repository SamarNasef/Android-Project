package com.example.samar.easytripplannerproject;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signupActivity extends AppCompatActivity {

    private Button signupBtn;
    private EditText email;
    private EditText name;
    private EditText password;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.nameTxt);
        email = findViewById(R.id.emailTxt);
        password = findViewById(R.id.passTxt);
        signupBtn = findViewById(R.id.signupBtn);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();


        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName =  name.getText().toString();//.trim()
                String userEmail =  email.getText().toString();
                String userPass =  password.getText().toString();

                if(TextUtils.isEmpty(userName)){
                    //name is empty
                    Toast.makeText(signupActivity.this,"Please enter name",Toast.LENGTH_SHORT).show();
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
