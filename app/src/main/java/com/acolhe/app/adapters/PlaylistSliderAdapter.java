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
import com.acolhe.app.PaginaAcolhePlus;
import com.acolhe.app.PlaylistActivity;
import com.acolhe.app.model.Playlist;
import com.acolhe.app.model.Respiracao;
import com.github.islamkhsh.CardSliderAdapter;

import java.io.Serializable;
import java.util.ArrayList;

public class PlaylistSliderAdapter extends CardSliderAdapter<PlaylistSliderAdapter.PlaylistViewHolder> {
    private final ArrayList<Playlist> playlists;

    public PlaylistSliderAdapter(ArrayList<Playlist> playlists){
        this.playlists = playlists;
    }

    @Override
    public int getItemCount(){
        return playlists != null ? playlists.size() : 0;
    }

    @NonNull
    @Override
    public PlaylistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PlaylistViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page, parent, false));
    }

    @Override
    public void bindVH(@NonNull PlaylistViewHolder holder, int position) {
        Playlist playlist = playlists.get(position);
        holder.title.setText(playlist.getTitulo());
        holder.description.setText(playlist.getDescricao());
        holder.imgView.setImageResource(playlist.getImagem());

        holder.clickable.setOnClickListener(view -> {
            if(!playlist.isPremium()) {
                ArrayList<Respiracao> respiracao = playlist.getRespiracoes();
                Intent intent = new Intent(view.getContext(), PlaylistActivity.class);
                intent.putExtra("respiracao", (Serializable) respiracao);
                intent.putExtra("titulo", playlist.getTitulo());
                view.getContext().startActivity(intent);
            }else {
                view.getContext().startActivity(new Intent(view.getContext(), PaginaAcolhePlus.class));
            }
        });
    }

    class PlaylistViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgView;
        public TextView title;
        public TextView description;
        public LinearLayout clickable;

        public PlaylistViewHolder(View view){
            super(view);
            this.imgView = view.findViewById(R.id.cardImage);
            this.title = view.findViewById(R.id.title);
            this.description = view.findViewById(R.id.description);
            this.clickable = view.findViewById(R.id.layout_clickable);
        }
    }
}
