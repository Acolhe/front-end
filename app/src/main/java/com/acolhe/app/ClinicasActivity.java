package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.adapters.ClinicaAdapter;

public class ClinicasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinicas);

        iniciarLista();
        fecharPagina();
    }

    private void iniciarLista(){
        ListView lista = findViewById(R.id.lstVwClinicas);
        ClinicaAdapter clinicaAdapter = new ClinicaAdapter(this);
        lista.setAdapter(clinicaAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posVetor, long l){
                LinearLayout bloco = view.findViewById(R.id.lnrLytInformacaoExtra);

                if (bloco.getVisibility() == View.VISIBLE){
                    bloco.setVisibility(View.GONE);
                }
                else{
                    bloco.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void fecharPagina(){
        LinearLayout voltar = findViewById(R.id.lnrLytVoltar);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}