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
        Playlist playlist1 = new Playlist("Title one", "Descricao", R.drawable.background_playlist_1, false, null);
        Playlist playlist2 = new Playlist("Titulo dois", "Descricao", R.drawable.background_playlist_2, true, null);
        Playlist playlist3 = new Playlist("Title one", "Descricao", R.drawable.background_playlist_3, false, null);
        Playlist playlist4 = new Playlist("Titulo dois", "Descricao", R.drawable.background_playlist_4, true, null);
        respiracao.add(new Respiracao(playlist1.getTitulo(), "Descricao completa da respiracao", "Técnica descritiva da respiracao", 0));
        respiracao.add(new Respiracao(playlist2.getTitulo(), "Descricao completa da respiracao", "Técnica descritiva da respiracao", 1));
        respiracao2.add(new Respiracao(playlist3.getTitulo(), "Descricao completa da respiracao", "Técnica descritiva da respiracao", 2));
        respiracao2.add(new Respiracao(playlist4.getTitulo(), "Descricao completa da respiracao", "Técnica descritiva da respiracao", 3));

        playlist1.setRespiracoes(respiracao);
        playlist2.setRespiracoes(respiracao);
        playlist3.setRespiracoes(respiracao2);
        playlist4.setRespiracoes(respiracao2);

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