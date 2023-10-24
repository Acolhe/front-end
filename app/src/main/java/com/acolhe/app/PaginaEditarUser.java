package com.acolhe.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.acolhe.acolhe_api.R;

public class PaginaEditarUser extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_user);
        ImageView setinhaVoltar = findViewById(R.id.setinhavoltarmenuprincipal);
        LinearLayout btnAcolhePlus = findViewById(R.id.lnrLytAcolhePlus);
        ImageView imagemPlus = findViewById(R.id.imgVwAcolhePlus);

        setinhaVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnAcolhePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PaginaAcolhePlus.class);
                startActivity(intent);
            }
        });

        imagemPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PaginaAcolhePlus.class);
                startActivity(intent);
            }
        });
    }

}
