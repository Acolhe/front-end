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
        respiracao.add(new Respiracao("Relaxamento", "Acalme sua mente e alivie o estresse", "Expiração prolongada (4 - 6)", R.raw.atencao_plena));
        respiracao.add(new Respiracao("Aliviando o estresse", "Alivie o estresse", "Inspire pela esquerda (5 min)", 1));
        respiracao2.add(new Respiracao("Relaxar: Som do Mar","Relaxe ouvindo sons do mar", "Inspire profundamente", 2));
        respiracao2.add(new Respiracao("Titulo da respiracao","Descricao completa da respiracao", "Técnica descritiva da respiracao", 3));

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