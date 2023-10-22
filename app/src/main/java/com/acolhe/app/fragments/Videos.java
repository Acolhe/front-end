package com.acolhe.app.fragments;

import android.content.Intent;
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


        String[] urlVideos = {"https://t.ly/4gPUg", "https://t.ly/4gPUg"};
        int[] capasVideos = {R.drawable.camisetaacolhe, R.drawable.camisetaacolhe};

        ListView lista = view.findViewById(R.id.lstVwVideos);
        VideoAdapter videoAdapter = new VideoAdapter(getContext(), urlVideos, capasVideos);
        lista.setAdapter(videoAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posVetor, long l){
                Bundle bundleVideos = new Bundle();
                bundleVideos.putString("url", urlVideos[posVetor]);
                bundleVideos.putInt("imagem", capasVideos[posVetor]);

                Intent intentVideo = new Intent(getContext(), VideoActivity.class);
                intentVideo.putExtras(bundleVideos);
                startActivity(intentVideo);
            }
        });

        return view;
    }


}