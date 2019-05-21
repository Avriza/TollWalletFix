package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Dashboard extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference reff;
    private Button topup;
    private TextView cur_saldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        cur_saldo = (TextView) findViewById(R.id.cur_saldo);



        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() == null){
            startActivity(new Intent(this, Login.class));
        }
        FirebaseUser user= mAuth.getCurrentUser();


        /* BUAT UPDATE DATABASE*/
        database = FirebaseDatabase.getInstance();
        /*DatabaseReference reff = database.getReference("DataKendaraan");*/
        DatabaseReference reff = database.getReference("Data User").child(user.getUid()).child("saldo");
        /*reff.setValue("12345678");*/


        Log.d("asd", String.valueOf(reff));
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                /*DataKendaraan information =dataSnapshot.getValue(DataKendaraan.class);*/
                String information =dataSnapshot.getValue(String.class);

                Log.d("saldo", "maunya apa "+information);
                cur_saldo.setText("Rp "+information);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        topup = (Button) findViewById(R.id.topup);
        topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, TambahSaldo.class));
            }
        });
    }
}
