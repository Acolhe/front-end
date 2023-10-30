package com.acolhe.app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.ClinicasActivity;
import com.acolhe.app.MeditacaoHome;
import com.acolhe.app.adapters.ClinicaSliderAdapter;
import com.acolhe.app.adapters.PlaylistSliderAdapter;
import com.acolhe.app.config.ConfigFirebase;
import com.acolhe.app.model.Clinica;
import com.acolhe.app.model.Frase;
import com.acolhe.app.model.Humor;
import com.acolhe.app.model.Playlist;
import com.acolhe.app.model.Respiracao;
import com.acolhe.app.model.Satisfacao;
import com.acolhe.app.model.Usuario;
import com.github.islamkhsh.CardSliderViewPager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class Home extends Fragment {

    private DatabaseReference db;
    private Frase frase;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.db = ConfigFirebase.getFirebaseDatabase().child("frases");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView fraseDoDia = view.findViewById(R.id.frase_diaria);
        TextView mesHumor = view.findViewById(R.id.mesHumor_home);
        TextView diaHumor = view.findViewById(R.id.diaHumor_home);
        TextView humor = view.findViewById(R.id.humorDiario_home);
        ImageView carinhaHumor = view.findViewById(R.id.carinhaHumor_home);

        Usuario.getHistoricoHumor().add(new Humor(LocalDate.of(Year.now().getValue(), Month.JULY.getValue(), MonthDay.now().getDayOfMonth()), Satisfacao.BEM));
        Usuario.getHistoricoHumor().add(new Humor(LocalDate.now(), Satisfacao.BEM));

        setFraseDoDia(fraseDoDia);

        int max = Usuario.getHistoricoHumor().size();
        Humor ultimoHumor = Usuario.getHistoricoHumor().get(max - 1);
        mesHumor.setText(ultimoHumor.getDataAvaliacao().getMonth().toString().substring(0, 3));
        diaHumor.setText(ultimoHumor.getDataAvaliacao().getDayOfMonth() + "");
        humor.setText(ultimoHumor.getNivelSatisfacao().toString());
        setCarinha(carinhaHumor, ultimoHumor);

        sliderRespiracao(view);
        sliderClinicas(view);

        setOnClickListeners(view);
        return view;
    }

    private void setOnClickListeners(View rootView) {
        TextView verTudoClinicasTxtVw = rootView.findViewById(R.id.txtVwVerTudo_clinicas), verTudoMedTxtVw = rootView.findViewById(R.id.txtVwVerTudo_meditacao);
        ImageView verTudoClinicasImgVw = rootView.findViewById(R.id.imageVerTudo_clinicas), verTudoMedImgVw = rootView.findViewById(R.id.imageViewVerTudo_meditacao);
        verTudoMedImgVw.setOnClickListener(view -> startActivity(new Intent(getContext(), MeditacaoHome.class)));
        verTudoMedTxtVw.setOnClickListener((view) -> startActivity(new Intent(getContext(), MeditacaoHome.class)));
        verTudoClinicasImgVw.setOnClickListener((view) -> startActivity(new Intent(getContext(), ClinicasActivity.class)));
        verTudoClinicasTxtVw.setOnClickListener((view) -> startActivity(new Intent(getContext(), ClinicasActivity.class)));

    }

    private void setCarinha(ImageView carinhaHumor, Humor humor) {
        switch (humor.getNivelSatisfacao()) {
            case MUITO_TRISTE:
                carinhaHumor.setImageResource(R.drawable.nadabem);
                break;
            case TRISTE:
                carinhaHumor.setImageResource(R.drawable.triste);
                break;
            case NORMAL:
                carinhaHumor.setImageResource(R.drawable.normal);
                break;
            case BEM:
                carinhaHumor.setImageResource(R.drawable.bem);
                break;
            case MUITO_BEM:
                carinhaHumor.setImageResource(R.drawable.muitobem);
                break;

        }
    }

    private void setFraseDoDia(TextView fraseDoDia) {
        Query fraseQuery = db.limitToFirst(1);
        fraseQuery.get().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Log.d("firebase", "Error getting data", task.getException());
            } else {
                for (DataSnapshot snp : task.getResult().getChildren()) {
                    this.frase = snp.getValue(Frase.class);
                }
                fraseDoDia.setText(this.frase.getFrase());
            }
        });
    }

    private void pushFrase(String frase) {
        this.db.push().setValue(new Frase(frase, LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))));
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
        respiracao.add(new Respiracao("Relaxamento", "Acalme sua mente e alivie o estresse", "Expiração prolongada (4 - 6)", R.raw.atencao_plena));
        respiracao.add(new Respiracao("Aliviando o estresse", "Alivie o estresse", "Inspire pela esquerda (5 min)", 1));
        respiracao2.add(new Respiracao("Relaxar: Som do Mar", "Relaxe ouvindo sons do mar", "Inspire profundamente", 2));
        respiracao2.add(new Respiracao("Titulo da respiracao", "Descricao completa da respiracao", "Técnica descritiva da respiracao", 3));

        playlist1.setRespiracoes(respiracao);
        playlist2.setRespiracoes(respiracao2);
        playlists.add(playlist1);
        playlists.add(playlist2);

        CardSliderViewPager cardSliderViewPager = (CardSliderViewPager) view.findViewById(R.id.home_viewPager2);
        cardSliderViewPager.setAdapter(new PlaylistSliderAdapter(playlists));
    }
}