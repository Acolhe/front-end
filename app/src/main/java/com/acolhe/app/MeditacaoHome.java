package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.adapters.PlaylistSliderAdapter;
import com.acolhe.app.model.Playlist;
import com.acolhe.app.model.Respiracao;
import com.github.islamkhsh.CardSliderViewPager;

import java.util.ArrayList;

public class MeditacaoHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditacao_home);

        setOnClickListeners();
        sliderInitializer();
    }

    private void setOnClickListeners() {
        LinearLayout clickableLayout1 = findViewById(R.id.verTodasLock);
        LinearLayout clickableLayout2 = findViewById(R.id.verTodasLock2);
        Button clickableLayout3 = findViewById(R.id.desbloquearAcolhe);
        LinearLayout clickableLayout4 = findViewById(R.id.bigLockClick);

        clickableLayout1.setOnClickListener(view -> startActivity(new Intent(this, PaginaAcolhePlus.class)));
        clickableLayout2.setOnClickListener(view -> startActivity(new Intent(this, PaginaAcolhePlus.class)));
        clickableLayout3.setOnClickListener(view -> startActivity(new Intent(this, PaginaAcolhePlus.class)));
        clickableLayout4.setOnClickListener(view -> startActivity(new Intent(this, PaginaAcolhePlus.class)));
    }

    private void sliderInitializer() {
        ArrayList<Playlist> playlists = new ArrayList<Playlist>();
        ArrayList<Playlist> playlists2 = new ArrayList<Playlist>();
        ArrayList<Respiracao> respiracao = new ArrayList<Respiracao>();
        ArrayList<Respiracao> respiracao2 = new ArrayList<Respiracao>();
        Playlist playlist1 = new Playlist("Respire Fundo", "Exercícios de respiração", R.drawable.background_playlist_1, false, null);
        Playlist playlist2 = new Playlist("Acalmando a  ansiedade", "Exercícios de respiração", R.drawable.background_playlist_2, true, null);
        Playlist playlist3 = new Playlist("Sons da natureza", "Durma melhor com a natureza", R.drawable.background_playlist_3, false, null);
        Playlist playlist4 = new Playlist("Sons de chuva", "Durma melhor com sons de chuva", R.drawable.background_playlist_4, true, null);
        respiracao.add(new Respiracao("Atenção plena", "Melhore sua atenção e relaxe", "Expiração prolongada (4 - 6)", "https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/audios%2FAten%C3%A7%C3%A3o%20Plena%20e%20Relaxamento%20para%20Adolescentes%20%20Exerc%C3%ADcio%20do%20lago%20Podcast%20Fabiana%20Pavanelli.mp3?alt=media&token=7f07e541-808d-42c9-bc0f-b99d193283ca&_gl=1*xvtkpn*_ga*NjA4MzE0NDM3LjE2OTg2ODQ3MTg.*_ga_CW55HF8NVT*MTY5ODc3NjczMS40LjEuMTY5ODc3Njg1OS40Mi4wLjA."));
        respiracao.add(new Respiracao("Reduzir a ansiedade", "Relaxamento para ansiedade", "Respire profundamente", "https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/audios%2FRelaxamento%20para%20reduzir%20a%20Ansiedade%20em%20locais%20p%C3%BAblicos%20_Psic%C3%B3loga%20Fabiana%20Pavanelli.mp3?alt=media&token=4f470cd1-c530-42f2-a402-5572d24e1fc6&_gl=1*bg0hdi*_ga*NjA4MzE0NDM3LjE2OTg2ODQ3MTg.*_ga_CW55HF8NVT*MTY5ODc3NjczMS40LjEuMTY5ODc3NjkwNi42MC4wLjA."));
        respiracao2.add(new Respiracao("Relaxar: Chuva com trovão","Relaxe ouvindo a chuva", "", "https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/audios%2F10%20minutos%20de%20%20chuva%20com%20trov%C3%A3o.mp3?alt=media&token=5895310e-9c11-4023-ba59-2e78b90409cb&_gl=1*1qnnp92*_ga*NjA4MzE0NDM3LjE2OTg2ODQ3MTg.*_ga_CW55HF8NVT*MTY5ODc3NjczMS40LjEuMTY5ODc3NzEzMC4zNy4wLjA."));
        respiracao2.add(new Respiracao("Relaxar: Sons da natureza","Relaxe ouvindo a natureza", "", "https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/audios%2FNatureza%20em%20HD%2010%20min%20-%20Sons%20da%20mata%2C%20rio%20e%20p%C3%A1ssaros%20-%20meditar%2C%20relaxar%2C%20dormir.mp3?alt=media&token=39791fcb-f764-46be-bf4a-1fb9a30fff2a&_gl=1*10v9f2q*_ga*NjA4MzE0NDM3LjE2OTg2ODQ3MTg.*_ga_CW55HF8NVT*MTY5ODc3NjczMS40LjEuMTY5ODc3NzE3Mi41Ni4wLjA."));

        playlist1.setRespiracoes(respiracao);
        playlist3.setRespiracoes(respiracao2);
        playlists.add(playlist1);
        playlists.add(playlist2);
        playlists2.add(playlist3);
        playlists2.add(playlist4);

        CardSliderViewPager cardSliderViewPager = (CardSliderViewPager) findViewById(R.id.viewPager);
        cardSliderViewPager.setAdapter(new PlaylistSliderAdapter(playlists));

        CardSliderViewPager cardSliderViewPager2 = (CardSliderViewPager) findViewById(R.id.viewPager2);
        cardSliderViewPager2.setAdapter(new PlaylistSliderAdapter(playlists2));
    }

    public void sair(View view) {
        finish();
    }
}