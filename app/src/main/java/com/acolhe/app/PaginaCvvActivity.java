package com.acolhe.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.acolhe.acolhe_api.R;

public class PaginaCvvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paginacvv);

        // Definindo cliques nos botões
        Button ligarCvvButton = findViewById(R.id.button3);
        Button chatCvvButton = findViewById(R.id.button2);

        ligarCvvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ligarParaCvv();
            }
        });

        chatCvvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirChatComCvv();
            }
        });
    }
    private void ligarParaCvv() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:188"));
        startActivity(intent);
    }
    private void abrirChatComCvv() {
        String url = "http://cvvweb.mysuite1.com.br/client/chatan.php?h=&inf=&lfa=";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Erro ao abrir o navegador.", Toast.LENGTH_SHORT).show();
        }
    }
}
