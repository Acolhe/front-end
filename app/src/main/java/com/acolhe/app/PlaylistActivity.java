package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.model.Respiracao;

import java.util.ArrayList;
import java.util.List;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        Bundle extras = getIntent().getExtras();
        List<Respiracao> respiracao = null;
        if (extras != null) {
            respiracao =  (List<Respiracao>) extras.getSerializable("respiracao");
        }
        assert respiracao != null;
        Toast.makeText(this, respiracao.get(1).getTecnica(), Toast.LENGTH_SHORT).show();

    }
}