package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.adapters.HistoricoHumorAdapter;
import com.acolhe.app.model.Humor;
import com.acolhe.app.model.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;

public class HistoricoHumorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_humor);

        ImageView exit = findViewById(R.id.exit_button_msc);
        exit.setOnClickListener((view) -> finish());
        RecyclerView recyclerView = findViewById(R.id.listaHistorico_humor);

        System.out.println(UsuarioDTO.getHistoricoHumor() + "HISTORICO HUMOOOOOR");
        recyclerView.setAdapter(new HistoricoHumorAdapter(UsuarioDTO.getHistoricoHumor()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}