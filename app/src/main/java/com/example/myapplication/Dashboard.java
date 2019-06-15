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

import java.util.ArrayList;
import java.util.Iterator;

public class Dashboard extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference reff, reff_countSaldo;
    private Button topup,trans_but;
    private TextView cur_saldo;
    String info_saldo;
    int tarif, info_saldo_int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        cur_saldo = (TextView) findViewById(R.id.cur_saldo);
        trans_but = (Button) findViewById(R.id.transaksi_but);


        topup = (Button) findViewById(R.id.topup);
        topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, TambahSaldo.class));
            }
        });

        trans_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this,ListTransaksi.class));
            }
        });

        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() == null){
            startActivity(new Intent(this, Login.class));
        }
            FirebaseUser user= mAuth.getCurrentUser();

        /* BUAT UPDATE DATABASE*/
        database = FirebaseDatabase.getInstance();
        reff = database.getReference("Data User").child(user.getUid()).child("saldo");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                info_saldo =dataSnapshot.getValue(String.class);
                cur_saldo.setText("Rp "+info_saldo);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        reff_countSaldo = database.getReference("DataTransaksi").child("4477996");
        reff_countSaldo.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Transaksi temp = dataSnapshot.getValue(Transaksi.class);
                Log.d("asd", String.valueOf(temp.getDateIn()));
                tarif = Integer.parseInt(temp.getTarif());
                info_saldo_int = Integer.parseInt(info_saldo);
                info_saldo_int = info_saldo_int - tarif;
                reff.setValue(String.valueOf(info_saldo_int));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
