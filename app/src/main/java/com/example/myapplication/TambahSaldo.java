package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TambahSaldo extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private int topup, total, saldo_awal;
    private Button dualima, limapuluh, seratus, seratusdualima, tigaratus, limaratus;
    private FirebaseDatabase database;
    private DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_saldo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user= mAuth.getCurrentUser();

        database = FirebaseDatabase.getInstance();
        final DatabaseReference reff = database.getReference("Data User").child(user.getUid()).child("saldo");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String saldo = dataSnapshot.getValue(String.class);
                saldo_awal = Integer.parseInt(saldo);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Log.d("asd",user.getUid());

        dualima = (Button) findViewById(R.id.dualima);
        limapuluh = (Button) findViewById(R.id.limapuluh);
        seratus = (Button) findViewById(R.id.seratus);
        seratusdualima = (Button) findViewById(R.id.seratusdualima);
        tigaratus = (Button) findViewById(R.id.tigaseratus);
        limaratus = (Button) findViewById(R.id.limaratus);

        dualima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topup=25000;
                total = saldo_awal+topup;
                reff.setValue(String.valueOf(total));
                startActivity(new Intent(TambahSaldo.this,Dashboard.class));
            }
        });

        limapuluh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topup=50000;
                total = saldo_awal+topup;
                reff.setValue(String.valueOf(total));
                startActivity(new Intent(TambahSaldo.this,Dashboard.class));
            }
        });

        seratus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topup=100000;
                total = saldo_awal+topup;
                reff.setValue(String.valueOf(total));
                startActivity(new Intent(TambahSaldo.this,Dashboard.class));
            }
        });

        seratusdualima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topup=125000;
                total = saldo_awal+topup;
                reff.setValue(String.valueOf(total));
                startActivity(new Intent(TambahSaldo.this,Dashboard.class));
            }
        });

        tigaratus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topup=300000;
                total = saldo_awal+topup;
                reff.setValue(String.valueOf(total));
                startActivity(new Intent(TambahSaldo.this,Dashboard.class));
            }
        });

        limaratus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topup=500000;
                total = saldo_awal+topup;
                reff.setValue(String.valueOf(total));
                startActivity(new Intent(TambahSaldo.this,Dashboard.class));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
