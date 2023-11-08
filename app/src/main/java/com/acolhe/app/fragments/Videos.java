package com.acolhe.app.fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.VideoActivity;
import com.acolhe.app.adapters.VideoAdapter;
import com.bumptech.glide.Glide;

public class Videos extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_videos, container, false);

        String[] urlVideos = {"https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/videos%2F8%20Pr%C3%A1ticas%20para%20AUMENTAR%20sua%20AUTOESTIMA%20-%20Psic%C3%B3loga%20Fabiana%20Pavanelli.mp4?alt=media&token=05bdd896-695c-4830-8e54-1b86be2a6246&_gl=1*1c10uq*_ga*MTQzNzQ2OTk3OS4xNjk2Mjc5MzI5*_ga_CW55HF8NVT*MTY5OTMxMTY0Mi4xMy4xLjE2OTkzMTIyNjIuNjAuMC4w", "https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/videos%2FATEN%C3%87%C3%83O%20PLENA%20-%20Exerc%C3%ADcio%20dos%205%20sentidos%20para%20redu%C3%A7%C3%A3o%20da%20ansiedade%20e%20aumento%20da%20aten%C3%A7%C3%A3o.mp4?alt=media&token=3232f513-0036-4df2-b6f6-7954c8766290&_gl=1*jstfzq*_ga*MTQzNzQ2OTk3OS4xNjk2Mjc5MzI5*_ga_CW55HF8NVT*MTY5OTMxMTY0Mi4xMy4xLjE2OTkzMTIyODQuMzguMC4w", "https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/videos%2FAten%C3%A7%C3%A3o%20Plena%20_%20Exerc%C3%ADcio%20do%20Aconchego%20_Auxilia%20reduzir%20a%20Ansiedade%20e%20prevenir%20a%20Depress%C3%A3o.mp4?alt=media&token=17c58180-f016-4459-a47b-edea73cc4e9c&_gl=1*1bnkd5c*_ga*MTQzNzQ2OTk3OS4xNjk2Mjc5MzI5*_ga_CW55HF8NVT*MTY5OTMxMTY0Mi4xMy4xLjE2OTkzMTIyOTcuMjUuMC4w"};
        String[] urlImagens = {"https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/imagens%2F8%20Pr%C3%A1ticas%20para%20AUMENTAR%20sua%20AUTOESTIMA%20-%20Psic%C3%B3loga%20Fabiana%20Pavanelli.png?alt=media&token=5c850c04-8c3f-459f-9074-83e6cec3f5cb&_gl=1*dtnmgo*_ga*MTQzNzQ2OTk3OS4xNjk2Mjc5MzI5*_ga_CW55HF8NVT*MTY5OTMxMTY0Mi4xMy4xLjE2OTkzMTIzMTUuNy4wLjA.", "https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/imagens%2FATEN%C3%87%C3%83O%20PLENA%20-%20Exerc%C3%ADcio%20dos%205%20sentidos%20para%20redu%C3%A7%C3%A3o%20da%20ansiedade%20e%20aumento%20da%20aten%C3%A7%C3%A3o.png?alt=media&token=04231e01-91de-4ec9-acdc-14577bc4dafb&_gl=1*1q529z1*_ga*MTQzNzQ2OTk3OS4xNjk2Mjc5MzI5*_ga_CW55HF8NVT*MTY5OTMxMTY0Mi4xMy4xLjE2OTkzMTIzMzAuNjAuMC4w", "https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/imagens%2FAten%C3%A7%C3%A3o%20Plena%20_%20Exerc%C3%ADcio%20do%20Aconchego%20_Auxilia%20reduzir%20a%20Ansiedade%20e%20prevenir%20a%20Depress%C3%A3o.png?alt=media&token=2dbc54a4-c49c-49d1-8bcd-bc160d06107f&_gl=1*xy5a35*_ga*MTQzNzQ2OTk3OS4xNjk2Mjc5MzI5*_ga_CW55HF8NVT*MTY5OTMxMTY0Mi4xMy4xLjE2OTkzMTIzNDYuNDQuMC4w"};

        ListView lista = view.findViewById(R.id.lstVwVideos);
        VideoAdapter videoAdapter = new VideoAdapter(getContext(), urlVideos, urlImagens);
        lista.setAdapter(videoAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posVetor, long l){
                Bundle bundleVideos = new Bundle();
                bundleVideos.putString("url", urlVideos[posVetor]);

                Intent intentVideo = new Intent(getContext(), VideoActivity.class);
                intentVideo.putExtras(bundleVideos);
                startActivity(intentVideo);
            }
        });

        return view;
    }


}