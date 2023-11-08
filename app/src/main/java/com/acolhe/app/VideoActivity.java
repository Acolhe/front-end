package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.acolhe.acolhe_api.R;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        LinearLayout voltar = findViewById(R.id.lnrLytVoltar);
        voltar.setOnClickListener((view) -> finish());

        VideoView videoView = findViewById(R.id.vdVwVideo);


        Bundle enveloper = getIntent().getExtras();
        String link = enveloper.getString("url");
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(Uri.parse(link));
        videoView.start();
    }
}