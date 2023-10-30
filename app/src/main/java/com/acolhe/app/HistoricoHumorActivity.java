package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.adapters.HistoricoHumorAdapter;
import com.acolhe.app.model.Humor;

import java.util.ArrayList;
import java.util.List;

public class HistoricoHumorActivity extends AppCompatActivity {
    List<Humor> historico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_humor);
        getBundles();
        RecyclerView recyclerView = findViewById(R.id.listaHistorico_humor);
        recyclerView.setAdapter(new HistoricoHumorAdapter(historico));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getBundles() {
        Bundle extras = getIntent().getExtras();
        historico = (ArrayList<Humor>) extras.getSerializable("historico");
    }
}