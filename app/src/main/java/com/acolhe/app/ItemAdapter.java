package com.acolhe.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.acolhe.acolhe_api.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<ItemPlus> itemPlusList;
    private Context context; // Adicione o contexto

    public ItemAdapter(Context context, List<ItemPlus> itemPlusList) {
        this.context = context; // Atribua o contexto
        this.itemPlusList = itemPlusList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_plus_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemPlus itemPlus = itemPlusList.get(position);
        holder.titleTextView.setText(itemPlus.getTitle());
        holder.subtitleTextView.setText(itemPlus.getSubtitle());
        holder.itemImageView.setImageResource(itemPlus.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return itemPlusList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView subtitleTextView;
        ImageView itemImageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.itemTitle);
            subtitleTextView = itemView.findViewById(R.id.itemSubtitle);
            itemImageView = itemView.findViewById(R.id.itemImage);
        }
    }
}
