package com.acolhe.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.acolhe.acolhe_api.R;

import java.util.ArrayList;
import java.util.List;

public class PaginaAcolhePlus extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acolhe_plus);

        RecyclerView recyclerView = findViewById(R.id.itemList);
        List<ItemPlus> itemPlusList = new ArrayList<>();
        itemPlusList.add(new ItemPlus("Conteúdos ilimitados", "Tenha acesso a conteúdos ilimitados selecionados pelos nossos especialistas!", R.drawable.cadeado));
        itemPlusList.add(new ItemPlus("Sem nenhum anúncio", "Acesse todos os conteúdos, respirações e audios sem nenhum anúncio!", R.drawable.block));
        itemPlusList.add(new ItemPlus("Ganhe mais moedas", "Ganhe mais moedas completando missões diárias!", R.drawable.coracaoplus));
        itemPlusList.add(new ItemPlus("Mais missões", "Se divirta fazendo mais missões e missões cada vez mais difíceis!", R.drawable.alvoeflecha));

        ItemAdapter adapter = new ItemAdapter(this, itemPlusList);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
