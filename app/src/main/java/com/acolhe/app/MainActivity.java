package com.acolhe.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.Retrofit.Methods;
import com.acolhe.app.Retrofit.ResponseModel;
import com.acolhe.app.Retrofit.RetrofitClient;
import com.acolhe.app.fragments.Cvv;
import com.acolhe.app.fragments.Home;
import com.acolhe.app.fragments.Missoes;
import com.acolhe.app.fragments.Store;
import com.acolhe.app.fragments.Videos;
import com.acolhe.app.model.Clinica;
import com.acolhe.app.model.ClinicasDTO;
import com.acolhe.app.model.UsuarioDTO;

import java.time.LocalDate;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView saldoLayout;
    private TextView ofensivaLayout;
    private Methods methods;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        methods = RetrofitClient.getRetrofitInstance().create(Methods.class);

        saldoLayout = findViewById(R.id.valorSaldo);
        ofensivaLayout = findViewById(R.id.valorOfensiva);

        ofensivaLayout.setText(UsuarioDTO.getOfensiva() + "");
        adicionarEventosClickCabecalho();
        adicionaEventosCLickRodape();
        saldoEventListener();
        clinicasEventListener();
    }

    private void saldoEventListener() {
        saldoLayout.setText(UsuarioDTO.getSaldo() + "");
        handler.postDelayed(this::saldoEventListener, 1000); // Atualize a cada 1 segundo
    }

    private void clinicasEventListener() {
        methods.getAllClinicas().enqueue(new Callback<List<Clinica>>() {
            @Override
            public void onResponse(Call<List<Clinica>> call, Response<List<Clinica>> response) {
                new ClinicasDTO(response.body());
            }

            @Override
            public void onFailure(Call<List<Clinica>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this, "Internal Server Error, can't load clinicas ", Toast.LENGTH_SHORT).show();
            }
        });
        handler.postDelayed(this::clinicasEventListener, 604800000); // Atualize a cada 7 dias
    }

    private void adicionarEventosClickCabecalho() {
        LinearLayout btnPerfil = findViewById(R.id.lnrLytVoltar);
        LinearLayout btnOfensiva = findViewById(R.id.lnrLytOfensiva);
        LinearLayout btnMedalha = findViewById(R.id.lnrLytMedalha);
        LinearLayout btnAcolhePlus = findViewById(R.id.lnrLytAcolhePlus);
        ImageView imageAcolhePlus = findViewById(R.id.imgVwAcolhePlus);

        btnPerfil.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), PaginaProfileActivity.class)));

        btnOfensiva.setOnClickListener(view -> abreFragmento(Home.class));

        btnMedalha.setOnClickListener(view -> abreFragmento(Store.class));

        btnAcolhePlus.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, PaginaAcolhePlus.class)));

        imageAcolhePlus.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, PaginaAcolhePlus.class)));
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
                updatePageName(getString(R.string.page_name_videos));
            });

        btnCvv.setOnClickListener(view -> {
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