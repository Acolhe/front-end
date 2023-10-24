package com.acolhe.app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.model.Respiracao;
import com.github.islamkhsh.CardSliderAdapter;

import java.util.List;

public class RespiracaoSliderAdapter extends CardSliderAdapter<RespiracaoSliderAdapter.RespiracaoViewHolder> {
    private final List<Respiracao> respiracoes;

    public RespiracaoSliderAdapter(List<Respiracao> respiracoes){
        this.respiracoes = respiracoes;
    }

    @NonNull
    @Override
    public RespiracaoSliderAdapter.RespiracaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RespiracaoSliderAdapter.RespiracaoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_respiracao, parent, false));
    }

    @Override
    public int getItemCount() {
        return respiracoes != null ? respiracoes.size() : 0;
    }
    @Override
    public void bindVH(@NonNull RespiracaoSliderAdapter.RespiracaoViewHolder vh, int i) {
        Respiracao resp = respiracoes.get(i);
        vh.tituloResp.setText(resp.getTitulo());
        vh.descricao.setText(resp.getDescricao());
        vh.tecnica.setText(resp.getTecnica());
    }

    class RespiracaoViewHolder extends RecyclerView.ViewHolder {
        public TextView tituloResp;
        public TextView descricao;
        public TextView tecnica;
        public RespiracaoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tituloResp = itemView.findViewById(R.id.tituloResp2);
            this.descricao = itemView.findViewById(R.id.descricaoResp);
            this.tecnica = itemView.findViewById(R.id.tecnicaResp);
        }
    }
}
