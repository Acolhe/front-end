package com.acolhe.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.Retrofit.Methods;
import com.acolhe.app.Retrofit.RetrofitClient;
import com.acolhe.app.Retrofit.StringModel;
import com.acolhe.app.adapters.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaginaAcolhePlus extends AppCompatActivity {

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        String teste = intent.getStringExtra("teste");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acolhe_plus);

        RecyclerView recyclerView = findViewById(R.id.itemList);
        List<Item> itemList = new ArrayList<>();
        TextView noThanks = findViewById(R.id.noThanksButton);
        itemList.add(new Item("Conteúdos ilimitados", "Tenha acesso a conteúdos ilimitados selecionados pelos nossos especialistas!", R.drawable.cadeado));
        itemList.add(new Item("Sem nenhum anúncio", "Acesse todos os conteúdos, respirações e audios sem nenhum anúncio!", R.drawable.block));
        itemList.add(new Item("Ganhe mais moedas", "Ganhe mais moedas completando missões diárias!", R.drawable.coracaoplus));
        itemList.add(new Item("Mais missões", "Se divirta fazendo mais missões e missões cada vez mais difíceis!", R.drawable.alvoeflecha));

        ItemAdapter adapter = new ItemAdapter(this, itemList);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        noThanks.setOnClickListener(view -> {
            finish();
        });
    }

    public void salvar(View view){
        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        methods.becomePremium(id).enqueue(new Callback<StringModel>() {
            @Override
            public void onResponse(Call<StringModel> call, Response<StringModel> response) {
                System.out.println(response.body());
                Toast toast = Toast.makeText(getApplicationContext(), "Agora você é premium", Toast.LENGTH_LONG);
                toast.show();
            }

            @Override
            public void onFailure(Call<StringModel> call, Throwable t) {

            }
        });
    }

}
