package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.acolhe.acolhe_api.R;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView videoView = findViewById(R.id.vdVwVideo);


        Bundle enveloper = getIntent().getExtras();
        String link = enveloper.getString("url");

        videoView.setMediaController(new MediaController(getApplicationContext()));
        videoView.setVideoPath("link");
        videoView.start();
    }
}