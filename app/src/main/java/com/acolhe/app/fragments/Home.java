package com.acolhe.app.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.MeditacaoHome;
import com.acolhe.app.adapters.ClinicaSliderAdapter;
import com.acolhe.app.adapters.PlaylistSliderAdapter;
import com.acolhe.app.model.Clinica;
import com.acolhe.app.model.Playlist;
import com.acolhe.app.model.Respiracao;
import com.github.islamkhsh.CardSliderViewPager;

import java.util.ArrayList;

public class Home extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        sliderRespiracao(view);
        sliderClinicas(view);
        return view;
    }

    private static void sliderClinicas(View view) {
        ArrayList<Clinica> clinicas = new ArrayList<>();
        clinicas.add(new Clinica("Nome clinica um",
                "email@email.com",
                "11 95871-7152",
                "Descricao",
                "imagem.com",
                "Bairro legal",
                "São Paulo",
                "São Paulo",
                "SP",
                true));
        clinicas.add(new Clinica("Nome clinica dois",
                "email@email.com",
                "11 95871-7152",
                "Descricao",
                "imagem.com",
                "Bairro legal",
                "São Paulo",
                "São Paulo",
                "SP",
                true));

        CardSliderViewPager cardSliderViewPager = (CardSliderViewPager) view.findViewById(R.id.home_viewPager);
        cardSliderViewPager.setAdapter(new ClinicaSliderAdapter(clinicas));
    }

    private void sliderRespiracao(View view) {
        ArrayList<Playlist> playlists = new ArrayList<Playlist>();
        ArrayList<Respiracao> respiracao = new ArrayList<Respiracao>();
        ArrayList<Respiracao> respiracao2 = new ArrayList<Respiracao>();
        Playlist playlist1 = new Playlist("Respire Fundo", "Exercícios de respiração", R.drawable.background_playlist_1, false, null);
        Playlist playlist2 = new Playlist("Sons da natureza", "Durma melhor com a natureza", R.drawable.background_playlist_3, false, null);
        respiracao.add(new Respiracao("Relaxamento", "Acalme sua mente e alivie o estresse", "Expiração prolongada (4 - 6)", 0));
        respiracao.add(new Respiracao("Aliviando o estresse", "Alivie o estresse", "Inspire pela esquerda (5 min)", 1));
        respiracao2.add(new Respiracao("Relaxar: Som do Mar","Relaxe ouvindo sons do mar", "Inspire profundamente", 2));
        respiracao2.add(new Respiracao("Titulo da respiracao","Descricao completa da respiracao", "Técnica descritiva da respiracao", 3));

        playlist1.setRespiracoes(respiracao);
        playlist2.setRespiracoes(respiracao2);
        playlists.add(playlist1);
        playlists.add(playlist2);

        CardSliderViewPager cardSliderViewPager = (CardSliderViewPager) view.findViewById(R.id.home_viewPager2);
        cardSliderViewPager.setAdapter(new PlaylistSliderAdapter(playlists));
    }
}