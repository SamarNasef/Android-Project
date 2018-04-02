package com.example.samar.easytripplannerproject;

/**
 * Created by aya on 29/03/18.
 */

public class User {


        public String tripName;
        public String tripDate;
        public String tripNote;
        public String tripFrom;
        public String tripTo;
       public String  userId;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public User(String userId, String tripName, String tripDate, String tripNote, String tripFrom, String tripTo) {
            this.userId=userId;
            this.tripName = tripName;
            this.tripDate= tripDate;
            this.tripNote= tripNote;
            this.tripFrom=tripFrom;
            this.tripTo=tripTo;

        }

    }


