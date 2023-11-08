package com.acolhe.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.model.Clinica;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ClinicaAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    List<Clinica> clinicas;

    public ClinicaAdapter(Context context, List<Clinica> clinicas){
        this.context = context;
        this.inflater = (LayoutInflater.from(context));
        this.clinicas = clinicas;
    }

    @Override
    public int getCount() {
        return clinicas.size();
    }

    @Override
    public Object getItem(int i) {
        return clinicas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = 	inflater.inflate(R.layout.adapter_clinica, null);
        Clinica objAtual = clinicas.get(i);
        ImageView imgClinica = view.findViewById(R.id.imgVwHomeClinica);
        TextView nmClinica = view.findViewById(R.id.txtVwNmClinica);
        TextView localClinica = view.findViewById(R.id.txtVwLocalClinica);
        TextView descricao = view.findViewById(R.id.txtVwDescricaoClinicas);
        TextView numeroTelefone = view.findViewById(R.id.txtVwNumeroTelefone);
        TextView email = view.findViewById(R.id.txtVwEmail);

        Glide.with(view).load(objAtual.getImagem()).centerCrop().into(imgClinica);
        String local = String.format("%s, %s - %s", objAtual.getCidade(), objAtual.getBairro(), objAtual.getSgEstado());

        definirSatisfacao(objAtual.getNivelSatisfacao(), view);

        localClinica.setText(local);
        nmClinica.setText(objAtual.getNmClinica());
        descricao.setText(objAtual.getDescricao());
        numeroTelefone.setText(objAtual.getTelefone());
        email.setText(objAtual.getEmail());

        return view;
    }

    private void definirSatisfacao(Integer nivelSatisfacao, View view) {
        List<ImageView> estrelas = new ArrayList<>();
        estrelas.add(view.findViewById(R.id.imgVwEstrela1));
        estrelas.add(view.findViewById(R.id.imgVwEstrela2));
        estrelas.add(view.findViewById(R.id.imgVwEstrela3));
        estrelas.add(view.findViewById(R.id.imgVwEstrela4));
        estrelas.add(view.findViewById(R.id.imgVwEstrela5));
        for(int i = 0; i < nivelSatisfacao; i++) {
            estrelas.get(i).setImageResource(R.drawable.estrelacheia);
        }
    }
}
