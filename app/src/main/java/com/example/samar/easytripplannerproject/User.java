package com.example.samar.easytripplannerproject;

/**
 * Created by aya on 29/03/18.
 */

public class User {


        public String trip_name;
        public String trip_date;
        public String trip_note;
        public String start_point;
        public String end_point;
       public String  userId;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public User(String userId, String trip_name, String trip_date, String trip_note, String start_point, String end_point) {
            this.userId=userId;
            this.trip_name = trip_name;
            this.trip_date= trip_date;
            this.trip_note= trip_note;
            this.start_point=start_point;
            this.end_point=end_point;

        }

    }


