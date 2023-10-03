package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;


import com.acolhe.acolhe_api.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference();

        myRef.child("teste").setValue("Hello World");
    }


    public void abrirLogin(View view){

    }

    public void abrirCadastro(){

    }
}