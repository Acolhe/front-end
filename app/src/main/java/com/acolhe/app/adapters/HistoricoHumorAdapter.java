package com.acolhe.app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.model.HumorDTO;

import java.util.List;

public class HistoricoHumorAdapter extends RecyclerView.Adapter<HistoricoHumorAdapter.HistoricoViewHolder>{
    private final List<HumorDTO> historico;

    public HistoricoHumorAdapter(List<HumorDTO> historico) {
        this.historico = historico;
    }

    @Override
    public int getItemCount() {
        return historico == null ? 0 : historico.size();
    }

    @NonNull
    @Override
    public HistoricoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoricoHumorAdapter.HistoricoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historico_humor, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoricoViewHolder h, int position) {
        HumorDTO atual = historico.get(position);
        h.humor.setText(atual.getNivelSatisfacao().toString());
        h.diaHumor.setText(atual.getData().getDayOfMonth() + "");
        h.mesHumor.setText(atual.getData().getMonth().toString().substring(0, 3));
        h.carinhaHumor.setImageResource(atual.getImagem());
    }

    class HistoricoViewHolder extends RecyclerView.ViewHolder{
        TextView mesHumor;
        TextView diaHumor;
        TextView humor;
        ImageView carinhaHumor;

        public HistoricoViewHolder(@NonNull View view) {
            super(view);
            this.mesHumor = view.findViewById(R.id.mesHumor_item);
            this.diaHumor = view.findViewById(R.id.diaHumor_item);
            this.humor = view.findViewById(R.id.humorDiario_item);
            this.carinhaHumor = view.findViewById(R.id.carinhaHumor_item);
        }
    }
}
