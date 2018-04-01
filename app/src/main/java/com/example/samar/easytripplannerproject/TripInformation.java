package com.example.samar.easytripplannerproject;

/**
 * Created by samar on 01/04/18.
 */

public class TripInformation {
    private String tripName;
    private String tripDate;
    private String tripTo;
    private String tripFrom;
    private String tripNote;
    private String tripType;

    public TripInformation(String tripName, String tripDate, String tripTo, String tripFrom, String tripNote, String tripType) {
        this.tripName = tripName;
        this.tripDate = tripDate;
        this.tripTo = tripTo;
        this.tripFrom = tripFrom;
        this.tripNote = tripNote;
        this.tripType = tripType;
    }

    public String getTripName() {
        return tripName;
    }

    public String getTripDate() {
        return tripDate;
    }

    public String getTripTo() {
        return tripTo;
    }

    public String getTripFrom() {
        return tripFrom;
    }

    public String getTripNote() {
        return tripNote;
    }

    public String getTripType() {
        return tripType;
    }
}
