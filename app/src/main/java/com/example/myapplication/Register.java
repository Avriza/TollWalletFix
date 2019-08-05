package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Register extends AppCompatActivity {
    private EditText reg_name, reg_email, reg_pass, id_alat, plat_nomor;
    private Button reg_but;

    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        reg_name= (EditText) findViewById(R.id.reg_name);
        reg_email= (EditText) findViewById(R.id.reg_email);
        reg_pass= (EditText) findViewById(R.id.reg_pass);
        id_alat= (EditText) findViewById(R.id.id_alat);
        plat_nomor= (EditText) findViewById(R.id.plat_nomor);
        reg_but= (Button) findViewById(R.id.register_button);

        reg_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerInfo();
            }
        });
    }

    private void registerInfo() {
        final String name = reg_name.getText().toString().trim();
        final String email = reg_email.getText().toString().trim();
        final String pass = reg_pass.getText().toString().trim();
        final String alat = id_alat.getText().toString().trim();
        final String plat = plat_nomor.getText().toString().trim();
        final String saldoInfo = "0";

        if(TextUtils.isEmpty(name)){
            reg_name.setError("Required");
            return;
        }

        if(TextUtils.isEmpty(email)){
            reg_email.setError("Required");
            return;
        }

        if(TextUtils.isEmpty(pass)){
            reg_pass.setError("Required");
            return;
        }

        if(TextUtils.isEmpty(alat)){
            id_alat.setError("Required");
            return;
        }

        if(TextUtils.isEmpty(plat)){
            plat_nomor.setError("Required");
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(Register.this, "Authentication failed." + task.getException(),
                            Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(Register.this, LoginActivity.class));
                    UserInformation userInformation = new UserInformation(name, pass, email, alat, plat, saldoInfo);

                    FirebaseUser user = mAuth.getCurrentUser();


                    databaseReference.child("Data User").child(user.getUid()).setValue(userInformation);
                    mAuth.signOut();
                    finish();

                }

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
