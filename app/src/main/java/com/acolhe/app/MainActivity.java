package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.Retrofit.Methods;
import com.acolhe.app.Retrofit.Model;
import com.acolhe.app.Retrofit.RetrofitClient;
import com.acolhe.app.fragments.Cvv;
import com.acolhe.app.fragments.Home;
import com.acolhe.app.fragments.Missoes;
import com.acolhe.app.fragments.Perfil;
import com.acolhe.app.fragments.Store;
import com.acolhe.app.fragments.Videos;
import com.google.android.gms.common.util.JsonUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView btnHome = findViewById(R.id.btnHome);
        ImageView btnVideos = findViewById(R.id.btnVideos);
        ImageView btnCvv = findViewById(R.id.btnCvv);
        ImageView btnMissoes = findViewById(R.id.btnMissoes);
        ImageView btnStore = findViewById(R.id.btnStore);

        btnVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
                Call<Model> call = methods.getAllData();
                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        Log.e(TAG, "onResponse: code: " + response.code());

                        String data = response.body().getMessage();

                        Log.e(TAG, "onResponse: emails: " + data);


                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Log.e(TAG, "onFailure: code: " + t.getMessage());
                    }
                });
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, Videos.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
            }
        });


        btnCvv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, Cvv.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
            }
        });

        btnMissoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, Missoes.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
            }
        });

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, Store.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
            }
        });



        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, Home.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
            }
        });

    }


    public void irParaPerfil(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment, Perfil.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
    }

    public void irParaVoce(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment, Home.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
    }

    public void irParaLoja(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment, Store.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
    }
}