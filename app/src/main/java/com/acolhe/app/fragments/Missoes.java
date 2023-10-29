package com.acolhe.app.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.config.ConfigFirebase;
import com.acolhe.app.model.Frase;
import com.acolhe.app.model.Missao;
import com.acolhe.app.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Missoes extends Fragment {

    private DatabaseReference db;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.db = ConfigFirebase.getFirebaseDatabase();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_missoes, container, false);
        setMisssao(2);
        preencheMissao(view);

        validaCheckbox(view.findViewById(R.id.chckBxCheckBox1), 0);
        validaCheckbox(view.findViewById(R.id.chckBxCheckBox2), 1);

        return view;
    }

    private void preencheMissao(View view){
        TextView txtVwNmMissao1 = view.findViewById(R.id.txtVwNmMissao1);
        TextView txtVwNmMissao2 = view.findViewById(R.id.txtVwNmMissao2);
        TextView txtVwDescricao1 = view.findViewById(R.id.txtVwDescricao1);
        TextView txtVwDescricao2 = view.findViewById(R.id.txtVwDescricao2);

        ArrayList<Missao> ms2 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ms2.add(new Missao("Missao Legal " + (i + 1), "Missao bacana para ser concluida", (int) (Math.random() * 100), false));
        }

        Query q = db.child("missoes").limitToFirst(2);
        q.get().addOnCompleteListener(task -> {
            if(!task.isSuccessful()) {
                Log.d("firebase", "Error getting data", task.getException());
            }else {
                List<Missao> missoes = new ArrayList<>();
                for (DataSnapshot snp : task.getResult().getChildren()) {
                    Missao missao = snp.getValue(Missao.class);
                    missoes.add(missao);
                }
                txtVwNmMissao1.setText(missoes.get(0).getNome() + "");
                txtVwDescricao1.setText(missoes.get(0).getDescricao() + "");
                txtVwNmMissao2.setText(missoes.get(1).getNome() + "");
                txtVwDescricao2.setText(missoes.get(1).getDescricao() + "");

            }
        });

    }

    private void setMisssao(int quantidade){
        ArrayList<Missao> ms2 = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            ms2.add(new Missao("Missao Legal " + (i+1), "Missao bacana para ser concluida", (int) (Math.random() * 100), false));
        }
        for (Missao ms: ms2) {
            this.db.child("missoes").push().setValue(ms);
        }
    }

    private void validaCheckbox(CheckBox checkBox, int missao){
        checkBox.setOnCheckedChangeListener((compoundButton, b) -> {
            if (checkBox.isChecked()){
                checkBox.setClickable(false);
            }
        });
    }

}