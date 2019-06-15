package com.example.myapplication;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListTransaksi extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference reff;
    RecyclerView recyclerView;
    UserAdapter userAdapter;
    ArrayList<Transaksi> transaksiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_transaksi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*final FirebaseUser user= mAuth.getCurrentUser();*/
        database = FirebaseDatabase.getInstance();
        reff = database.getReference("DataTransaksi").child("4477996");

        transaksiList = new ArrayList<>();
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    Transaksi transaksi= dataSnapshot1.getValue(Transaksi.class);
                    transaksiList.add(transaksi);
                }
                recyclerView = (RecyclerView) findViewById(R.id.list_item);
                userAdapter = new UserAdapter(transaksiList);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListTransaksi.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(userAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
