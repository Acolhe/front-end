package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.acolhe.acolhe_api.R;

public class HumorDiario extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humor_diario);
    }



    public void abrirMuitoTriste(View view){
        TextView texto_humor = findViewById(R.id.humor);
        ImageView imagem_humor = findViewById(R.id.humorPrincipal);
        LinearLayout layout_humor = findViewById(R.id.linearLayout3);
        texto_humor.setText("Não me sinto nada bem");
        imagem_humor.setImageResource(R.drawable.nadabem);
        layout_humor.setBackgroundResource(R.color.nada_bem_bg);
    }

    public void abrirTriste(View view){
        TextView texto_humor = findViewById(R.id.humor);
        ImageView imagem_humor = findViewById(R.id.humorPrincipal);
        LinearLayout layout_humor = findViewById(R.id.linearLayout3);
        texto_humor.setText("Estou meio triste");
        imagem_humor.setImageResource(R.drawable.triste);
        layout_humor.setBackgroundResource(R.color.triste_bg);
    }


    public void abrirNormal(View view){
        TextView texto_humor = findViewById(R.id.humor);
        ImageView imagem_humor = findViewById(R.id.humorPrincipal);
        LinearLayout layout_humor = findViewById(R.id.linearLayout3);
        texto_humor.setText("Normal");
        imagem_humor.setImageResource(R.drawable.normal);
        layout_humor.setBackgroundResource(R.color.normal_bg);
    }

    public void abrirBem(View view){
        TextView texto_humor = findViewById(R.id.humor);
        ImageView imagem_humor = findViewById(R.id.humorPrincipal);
        LinearLayout layout_humor = findViewById(R.id.linearLayout3);
        texto_humor.setText("Estou bem!");
        imagem_humor.setImageResource(R.drawable.bem);
        layout_humor.setBackgroundResource(R.color.bem_bg);
    }

    public void abrirMuitoBem(View view){
        TextView texto_humor = findViewById(R.id.humor);
        ImageView imagem_humor = findViewById(R.id.humorPrincipal);
        LinearLayout layout_humor = findViewById(R.id.linearLayout3);
        texto_humor.setText("Me sinto muito bem!");
        imagem_humor.setImageResource(R.drawable.muitobem);
        layout_humor.setBackgroundResource(R.color.muito_bem_bg);
    }
    public void fecharHumor(View view){
        finish();
    }
}