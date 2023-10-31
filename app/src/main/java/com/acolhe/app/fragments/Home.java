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
        respiracao.add(new Respiracao("Atenção plena", "Melhore sua atenção e relaxe", "Expiração prolongada (4 - 6)", "https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/audios%2FAten%C3%A7%C3%A3o%20Plena%20e%20Relaxamento%20para%20Adolescentes%20%20Exerc%C3%ADcio%20do%20lago%20Podcast%20Fabiana%20Pavanelli.mp3?alt=media&token=7f07e541-808d-42c9-bc0f-b99d193283ca&_gl=1*xvtkpn*_ga*NjA4MzE0NDM3LjE2OTg2ODQ3MTg.*_ga_CW55HF8NVT*MTY5ODc3NjczMS40LjEuMTY5ODc3Njg1OS40Mi4wLjA."));
        respiracao.add(new Respiracao("Reduzir a ansiedade", "Relaxamento para ansiedade", "Respire profundamente", "https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/audios%2FRelaxamento%20para%20reduzir%20a%20Ansiedade%20em%20locais%20p%C3%BAblicos%20_Psic%C3%B3loga%20Fabiana%20Pavanelli.mp3?alt=media&token=4f470cd1-c530-42f2-a402-5572d24e1fc6&_gl=1*bg0hdi*_ga*NjA4MzE0NDM3LjE2OTg2ODQ3MTg.*_ga_CW55HF8NVT*MTY5ODc3NjczMS40LjEuMTY5ODc3NjkwNi42MC4wLjA."));
        respiracao2.add(new Respiracao("Relaxar: Chuva com trovão","Relaxe ouvindo a chuva", "", "https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/audios%2F10%20minutos%20de%20%20chuva%20com%20trov%C3%A3o.mp3?alt=media&token=5895310e-9c11-4023-ba59-2e78b90409cb&_gl=1*1qnnp92*_ga*NjA4MzE0NDM3LjE2OTg2ODQ3MTg.*_ga_CW55HF8NVT*MTY5ODc3NjczMS40LjEuMTY5ODc3NzEzMC4zNy4wLjA."));
        respiracao2.add(new Respiracao("Relaxar: Sons da natureza","Relaxe ouvindo a natureza", "", "https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/audios%2FNatureza%20em%20HD%2010%20min%20-%20Sons%20da%20mata%2C%20rio%20e%20p%C3%A1ssaros%20-%20meditar%2C%20relaxar%2C%20dormir.mp3?alt=media&token=39791fcb-f764-46be-bf4a-1fb9a30fff2a&_gl=1*10v9f2q*_ga*NjA4MzE0NDM3LjE2OTg2ODQ3MTg.*_ga_CW55HF8NVT*MTY5ODc3NjczMS40LjEuMTY5ODc3NzE3Mi41Ni4wLjA."));

        playlist1.setRespiracoes(respiracao);
        playlist2.setRespiracoes(respiracao2);
        playlists.add(playlist1);
        playlists.add(playlist2);

        CardSliderViewPager cardSliderViewPager = (CardSliderViewPager) view.findViewById(R.id.home_viewPager2);
        cardSliderViewPager.setAdapter(new PlaylistSliderAdapter(playlists));
    }
}