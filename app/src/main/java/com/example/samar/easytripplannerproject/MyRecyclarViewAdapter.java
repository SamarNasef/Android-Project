package com.example.samar.easytripplannerproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samar on 30/03/18.
 */

public class MyRecyclarViewAdapter extends RecyclerView.Adapter<MyRecyclarViewAdapter.ViewHolder>{



    //private  List<ListItem> listItems;
    private List<TripInformation> listItems;

    ArrayList<ListItem> zz = new ArrayList<>() ;
    private Context context;

    //public MyRecyclarViewAdapter(List<ListItem> listItems, Context context) {
    public MyRecyclarViewAdapter(List<TripInformation> listItems, Context context) {
        //this.listItems = listItems;
        this.listItems = listItems;
        this.context = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

        return new ViewHolder(v,context,listItems);//zz


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       //final ListItem listItem =  listItems.get(position);
        final TripInformation listItem =  listItems.get(position);
       holder.itemTextview.setText(listItem.getTripName());
       holder.descTextview.setText(listItem.getTripDate());

       holder.setItemClickListener(new ItemClickListener() {
           @Override
           public void onClick(View view, int position, boolean isLongClick) {

               if(isLongClick) {
                   Toast.makeText(context, "long click: " + listItem.getTripName(), Toast.LENGTH_SHORT).show();
//                   Intent x = new Intent(context,ShowTripActivity.class);


               }else
                   Toast.makeText(context,"click: "+listItem.getTripName(),Toast.LENGTH_SHORT).show();

           }
       });



    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

        public TextView itemTextview;
        public TextView descTextview;

        private ItemClickListener itemClickListener;

        //ArrayList<ListItem> xx = new ArrayList<>();
        List<TripInformation> xx =new ArrayList<>();
        Context context;
//ArrayList<ListItem>xx
        public ViewHolder(View itemView, Context context, List<TripInformation>xx) {
            super(itemView);

            this.xx = xx;
            this.context = context;

            itemTextview = itemView.findViewById(R.id.itemTxt);
            descTextview = itemView.findViewById(R.id.descTxt);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   notifyItemChanged( getLayoutPosition());

                }
            });*/
        }

        public void setItemClickListener(ItemClickListener itemClickListener){

            this.itemClickListener = itemClickListener;

        }
        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
//            ListItem yy =  this.xx.get(position);
            TripInformation yy = this.xx.get(position);
            Intent i = new Intent(this.context , ShowTripActivity.class);
            i.putExtra("name",yy.getTripName());
            i.putExtra("from",yy.getTripFrom());
            i.putExtra("to",yy.getTripTo());
            i.putExtra("date",yy.getTripDate());
            i.putExtra("note",yy.getTripNote());
            i.putExtra("type",yy.getTripType());
            this.context.startActivity(i);

            itemClickListener.onClick(view,getAdapterPosition(),false);
        }

        @Override
        public boolean onLongClick(View view) {
            itemClickListener.onClick(view,getAdapterPosition(),true);

            return true;
        }
    }



}
