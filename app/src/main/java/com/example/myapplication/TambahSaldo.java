package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TambahSaldo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_saldo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
