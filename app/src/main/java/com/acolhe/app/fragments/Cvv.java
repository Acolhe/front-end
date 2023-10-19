package com.acolhe.app.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.acolhe.acolhe_api.R;

public class Cvv extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_cvv, container, false);


        Button ligarCvvButton = view.findViewById(R.id.button3);
        Button chatCvvButton = view.findViewById(R.id.button2);

        ligarCvvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ligarParaCvv();
            }
        });

        chatCvvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirChatComCvv();
            }
        });


        return view;
    }

    private void ligarParaCvv() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:188"));
        startActivity(intent);
    }

    private void abrirChatComCvv() {
        String url = "http://cvvweb.mysuite1.com.br/client/chatan.php?h=&inf=&lfa=";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Erro ao abrir o navegador.", Toast.LENGTH_SHORT).show();
        }
    }
}