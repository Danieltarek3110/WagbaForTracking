package com.example.wagbafortracking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;


public class Sign_Up extends AppCompatActivity {

    EditText RestaurantNamee , usrEmail , usrpassword;
    Button registerbtn , Already_A_Member;
    FirebaseAuth mAuth;
    DatabaseReference CartDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        CartDatabase = FirebaseDatabase.getInstance().getReference();
        RestaurantNamee = findViewById(R.id.RestaurantName);
        usrEmail = findViewById(R.id.EmailAddress01);
        usrpassword = findViewById(R.id.Password01);
        registerbtn = findViewById(R.id.button_Login);



        mAuth = FirebaseAuth.getInstance();
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });





    }



    private void createUser(){

        String Email = usrEmail.getText().toString();
        String RestaurantName = RestaurantNamee.getText().toString();
        String pass = usrpassword.getText().toString();



        if(TextUtils.isEmpty(Email)){
            usrEmail.setError("Email field cannot be empty");
            usrEmail.requestFocus();

        }else if(TextUtils.isEmpty(pass)){
            usrpassword.setError("Password field cannot be empty");
            usrpassword.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(Email , pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Sign_Up.this , "User Registered successfully" , Toast.LENGTH_SHORT).show();

                        //String UserId = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid() ;
                        //FirebaseDatabase.getInstance().getReference("Wagba").child("RestaurantUser").setValue(UserId);

                        startActivity(new Intent(Sign_Up.this , Login.class));
                    }else{
                        Toast.makeText(Sign_Up.this , "Registration Error: " + Objects.requireNonNull(task.getException()).getMessage() , Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}