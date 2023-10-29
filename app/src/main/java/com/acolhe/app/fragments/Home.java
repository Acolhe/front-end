package com.acolhe.app.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.ClinicasActivity;
import com.acolhe.app.HistoricoHumorActivity;
import com.acolhe.app.MeditacaoHome;
import com.acolhe.app.adapters.ClinicaSliderAdapter;
import com.acolhe.app.adapters.PlaylistSliderAdapter;
import com.acolhe.app.model.Clinica;
import com.acolhe.app.model.Humor;
import com.acolhe.app.model.Playlist;
import com.acolhe.app.model.Respiracao;
import com.acolhe.app.model.Satisfacao;
import com.acolhe.app.model.Usuario;
import com.acolhe.app.utils.HumorComparator;
import com.github.islamkhsh.CardSliderViewPager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Home extends Fragment {

    private Intent intent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        intent = new Intent(getContext(), HistoricoHumorActivity.class);
        Usuario user = setMock();

        fraseDoDia.setText(getFraseDoDia());
        user.setHistoricoHumor(user.getHistoricoHumor().stream().sorted(new HumorComparator()).collect(Collectors.toList()));
        Humor ultimoHumor = user.getHistoricoHumor().get(0);
        mesHumor.setText(ultimoHumor.getDataAvaliacao().getMonth().toString().substring(0, 3));
        diaHumor.setText(ultimoHumor.getDataAvaliacao().getDayOfMonth() + "");
        humor.setText(ultimoHumor.getNivelSatisfacao().toString());
        carinhaHumor.setImageResource(ultimoHumor.getRes());

        sliderRespiracao(view);
        sliderClinicas(view);

        setOnClickListeners(view, user);
        return view;
    }

    @NonNull
    private static Usuario setMock() {
        Usuario user = new Usuario("Rafael",
                40,
                2,
                "rafael.ferraz@picpay.com",
                1,
                LocalDateTime.now(),
                LocalDate.now(),
                true,
                new ArrayList<Humor>());

        user.getHistoricoHumor().add(new Humor(LocalDate.of(Year.now().getValue(), Month.JANUARY.getValue(), MonthDay.now().getDayOfMonth()), Satisfacao.TRISTE));
        user.getHistoricoHumor().add(new Humor(LocalDate.of(Year.now().getValue(), Month.FEBRUARY.getValue(), 25), Satisfacao.BEM));
        user.getHistoricoHumor().add(new Humor(LocalDate.of(Year.now().getValue(), Month.MARCH.getValue(), MonthDay.now().getDayOfMonth()), Satisfacao.NORMAL));
        user.getHistoricoHumor().add(new Humor(LocalDate.of(Year.now().getValue(), Month.APRIL.getValue(), MonthDay.now().getDayOfMonth()), Satisfacao.MUITO_BEM));
        user.getHistoricoHumor().add(new Humor(LocalDate.of(Year.now().getValue(), Month.MAY.getValue(), MonthDay.now().getDayOfMonth()), Satisfacao.MUITO_TRISTE));
        user.getHistoricoHumor().add(new Humor(LocalDate.of(Year.now().getValue(), Month.JUNE.getValue(), MonthDay.now().getDayOfMonth()), Satisfacao.NORMAL));
        user.getHistoricoHumor().add(new Humor(LocalDate.of(Year.now().getValue(), Month.JULY.getValue(), MonthDay.now().getDayOfMonth()), Satisfacao.TRISTE));
        user.getHistoricoHumor().add(new Humor(LocalDate.of(Year.now().getValue(), Month.AUGUST.getValue(), MonthDay.now().getDayOfMonth()), Satisfacao.NORMAL));
        user.getHistoricoHumor().add(new Humor(LocalDate.of(Year.now().getValue(), Month.SEPTEMBER.getValue(), MonthDay.now().getDayOfMonth()), Satisfacao.BEM));
        user.getHistoricoHumor().add(new Humor(LocalDate.now(), Satisfacao.MUITO_TRISTE));
        return user;
    }

    private void setOnClickListeners(View rootView, Usuario user) {
        TextView verTudoClinicasTxtVw = rootView.findViewById(R.id.txtVwVerTudo_clinicas),
                verTudoMedTxtVw = rootView.findViewById(R.id.txtVwVerTudo_meditacao),
                verTudoHumorTxtVw = rootView.findViewById(R.id.txtVwVerTudoHumor_home);
        ImageView verTudoClinicasImgVw = rootView.findViewById(R.id.imageVerTudo_clinicas),
                verTudoMedImgVw = rootView.findViewById(R.id.imageViewVerTudo_meditacao),
                verTudoHumorImgVw = rootView.findViewById(R.id.imgVwVerTudoHumor_home);
        LinearLayout verTudoHistoricoHumor = rootView.findViewById(R.id.historicoHumor_home);
        verTudoMedImgVw.setOnClickListener(view -> startActivity(new Intent(getContext(), MeditacaoHome.class)));
        verTudoMedTxtVw.setOnClickListener((view) -> startActivity(new Intent(getContext(), MeditacaoHome.class)));
        verTudoClinicasImgVw.setOnClickListener((view) -> startActivity(new Intent(getContext(), ClinicasActivity.class)));
        verTudoClinicasTxtVw.setOnClickListener((view) -> startActivity(new Intent(getContext(), ClinicasActivity.class)));
        verTudoHistoricoHumor.setOnClickListener((view) -> {
            intent.putExtra("historico", (ArrayList<Humor>) user.getHistoricoHumor());
            startActivity(intent);
        });
        verTudoHumorImgVw.setOnClickListener((view) -> {
            intent.putExtra("historico", (ArrayList<Humor>) user.getHistoricoHumor());
            startActivity(intent);
        });
        verTudoHumorTxtVw.setOnClickListener((view) -> {
            intent.putExtra("historico", (ArrayList<Humor>) user.getHistoricoHumor());
            startActivity(intent);
        });

    }

    private String getFraseDoDia(){
        return "Frase bonita do dia de hoje, bem legal";
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