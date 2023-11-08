package com.acolhe.app.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.ClinicasActivity;
import com.acolhe.app.model.Clinica;
import com.bumptech.glide.Glide;
import com.github.islamkhsh.CardSliderAdapter;

import java.util.ArrayList;
import java.util.List;

public class ClinicaSliderAdapter extends CardSliderAdapter<ClinicaSliderAdapter.ClinicaViewHolder> {
    private final List<Clinica> clinicas;

    public ClinicaSliderAdapter(ArrayList<Clinica> patrocinadas){
        this.clinicas = patrocinadas;
    }

    @Override
    public int getItemCount(){
        return clinicas != null ? clinicas.size() : 0;
    }

    @NonNull
    @Override
    public ClinicaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ClinicaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_clinica_home, parent, false));
    }

    @Override
    public void bindVH(@NonNull ClinicaViewHolder vh, int i) {
        vh.onClick.setOnClickListener(view -> view.getContext().startActivity(new Intent(view.getContext(), ClinicasActivity.class)));
        Clinica objAtual = clinicas.get(i);

        Glide.with(vh.itemView).load(objAtual.getImagem()).centerCrop().into(vh.imgClinica);
        String local = String.format("%s, %s - %s", objAtual.getCidade(), objAtual.getBairro(), objAtual.getSgEstado());
        vh.localClinica.setText(local);
        vh.nmClinica.setText(objAtual.getNmClinica());
    }

    class ClinicaViewHolder extends RecyclerView.ViewHolder {
        LinearLayout onClick;
        ImageView imgClinica;
        TextView nmClinica;
        TextView localClinica;
        public ClinicaViewHolder(View view){
            super(view);
            this.onClick = view.findViewById(R.id.onClickLinearLayout_home);
            this.imgClinica = view.findViewById(R.id.imgVwHomeClinica);
            this.nmClinica = view.findViewById(R.id.txtVwNmClinica);
            this.localClinica = view.findViewById(R.id.txtVwLocalClinica);
        }
    }
}
