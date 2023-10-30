package com.acolhe.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


import com.acolhe.acolhe_api.R;
import com.bumptech.glide.Glide;

public class VideoAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private String[] links;
    private String[] thumbs;

    public VideoAdapter(Context context, String[] links, String[] thumbs) {
        this.context = context;
        this.links = links;
        this.thumbs = thumbs;
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
        Glide.with(view).load(thumbs[i]).centerCrop().into(thumbnail);

        return view;
    }
}
