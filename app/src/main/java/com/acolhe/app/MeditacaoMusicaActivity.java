package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.model.Respiracao;

public class MeditacaoMusicaActivity extends AppCompatActivity {

    private TextView musica;
    private TextView tecnica;
    private TextView endCounter;
    private TextView startCounter;
    private ImageView player;
    private MediaPlayer media;
    private SeekBar seekBar;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditacao_musica);
        Bundle extras = getIntent().getExtras();
        seekBar = findViewById(R.id.seekBar2);
        musica = findViewById(R.id.musica);
        tecnica = findViewById(R.id.tecnica);
        endCounter = findViewById(R.id.counter);
        startCounter = findViewById(R.id.startCounter);
        player = findViewById(R.id.player);
        if (extras != null) {
            Respiracao respiracao = (Respiracao) extras.getSerializable("respiracao");
            musica.setText(respiracao.getTitulo());
            tecnica.setText(respiracao.getTecnica());
            media = MediaPlayer.create(this, respiracao.getArquivo());
            seekBar.setMax(media.getDuration());
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (fromUser) {
                        media.seekTo(progress);
                    }
                }
                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }
                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
        }
        update();
        ImageView sair = findViewById(R.id.exit_button_msc);
        sair.setOnClickListener(view -> {
            if(media.isPlaying()) {
                media.stop();
            }
            handler.removeCallbacksAndMessages(null);
            finish();
        });
        player.setOnClickListener(view -> play());
        media.setOnCompletionListener(mediaPlayer -> {
            player.setImageResource(R.drawable.music_play);
        });

    }

    private void play() {
        if(!media.isPlaying()){
            media.start();
            player.setImageResource(R.drawable.music_pause);
        }else {
            media.pause();
            player.setImageResource(R.drawable.music_play);
        }
    }

    private void update() {
        seekBar.setProgress(media.getCurrentPosition());
        long milliseconds = media.getCurrentPosition();
        int seconds = (int) (milliseconds / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;

        String time = String.format("%d:%02d", minutes, seconds);
        startCounter.setText(time);

        milliseconds = media.getDuration() - media.getCurrentPosition();
        seconds = (int) (milliseconds / 1000);
        minutes = seconds / 60;
        seconds = seconds % 60;

        time = String.format("-%d:%02d", minutes, seconds);
        endCounter.setText(time);
        handler.postDelayed(this::update, 1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (media != null) {
            media.release();
        }
    }
}