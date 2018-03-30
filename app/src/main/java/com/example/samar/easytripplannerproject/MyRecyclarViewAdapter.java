package com.example.samar.easytripplannerproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by samar on 30/03/18.
 */

public class MyRecyclarViewAdapter extends RecyclerView.Adapter<MyRecyclarViewAdapter.ViewHolder>{


    private  List<ListItem> listItems;
    private Context context;

    public MyRecyclarViewAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

        return new ViewHolder(v);


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       ListItem listItem =  listItems.get(position);
       holder.itemTextview.setText(listItem.getItem());
       holder.descTextview.setText(listItem.getDesc());
       

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView itemTextview;
        public TextView descTextview;


        public ViewHolder(View itemView) {
            super(itemView);

            itemTextview = itemView.findViewById(R.id.itemTxt);
            descTextview = itemView.findViewById(R.id.descTxt);
        }

    }



}
