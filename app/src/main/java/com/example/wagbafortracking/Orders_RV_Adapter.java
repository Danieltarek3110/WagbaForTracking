package com.example.wagbafortracking;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Orders_RV_Adapter extends RecyclerView.Adapter<Orders_RV_Adapter.MyViewHolder> {

    Context context; ArrayList<Orders_Model> orders_models;
    FirebaseDatabase database = FirebaseDatabase.getInstance("https://wagba01-default-rtdb.europe-west1.firebasedatabase.app/");
    DatabaseReference myRef = database.getReference("Wagba");


    public Orders_RV_Adapter(Context context , ArrayList<Orders_Model> orders_models){
        this.context = context;
        this.orders_models = orders_models;

    }

    @NonNull
    @Override
    public Orders_RV_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.orders_row , parent , false);

        return new Orders_RV_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Orders_RV_Adapter.MyViewHolder holder, int position) {

        holder.OrderPrice.setText(orders_models.get(holder.getAdapterPosition()).getPrice());
        holder.OrderState.setText(orders_models.get(holder.getAdapterPosition()).getState());
        holder.OrderTrackingNum.setText(orders_models.get(holder.getAdapterPosition()).getTrackingNumber());

        holder.Accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference("Wagba").child("user").child(orders_models.get(holder.getAdapterPosition()).getUserID()).child("orders").child(orders_models.get(holder.getAdapterPosition()).getOrderId()).child("state").setValue("Accepted");
            }
        });

        holder.Reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase.getInstance().getReference("Wagba").child("user").child(orders_models.get(holder.getAdapterPosition()).getUserID()).child("orders").child(orders_models.get(holder.getAdapterPosition()).getOrderId()).child("state").setValue("Rejected");
            }
        });



    }

    @Override
    public int getItemCount() {
        return orders_models.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView OrderTrackingNum , OrderState , OrderPrice;
        Button Accept;
        Button Reject;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            OrderTrackingNum = itemView.findViewById(R.id.OrderTracking);
            OrderState = itemView.findViewById(R.id.OrderState);
            OrderPrice = itemView.findViewById(R.id.OrderPrice);
            Accept = itemView.findViewById(R.id.button_AcceptOrder);
            Reject = itemView.findViewById(R.id.button_Reject);

        }
    }



}
