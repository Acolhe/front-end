package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.adapters.HistoricoHumorAdapter;
import com.acolhe.app.model.Humor;
import com.acolhe.app.model.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;

public class HistoricoHumorActivity extends AppCompatActivity {
    List<Humor> historico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_humor);
        RecyclerView recyclerView = findViewById(R.id.listaHistorico_humor);
        recyclerView.setAdapter(new HistoricoHumorAdapter(UsuarioDTO.getHistoricoHumor()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}