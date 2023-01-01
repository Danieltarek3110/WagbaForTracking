package com.example.wagbafortracking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button CheckOrders , SigninRestaurant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckOrders = findViewById(R.id.button_Check_Orders);
        SigninRestaurant = findViewById(R.id.RestaurantSignIn);

        CheckOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Orders.class);

                startActivity(intent);

            }
        });

        SigninRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext() , Sign_Up.class);

                startActivity(intent);
            }
        });
    }
}