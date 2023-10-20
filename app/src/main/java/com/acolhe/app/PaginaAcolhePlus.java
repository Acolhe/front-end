package com.acolhe.app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.adapters.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class PaginaAcolhePlus extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
}
