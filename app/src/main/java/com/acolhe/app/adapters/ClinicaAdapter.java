package com.acolhe.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.acolhe.acolhe_api.R;

public class ClinicaAdapter extends BaseAdapter {

    Context context;
    String[] dados1;
    int[] dados2;
    LayoutInflater inflater;

    public ClinicaAdapter(Context context){
        this.context = context;
        this.inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 1;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = 	inflater.inflate(R.layout.adapter_clinica, null);
        return view;
    }
}
