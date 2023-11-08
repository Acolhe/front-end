package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.model.Humor;
import com.acolhe.app.Retrofit.Methods;
import com.acolhe.app.Retrofit.RetrofitClient;
import com.acolhe.app.Retrofit.StringModel;
import com.acolhe.app.model.HumorDTO;
import com.acolhe.app.model.Usuario;
import com.acolhe.app.model.UsuarioDTO;
import com.acolhe.app.utils.verifyInternet;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HumorDiario extends AppCompatActivity {

    private int nivelSatisfacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humor_diario);
        System.out.println("USUARIO DTOOOOOO: "+ UsuarioDTO.string());
        if (!verifyInternet.isNetworkAvailable(this)) {
            Intent intent = new Intent(this, SemInternet.class);
            startActivity(intent);
        }
    }


    public void abrirMuitoTriste(View view) {
        TextView texto_humor = findViewById(R.id.humor);
        ImageView imagem_humor = findViewById(R.id.humorPrincipal);
        LinearLayout layout_humor = findViewById(R.id.linearLayout3);
        texto_humor.setText("Não me sinto nada bem");
        imagem_humor.setImageResource(R.drawable.nadabem);
        layout_humor.setBackgroundResource(R.color.nada_bem_bg);
        nivelSatisfacao = 1;
    }

    public void abrirTriste(View view) {
        TextView texto_humor = findViewById(R.id.humor);
        ImageView imagem_humor = findViewById(R.id.humorPrincipal);
        LinearLayout layout_humor = findViewById(R.id.linearLayout3);
        texto_humor.setText("Estou meio triste");
        imagem_humor.setImageResource(R.drawable.triste);
        layout_humor.setBackgroundResource(R.color.triste_bg);
        nivelSatisfacao = 2;
    }


    public void abrirNormal(View view) {
        TextView texto_humor = findViewById(R.id.humor);
        ImageView imagem_humor = findViewById(R.id.humorPrincipal);
        LinearLayout layout_humor = findViewById(R.id.linearLayout3);
        texto_humor.setText("Normal");
        imagem_humor.setImageResource(R.drawable.normal);
        layout_humor.setBackgroundResource(R.color.normal_bg);
        nivelSatisfacao = 3;
    }

    public void abrirBem(View view) {
        TextView texto_humor = findViewById(R.id.humor);
        ImageView imagem_humor = findViewById(R.id.humorPrincipal);
        LinearLayout layout_humor = findViewById(R.id.linearLayout3);
        texto_humor.setText("Estou bem!");
        imagem_humor.setImageResource(R.drawable.bem);
        layout_humor.setBackgroundResource(R.color.bem_bg);
        nivelSatisfacao = 4;
    }

    public void abrirMuitoBem(View view) {
        TextView texto_humor = findViewById(R.id.humor);
        ImageView imagem_humor = findViewById(R.id.humorPrincipal);
        LinearLayout layout_humor = findViewById(R.id.linearLayout3);
        texto_humor.setText("Me sinto muito bem!");
        imagem_humor.setImageResource(R.drawable.muitobem);
        layout_humor.setBackgroundResource(R.color.muito_bem_bg);
        nivelSatisfacao = 5;
    }

    public void fecharHumor(View view) {
        Humor humor = new Humor(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), nivelSatisfacao, "comentario");
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        methods.addHumor(UsuarioDTO.getId(), humor).enqueue(new Callback<StringModel>() {
            @Override
            public void onResponse(Call<StringModel> call, Response<StringModel> response) {
                System.out.println(response.body() + "Teste teste teste");
            }

            @Override
            public void onFailure(Call<StringModel> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        startActivity(new Intent(HumorDiario.this, MainActivity.class));
    }
}


