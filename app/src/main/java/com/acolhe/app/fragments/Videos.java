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

        String[] urlVideos = {"https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/videos%2F8%20Pr%C3%A1ticas%20para%20AUMENTAR%20sua%20AUTOESTIMA%20-%20Psic%C3%B3loga%20Fabiana%20Pavanelli.mp4?alt=media&token=05bdd896-695c-4830-8e54-1b86be2a6246&_gl=1*kqce01*_ga*MjA2ODk0NTM4My4xNjk3OTI0NTk2*_ga_CW55HF8NVT*MTY5ODY5NTUxMC40LjEuMTY5ODY5NjMxOC4xLjAuMA..", "https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/videos%2FATEN%C3%87%C3%83O%20PLENA%20-%20Exerc%C3%ADcio%20dos%205%20sentidos%20para%20redu%C3%A7%C3%A3o%20da%20ansiedade%20e%20aumento%20da%20aten%C3%A7%C3%A3o.mp4?alt=media&token=3232f513-0036-4df2-b6f6-7954c8766290&_gl=1*y3cc9x*_ga*MjA2ODk0NTM4My4xNjk3OTI0NTk2*_ga_CW55HF8NVT*MTY5ODY5NTUxMC40LjEuMTY5ODY5NjM0OC40Mi4wLjA.", "https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/videos%2FAten%C3%A7%C3%A3o%20Plena%20_%20Exerc%C3%ADcio%20do%20Aconchego%20_Auxilia%20reduzir%20a%20Ansiedade%20e%20prevenir%20a%20Depress%C3%A3o.mp4?alt=media&token=17c58180-f016-4459-a47b-edea73cc4e9c&_gl=1*xzw8us*_ga*MjA2ODk0NTM4My4xNjk3OTI0NTk2*_ga_CW55HF8NVT*MTY5ODY5NTUxMC40LjEuMTY5ODY5NjM2MC4zMC4wLjA."};
        String[] urlImagens = {"https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/imagens%2Fexemplothumbnail.webp?alt=media&token=9a087f4c-e6ed-4e7e-ab39-be39bbe131d9&_gl=1*196savu*_ga*MjA2ODk0NTM4My4xNjk3OTI0NTk2*_ga_CW55HF8NVT*MTY5ODY5NTUxMC40LjEuMTY5ODY5NzUzOC40NS4wLjA.", "https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/imagens%2Fexemplothumbnail.webp?alt=media&token=9a087f4c-e6ed-4e7e-ab39-be39bbe131d9&_gl=1*196savu*_ga*MjA2ODk0NTM4My4xNjk3OTI0NTk2*_ga_CW55HF8NVT*MTY5ODY5NTUxMC40LjEuMTY5ODY5NzUzOC40NS4wLjA.", "https://firebasestorage.googleapis.com/v0/b/acolhe-6a3dc.appspot.com/o/imagens%2Fexemplothumbnail.webp?alt=media&token=9a087f4c-e6ed-4e7e-ab39-be39bbe131d9&_gl=1*196savu*_ga*MjA2ODk0NTM4My4xNjk3OTI0NTk2*_ga_CW55HF8NVT*MTY5ODY5NTUxMC40LjEuMTY5ODY5NzUzOC40NS4wLjA."};

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