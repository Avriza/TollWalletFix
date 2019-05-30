package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListTransaksi extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private ArrayList<UserInformation> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_transaksi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addData();
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
