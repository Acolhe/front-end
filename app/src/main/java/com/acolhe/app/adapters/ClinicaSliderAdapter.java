package com.acolhe.app.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.ClinicasActivity;
import com.acolhe.app.PaginaAcolhePlus;
import com.acolhe.app.PlaylistActivity;
import com.acolhe.app.model.Clinica;
import com.acolhe.app.model.Playlist;
import com.acolhe.app.model.Respiracao;
import com.github.islamkhsh.CardSliderAdapter;

import java.io.Serializable;
import java.util.ArrayList;

public class ClinicaSliderAdapter extends CardSliderAdapter<ClinicaSliderAdapter.ClinicaViewHolder> {
    private final ArrayList<Clinica> playlists;

    public ClinicaSliderAdapter(ArrayList<Clinica> playlists){
        this.playlists = playlists;
    }

    @Override
    public int getItemCount(){
        return playlists != null ? playlists.size() : 0;
    }

    @NonNull
    @Override
    public ClinicaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ClinicaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_clinica_home, parent, false));
    }

    @Override
    public void bindVH(@NonNull ClinicaViewHolder clinicaViewHolder, int position) {
        clinicaViewHolder.onClick.setOnClickListener(view -> view.getContext().startActivity(new Intent(view.getContext(), ClinicasActivity.class)));
    }

    class ClinicaViewHolder extends RecyclerView.ViewHolder {
        LinearLayout onClick;
        public ClinicaViewHolder(View view){
            super(view);
            this.onClick = view.findViewById(R.id.onClickLinearLayout_home);
        }
    }
}
