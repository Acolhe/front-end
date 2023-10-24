package com.acolhe.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.acolhe.acolhe_api.R;
import com.google.firebase.auth.FirebaseAuth;

public class PaginaProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        ImageView setinhaVoltar = findViewById(R.id.setinhavoltarmenuprincipal);
        LinearLayout btnAcolhePlus = findViewById(R.id.lnrLytAcolhePlus);
        ImageView imagemPlus = findViewById(R.id.imgVwAcolhePlus);
        LinearLayout editarPerfilLayout = findViewById(R.id.editaremail);
        TextView textEditarperfil = findViewById(R.id.textEditarperfil);
        ImageView fotoperfil = findViewById(R.id.fotoperfil);
        TextView textDesconectar = findViewById(R.id.cliqueDesconectar);
        setinhaVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        textEditarperfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PaginaEditarUser.class);
                startActivity(intent);
            }
        });

        textDesconectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), PaginaInicialActivity.class);
                startActivity(intent);
            }
        });

        fotoperfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PaginaEditarUser.class);
                startActivity(intent);
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
        editarPerfilLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PaginaEditarUser.class);
                startActivity(intent);
            }
        });
    }
}
