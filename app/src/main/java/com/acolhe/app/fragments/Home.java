package com.acolhe.app.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.MeditacaoHome;

public class Home extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        view.findViewById(R.id.open_meditacao).setOnClickListener(view1 -> {
            startActivity(new Intent(getContext(), MeditacaoHome.class));
        });

        return view;
    }
}