package com.example.samar.easytripplannerproject;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity {



    EditText select_date;
    private  int mYear;
    private  int mMonth;
    private  int mDay;

    DatabaseReference rootRef;

    DatabaseReference demoRef;
    DatabaseReference demoRef1;
    DatabaseReference demoRef2;
    Button save;
    EditText trip_name;
    EditText add_notes;
    EditText trip_date;
    Intent comingIntent;

    EditText start_point;
    EditText end_point;
    int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;

    PlaceAutocompleteFragment autocompleteFragment;
    PlaceAutocompleteFragment autocompleteFragment1;

    // private FirebaseDatabase mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comingIntent=getIntent();

        save=findViewById(R.id.save);
        add_notes=findViewById(R.id.addNote);
        trip_date=findViewById(R.id.tripDateAndTime);
        trip_name=findViewById(R.id.tripName);

        select_date=findViewById(R.id.tripDateAndTime);




        //date and time
        select_date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Calendar mcurrentDate = Calendar.getInstance();
                mYear = mcurrentDate.get(Calendar.YEAR);
                mMonth = mcurrentDate.get(Calendar.MONTH);
                mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                final DatePickerDialog mDatePicker = new DatePickerDialog(Main2Activity.this, new DatePickerDialog.OnDateSetListener() {


                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        Calendar myCalendar = Calendar.getInstance();
                        myCalendar.set(Calendar.YEAR, selectedyear);
                        myCalendar.set(Calendar.MONTH, selectedmonth);
                        myCalendar.set(Calendar.DAY_OF_MONTH, selectedday);
                        String myFormat = "dd/MM/yy";
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);


                        select_date.setText(sdf.format(myCalendar.getTime()));

                        mDay = selectedday;
                        mMonth = selectedmonth;
                        mYear = selectedyear;
                    }
                }, mYear, mMonth, mDay);

                mDatePicker.show();
            }
        });


// autocomplete start point

        autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);


        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                //  Log.i(TAG, "Place: " + place.getName());

                String place_name= place.getName().toString();
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                // Log.i(TAG, "An error occurred: " + status);
            }
        });

//autocomplete end point


        autocompleteFragment1 = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment1);




        autocompleteFragment1.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                //  Log.i(TAG, "Place: " + place.getName());

                String place_name1= place.getName().toString();
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                // Log.i(TAG, "An error occurred: " + status);
            }
        });


        //save data in firebase

       // rootRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://androidproject1-58342.firebaseio.com/trips");
        rootRef = FirebaseDatabase.getInstance().getReference();
        //database reference pointing to demo node

        demoRef = rootRef.child("trip");
//        demoRef = rootRef.child("name");
//       demoRef1 = rootRef.child("date");

        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                String name = trip_name.getText().toString();
                String date = trip_date.getText().toString();
                String note = add_notes.getText().toString();
                String email=comingIntent.getStringExtra("userEmail");




                start_point = (EditText)autocompleteFragment.getView().findViewById(R.id.place_autocomplete_search_input);


                String startpoint=start_point.getText().toString();




                end_point = (EditText)autocompleteFragment1.getView().findViewById(R.id.place_autocomplete_search_input);


                String endpoint=end_point.getText().toString();

                // String userId="";



                User user = new User(email,name, date,note,startpoint,endpoint);

                demoRef.push().setValue(user);


                //push creates a unique id in database
//                demoRef.push().setValue(name);
//                demoRef1.push().setValue(date);
//                demoRef2.push().setValue(note);

                Toast.makeText(Main2Activity.this, "Done!",
                        Toast.LENGTH_LONG).show();

                trip_name.setText("");
                trip_date.setText("");
                add_notes.setText("");
                start_point.setText("");
                end_point.setText("");





            }








        });


    }

}

