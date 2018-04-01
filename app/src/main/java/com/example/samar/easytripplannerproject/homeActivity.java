package com.example.samar.easytripplannerproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class homeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;
    //
    private DatabaseReference databaseReference;
    Intent userId;
    Intent toAddTrip;
    //
    Button addtripBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //
        /*
        databaseReference = FirebaseDatabase.getInstance().getReference();

        TripInformation tripInfo = new TripInformation("work","2018/03/01","mans","mans","any note","round");
        userId = getIntent();

        String data = userId.getStringExtra("userId");
        Toast.makeText(this,"hi"+data,Toast.LENGTH_SHORT).show();
        databaseReference.child("x").setValue(tripInfo);
        Toast.makeText(this,"data saved",Toast.LENGTH_SHORT).show();
*/

        //
        recyclerView = findViewById(R.id.tripView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        for(int i=0;i<10;i++){
            ListItem listItem = new ListItem("trip "+(i+1),"time of trip");
            listItems.add(listItem);

        }
        adapter = new MyRecyclarViewAdapter(listItems,this);
        recyclerView.setAdapter(adapter);

        addtripBtn = findViewById(R.id.addtripBtn);
        addtripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(homeActivity.this,"add trip",Toast.LENGTH_SHORT).show();
                //toAddTrip = new Intent(homeActivity.this,Main2Activity.class);
                //startActivity(toAddTrip);

            }
        });

    }
}
