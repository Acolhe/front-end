package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.fragments.Cvv;
import com.acolhe.app.fragments.Home;
import com.acolhe.app.fragments.Missoes;
import com.acolhe.app.fragments.Perfil;
import com.acolhe.app.fragments.Store;
import com.acolhe.app.fragments.Videos;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        adicionarEventosClickCabecalho();
        adicionaEventosCLickRodape();
    }

    private void adicionarEventosClickCabecalho() {
        LinearLayout btnPerfil = findViewById(R.id.lnrLytVoltar);
        LinearLayout btnOfensiva = findViewById(R.id.lnrLytOfensiva);
        LinearLayout btnMedalha = findViewById(R.id.lnrLytMedalha);
        LinearLayout btnAcolhePlus = findViewById(R.id.lnrLytAcolhePlus);

        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFragmento(Perfil.class);
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
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    private void adicionaEventosCLickRodape() {
        LinearLayout btnHome = findViewById(R.id.lnrLytHome);
        LinearLayout btnVideos = findViewById(R.id.lnrLytConteudo);
        LinearLayout btnCvv = findViewById(R.id.lnrLytCvv);
        LinearLayout btnMissoes = findViewById(R.id.lnrLytMissao);
        LinearLayout btnStore = findViewById(R.id.lnrLytLoja);

        btnVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFragmento(Videos.class);
            }
        });

        btnCvv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFragmento(Cvv.class);
            }
        });

        btnMissoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFragmento(Missoes.class);
            }
        });

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFragmento(Store.class);
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFragmento(Home.class);
            }
        });
    }

    private void abreFragmento(Class target){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment, target, null).setReorderingAllowed(true).addToBackStack("name").commit();
    }
}