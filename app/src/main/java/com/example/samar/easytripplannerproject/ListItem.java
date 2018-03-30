package com.example.samar.easytripplannerproject;

/**
 * Created by samar on 30/03/18.
 */

public class ListItem {
    private String item;
    private String desc;

    public ListItem(String item, String desc) {
        this.item = item;
        this.desc = desc;
    }

    public String getItem() {
        return item;
    }

    public String getDesc() {
        return desc;
    }

}
