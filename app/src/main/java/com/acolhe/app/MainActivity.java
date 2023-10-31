package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.Retrofit.Methods;
import com.acolhe.app.Retrofit.Model;
import com.acolhe.app.Retrofit.RetrofitClient;
import com.acolhe.app.fragments.Cvv;
import com.acolhe.app.fragments.Home;
import com.acolhe.app.fragments.Missoes;
import com.acolhe.app.fragments.Perfil;
import com.acolhe.app.fragments.Store;
import com.acolhe.app.fragments.Videos;
import com.acolhe.app.model.Humor;
import com.acolhe.app.model.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView saldoLayout;
    private TextView ofensivaLayout;
    private Handler handler = new Handler();

    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        saldoLayout = findViewById(R.id.valorSaldo);
        ofensivaLayout = findViewById(R.id.valorOfensiva);

        new Usuario("Rafael",
                40,
                2,
                "rafael.ferraz@picpay.com",
                1,
                LocalDateTime.now(),
                LocalDate.now(),
                true,
                new ArrayList<Humor>());

        ofensivaLayout.setText(Usuario.getOfensiva() + "");
        getBundles();
        adicionarEventosClickCabecalho();
        adicionaEventosCLickRodape();
        saldoEventListener();
    }

    private void saldoEventListener() {
        saldoLayout.setText(Usuario.getSaldo() + "");
        handler.postDelayed(this::saldoEventListener, 1000); // Atualize a cada 1 segundo
    }

    private void getBundles() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
    }
    private void adicionarEventosClickCabecalho() {
        LinearLayout btnPerfil = findViewById(R.id.lnrLytVoltar);
        LinearLayout btnOfensiva = findViewById(R.id.lnrLytOfensiva);
        LinearLayout btnMedalha = findViewById(R.id.lnrLytMedalha);
        LinearLayout btnAcolhePlus = findViewById(R.id.lnrLytAcolhePlus);
        ImageView imageAcolhePlus = findViewById(R.id.imgVwAcolhePlus);

        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PaginaProfileActivity.class);
                startActivity(intent);
            }
        });

        btnOfensiva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFragmento(Home.class);
            }
        });

        btnMedalha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreFragmento(Store.class);
            }
        });

        btnAcolhePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PaginaAcolhePlus.class);

                startActivity(intent);
            }
        });
        imageAcolhePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PaginaAcolhePlus.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }
    private void updatePageName(String pageName) {
        TextView textView = findViewById(R.id.txtVwNomePagina);
        textView.setText(pageName);
    }
    private void adicionaEventosCLickRodape() {
        LinearLayout btnHome = findViewById(R.id.lnrLytHome);
        LinearLayout btnVideos = findViewById(R.id.lnrLytConteudo);
        LinearLayout btnCvv = findViewById(R.id.lnrLytCvv);
        LinearLayout btnMissoes = findViewById(R.id.lnrLytMissao);
        LinearLayout btnStore = findViewById(R.id.lnrLytLoja);

        btnVideos.setOnClickListener(view -> {
                abreFragmento(Videos.class);
                Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
                Call<Model> call = methods.getAllData();
                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        Log.e(TAG, "onResponse: code: " + response.code());
                        String data = response.body().getMessage();
                        Log.e(TAG, "onResponse: emails: " + data);
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Log.e(TAG, "onFailure: code: " + t.getMessage());
                    }
                });
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, Videos.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
                updatePageName(getString(R.string.page_name_videos));
            });

        btnCvv.setOnClickListener(view ->{
                abreFragmento(Cvv.class);
                updatePageName(getString(R.string.page_name_cvv));
        });

        btnMissoes.setOnClickListener(view -> {
                abreFragmento(Missoes.class);
                updatePageName(getString(R.string.page_name_missoes));
        });

        btnStore.setOnClickListener(view -> {
                abreFragmento(Store.class);
                updatePageName(getString(R.string.page_name_store));
        });

        btnHome.setOnClickListener(view -> {
                abreFragmento(Home.class);
                updatePageName(getString(R.string.page_name_home));
        });
    }

    private void abreFragmento(Class target){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment, target, null).setReorderingAllowed(true).addToBackStack("name").commit();
    }
}