package com.acolhe.app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.acolhe.acolhe_api.R;

import org.w3c.dom.Text;

public class Missoes extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_missoes, container, false);

        preencheMissao(view);

        validaCheckbox(view.findViewById(R.id.chckBxCheckBox1));
        validaCheckbox(view.findViewById(R.id.chckBxCheckBox2));

        return view;
    }

    private void preencheMissao(View view){
        String nomeMissao1 = "Exemplo Missão 1";
        String nomeMissao2 = "Exemplo Missão 2";
        String descricaoMissao1 = "Faz ae a missão";
        String descricaoMissao2 = "Exemplo de descrição da missão";

        TextView txtVwNmMissao1 = view.findViewById(R.id.txtVwNmMissao1);
        TextView txtVwNmMissao2 = view.findViewById(R.id.txtVwNmMissao2);
        TextView txtVwDescricao1 = view.findViewById(R.id.txtVwDescricao1);
        TextView txtVwDescricao2 = view.findViewById(R.id.txtVwDescricao2);

        txtVwNmMissao1.setText(nomeMissao1);
        txtVwNmMissao2.setText(nomeMissao2);
        txtVwDescricao1.setText(descricaoMissao1);
        txtVwDescricao2.setText(descricaoMissao2);
    }

    private void validaCheckbox(CheckBox checkBox){
        checkBox.setOnCheckedChangeListener((compoundButton, b) -> {
            if (checkBox.isChecked()){
                checkBox.setClickable(false);
            }
        });
    }

}