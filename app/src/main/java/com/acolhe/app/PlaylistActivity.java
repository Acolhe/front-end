package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.adapters.PlaylistSliderAdapter;
import com.acolhe.app.adapters.RespiracaoSliderAdapter;
import com.acolhe.app.model.Respiracao;
import com.github.islamkhsh.CardSliderViewPager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlaylistActivity extends AppCompatActivity {

    private CardSliderViewPager cardSliderViewPager;
    private Button comecar;
    private List<Respiracao> respiracao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        FloatingActionButton closeFab = findViewById(R.id.closeButton);
        closeFab.setOnClickListener(view -> finish());
        comecar = findViewById(R.id.startButton);
        setupSliderAndBundle();
    }

    private void setupSliderAndBundle() {
        Bundle extras = getIntent().getExtras();
        TextView title = findViewById(R.id.tituloResp);
        if (extras != null) {
            this.respiracao = (List<Respiracao>) extras.getSerializable("respiracao");
            title.setText(extras.getString("titulo"));
            CardSliderViewPager cardSliderViewPager = (CardSliderViewPager) findViewById(R.id.viewPager2);
            cardSliderViewPager.setAdapter(new RespiracaoSliderAdapter(respiracao));
            comecar.setOnClickListener(view -> {
                Respiracao resp = respiracao.get(cardSliderViewPager.getCurrentItem());
                Intent intent = new Intent(PlaylistActivity.this, MeditacaoMusicaActivity.class);
                intent.putExtra("respiracao", (Serializable) resp);
                startActivity(intent);
            });
        }
    }
}