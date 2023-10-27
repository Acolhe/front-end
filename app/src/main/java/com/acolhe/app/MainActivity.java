package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;

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
import com.github.islamkhsh.CardSliderViewPager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getBundles();
        adicionarEventosClickCabecalho();
        adicionaEventosCLickRodape();
    }

    private void getBundles() {
        Bundle enveloper = getIntent().getExtras();
        Integer saldo = enveloper.getInt("saldo");
        Integer ofensiva = enveloper.getInt("diasConsecutivos");
        String stringSaldo = String.valueOf(saldo);
        String stirngofensiva = String.valueOf(ofensiva);

        System.out.println(saldo);
        System.out.println(ofensiva);

        TextView ofensivaLayout = findViewById(R.id.valorOfensiva);
        ofensivaLayout.setText(stirngofensiva);

        TextView saldoLayout = findViewById(R.id.valorSaldo);
        saldoLayout.setText(stringSaldo);
    }

    private void adicionarEventosClickCabecalho() {
        LinearLayout btnPerfil = findViewById(R.id.lnrLytVoltar);
        LinearLayout btnOfensiva = findViewById(R.id.lnrLytOfensiva);
        LinearLayout btnMedalha = findViewById(R.id.lnrLytMedalha);
        LinearLayout btnAcolhePlus = findViewById(R.id.lnrLytAcolhePlus);
        ImageView imageAcolhePlus = findViewById(R.id.imgVwAcolhePlus);

        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PaginaProfileActivity.class);
                startActivity(intent);
            }
        });

        btnOfensiva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFragmento(Home.class);
            }
        });

        btnMedalha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFragmento(Store.class);
            }
        });

        btnAcolhePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PaginaAcolhePlus.class));
            }
        });
        imageAcolhePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PaginaAcolhePlus.class));
            }
        });
    }
    private void updatePageName(String pageName) {
        TextView textView = findViewById(R.id.txtVwNomePagina);
        textView.setText(pageName);
    }


    private void adicionaEventosCLickRodape() {
        LinearLayout btnHome = findViewById(R.id.lnrLytHome);
        LinearLayout btnVideos = findViewById(R.id.lnrLytConteudo);
        LinearLayout btnCvv = findViewById(R.id.lnrLytCvv);
        LinearLayout btnMissoes = findViewById(R.id.lnrLytMissao);
        LinearLayout btnStore = findViewById(R.id.lnrLytLoja);

        btnVideos.setOnClickListener(view -> {
                abreFragmento(Videos.class);
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
                updatePageName(getString(R.string.page_name_videos));
            });

        btnCvv.setOnClickListener(view ->{
                abreFragmento(Cvv.class);
                updatePageName(getString(R.string.page_name_cvv));
        });

        btnMissoes.setOnClickListener(view -> {
                abreFragmento(Missoes.class);
                updatePageName(getString(R.string.page_name_missoes));
        });

        btnStore.setOnClickListener(view -> {
                abreFragmento(Store.class);
                updatePageName(getString(R.string.page_name_store));
        });

        btnHome.setOnClickListener(view -> {
                abreFragmento(Home.class);
                updatePageName(getString(R.string.page_name_home));
        });
    }


    private void abreFragmento(Class target){
        if (target == Home.class) {
            findViewById(R.id.header).setVisibility(View.GONE);
        }else {
            findViewById(R.id.header).setVisibility(View.VISIBLE);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment, target, null).setReorderingAllowed(true).addToBackStack("name").commit();
    }
}