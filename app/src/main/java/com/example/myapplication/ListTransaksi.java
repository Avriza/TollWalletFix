package com.example.myapplication;

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

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference reff;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private ArrayList<UserInformation> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_transaksi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*final FirebaseUser user= mAuth.getCurrentUser();*/
        database = FirebaseDatabase.getInstance();
        DatabaseReference reff = database.getReference("Data User");

        /*userList = new ArrayList<>();
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    UserInformation userInformation = dataSnapshot1.getValue(UserInformation.class);
                    String name = userInformation.getName();
                    String pass = userInformation.getPass();
                    String email = userInformation.getEmail();
                    String plat = userInformation.getPlat();
                    String saldo = userInformation.getSaldo();
                    userInformation.setName(name);
                    userInformation.setPass(pass);
                    userInformation.setEmail(email);
                    userInformation.setPlat(plat);
                    userInformation.setSaldo(saldo);

                    userList.add(userInformation);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

        addData();
        Log.d("asd", String.valueOf(userList));
        recyclerView = (RecyclerView) findViewById(R.id.list_item);
        userAdapter = new UserAdapter(userList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListTransaksi.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(userAdapter);
    }

    private void addData() {
        userList = new ArrayList<>();
        userList.add(new UserInformation("asd","pass","asd@gmail.com","123","D 123 AD","Rp 25000"));
        userList.add(new UserInformation("asd","pass","asd@gmail.com","123","D 123 AD","Rp 25000"));
        userList.add(new UserInformation("asd","pass","asd@gmail.com","123","D 123 AD","Rp 25000"));
        userList.add(new UserInformation("asd","pass","asd@gmail.com","123","D 123 AD","Rp 25000"));
        userList.add(new UserInformation("asd","pass","asd@gmail.com","123","D 123 AD","Rp 25000"));
        userList.add(new UserInformation("asd","pass","asd@gmail.com","123","D 123 AD","Rp 25000"));
        userList.add(new UserInformation("asd","pass","asd@gmail.com","123","D 123 AD","Rp 25000"));
    }
}
