package com.example.samar.easytripplannerproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowTripActivity extends AppCompatActivity {
    Intent details;
    TextView tripNameTxt;
    TextView tripDateTxt;
    TextView tripFromTxt;
    TextView tripToTxt;
    TextView tripNoteTxt;
    Button startTrip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_trip);

        details = getIntent();
        String data = details.getStringExtra("note");

        tripNameTxt = findViewById(R.id.tripNameTxt);
        tripDateTxt = findViewById(R.id.tripDateTxt);
        tripFromTxt = findViewById(R.id.tripFromxt);
        tripToTxt = findViewById(R.id.tripToTxt);
        tripNoteTxt = findViewById(R.id.tripNoteTxt);
        startTrip = findViewById(R.id.startTrip);



        tripNameTxt.setText("Name: "+details.getStringExtra("name"));
        tripToTxt.setText("To: "+details.getStringExtra("to"));
        tripFromTxt.setText("From: "+details.getStringExtra("from"));
        tripNoteTxt.setText("Note: "+details.getStringExtra("note"));
        tripDateTxt.setText("Date: "+details.getStringExtra("date"));
        final String To = details.getStringExtra("to");
        final String From = details.getStringExtra("from");

        startTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?saddr="+From+"&daddr="+To));//Dikirnis
                startActivity(intent);
            }
        });
    }
}
