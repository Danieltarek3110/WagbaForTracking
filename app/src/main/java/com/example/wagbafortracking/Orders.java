package com.example.wagbafortracking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Orders extends AppCompatActivity {

    ArrayList<Orders_Model> orders_models = new ArrayList<>();


    FirebaseDatabase database = FirebaseDatabase.getInstance("https://wagba01-default-rtdb.europe-west1.firebasedatabase.app/");
    DatabaseReference RootNode = database.getReference("Wagba");
    DatabaseReference UserNode = RootNode.child("user");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        RecyclerView recyclerView = findViewById(R.id.OrdersRecyclerView);

        UserNode.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                orders_models.clear();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    final String UserID = postSnapshot.getKey();
                    for (DataSnapshot childsnap : postSnapshot.child("orders").getChildren()) {

                        final String OrderID = childsnap.getKey();
                        orders_models.add(new Orders_Model(childsnap.child("trackingNumber").getValue(String.class)
                                ,childsnap.child("state").getValue(String.class),
                                childsnap.child("price").getValue(String.class) , OrderID , UserID ));
                    }
                }


                Orders_RV_Adapter adapter = new Orders_RV_Adapter(Orders.this , orders_models);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(Orders.this));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG", "onCancelled", databaseError.toException());
            }
        });

    }

}
