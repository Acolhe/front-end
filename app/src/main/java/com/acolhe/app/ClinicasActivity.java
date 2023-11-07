package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.adapters.ClinicaAdapter;
import com.acolhe.app.model.Clinica;
import com.acolhe.app.model.ClinicasDTO;

import java.util.ArrayList;
import java.util.List;

public class ClinicasActivity extends AppCompatActivity {

    private List<Clinica> clinicas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinicas);

        getClinicas();
        iniciarLista();
        fecharPagina();
    }

    private void getClinicas(){
        this.clinicas = ClinicasDTO.getClinicas();
    }

    private void iniciarLista(){
        ListView lista = findViewById(R.id.lstVwClinicas);
        ClinicaAdapter clinicaAdapter = new ClinicaAdapter(this, clinicas);
        lista.setAdapter(clinicaAdapter);

        lista.setOnItemClickListener((adapterView, view, posVetor, l) -> {
                LinearLayout bloco = view.findViewById(R.id.lnrLytInformacaoExtra);

                if (bloco.getVisibility() == View.VISIBLE){
                    bloco.setVisibility(View.GONE);
                }
                else{
                    bloco.setVisibility(View.VISIBLE);
                }
        });
    }

    private void fecharPagina(){
        LinearLayout voltar = findViewById(R.id.lnrLytVoltar);

        voltar.setOnClickListener(view -> finish());
    }

}