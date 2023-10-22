package com.acolhe.app.adapters;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


import com.acolhe.acolhe_api.R;

public class VideoAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private String[] links;
    private int[] imagensVideos;

    public VideoAdapter(Context context, String[] links, int[] imagensVideos) {
        this.context = context;
        this.links = links;
        this.imagensVideos = imagensVideos;
        this.inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return links.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_video, null);

        ImageView thumbnail = view.findViewById(R.id.imgVwVideo);
        thumbnail.setImageResource(imagensVideos[i]);

        return view;
    }
}
