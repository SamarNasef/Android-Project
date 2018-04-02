package com.example.samar.easytripplannerproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import android.util.Log;

import org.json.JSONObject;

public class homeActivity extends AppCompatActivity implements ItemClickListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;
    private List<TripInformation> trips;
    //
    private DatabaseReference databaseReference;
    Intent userId;
    Intent toAddTrip;
    String data;

    public static final String shP ="login";
    //
    Button addtripBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //trips = new ArrayList<>();
        //trips.add(new TripInformation("school","date","to","from","note","type"));
        //

        databaseReference = FirebaseDatabase.getInstance().getReference();

       TripInformation tripInfo = new TripInformation("wrok","2018/03/01","Bani Ebeid","Mansoura","any note","round");
        userId = getIntent();

        data = userId.getStringExtra("userId");
        Toast.makeText(this,"hi"+data,Toast.LENGTH_SHORT).show();
        databaseReference.child("x").setValue(tripInfo);
        Toast.makeText(this,"data saved",Toast.LENGTH_SHORT).show();


        //read data


        if(data == null){

            SharedPreferences setting = getSharedPreferences(shP,0);
            data = setting.getString("email","0");



        }
       data = data.split("@")[0];


        databaseReference.child(data).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                trips = new ArrayList<>();
                //trips.clear();
               // Log.i("mytag",dataSnapshot.getValue());

                TripInformation x =  dataSnapshot.getValue(TripInformation.class);

               Log.i("mytag","trip name: "+x);
               System.out.println("trip: "+x);
               for(DataSnapshot xx : dataSnapshot.getChildren())
               {
                   TripInformation tInfo = xx.getValue(TripInformation.class);
                   Toast.makeText(homeActivity.this,"trip: "+tInfo.getTripName(),Toast.LENGTH_SHORT).show();
                   trips.add(tInfo);
               }



                //TripInformation tripInfo = new TripInformation();



               // TripInformation tripInfo =  dataSnapshot.getValue(TripInformation.class);
                //trips.add(tripInfo);
                recyclerView = findViewById(R.id.tripView);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(homeActivity.this));

                /*listItems = new ArrayList<>();

                for(int i=0;i<10;i++){
     //               ListItem listItem = new ListItem("trip "+(i+1),"time of trip");
                  ListItem listItem = new ListItem("trip: "+trips.get(0).getTripName(),"date "+trips.get(0).getTripDate());
                    listItems.add(listItem);

                }*/
                adapter = new MyRecyclarViewAdapter(trips,homeActivity.this);
                recyclerView.setAdapter(adapter);




                //for(DataSnapshot tripSnapshot : dataSnapshot.getChildren()){
                    //TripInformation tripInfo = tripSnapshot.getValue(TripInformation.class);
                    //trips.add(tripInfo);



                //}

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        //
        //trips.get(0).getTripName()
//        Toast.makeText(homeActivity.this,"from trips: "+trips.size(),Toast.LENGTH_SHORT).show();
/*
        recyclerView = findViewById(R.id.tripView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        for(int i=0;i<10;i++){
            ListItem listItem = new ListItem("trip "+(i+1),"time of trip");
//          ListItem listItem = new ListItem("trip: "+trips.get(0).getTripName(),"date "+trips.get(0).getTripDate());
            listItems.add(listItem);

        }
        adapter = new MyRecyclarViewAdapter(listItems,this);
        recyclerView.setAdapter(adapter);
*/
        addtripBtn = findViewById(R.id.addtripBtn);
        addtripBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(homeActivity.this,"add trip",Toast.LENGTH_SHORT).show();
                toAddTrip = new Intent(homeActivity.this,AddingTripActivity.class);
                toAddTrip.putExtra("userEmail",data);
                startActivity(toAddTrip);





            }
        });

    }

    @Override
    public void onClick(View view, int position, boolean isLongClick) {
        Intent y = new Intent(homeActivity.this,ShowTripActivity.class);
        startActivity(y);
    }
/*
    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                trips.clear();

                for(DataSnapshot tripSnapshot : dataSnapshot.getChildren()){
                    TripInformation tripInfo = tripSnapshot.getValue(TripInformation.class);
                    trips.add(tripInfo);
                    //Toast.makeText(homeActivity.this,tripInfo.getTripName(),Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }*/
}
