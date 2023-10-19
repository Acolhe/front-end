package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
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

        ArrayList<Playlist> playlists = new ArrayList<Playlist>();
        ArrayList<Respiracao> respiracao = new ArrayList<Respiracao>();
        Playlist playlist1 = new Playlist("Title one", "Descricao", R.drawable.background_playlist_1, false, null);
        Playlist playlist2 = new Playlist("Titulo dois", "Descricao", R.drawable.background_playlist_2, false, null);
        respiracao.add(new Respiracao(playlist1.getTitulo(), "Descricao completa da respiracao", "Técnica descritiva da respiracao", 0));
        respiracao.add(new Respiracao(playlist2.getTitulo(), "Descricao completa da respiracao", "Técnica descritiva da respiracao", 1));

        playlists.add(playlist1);
        playlists.add(playlist2);

        playlist1.setRespiracoes(respiracao);
        playlist2.setRespiracoes(respiracao);

        CardSliderViewPager cardSliderViewPager = (CardSliderViewPager) findViewById(R.id.viewPager);
        cardSliderViewPager.setAdapter(new PlaylistSliderAdapter(playlists));
    }

    public void sair(View view) {
        finish();
    }
}