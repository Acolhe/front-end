package com.acolhe.app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.Retrofit.Methods;
import com.acolhe.app.Retrofit.RetrofitClient;
import com.acolhe.app.Retrofit.StringModel;
import com.acolhe.app.config.ConfigFirebase;
import com.acolhe.app.model.Missao;
import com.acolhe.app.model.Usuario;
import com.acolhe.app.model.UsuarioDTO;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Missoes extends Fragment {

    private DatabaseReference db;
    private List<Missao> missoes = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.db = ConfigFirebase.getFirebaseDatabase().child("missoes");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_missoes, container, false);
        preencheMissao(view);
        return view;
    }

    private void preencheMissao(View view){
        TextView txtVwNmMissao1 = view.findViewById(R.id.txtVwNmMissao1);
        TextView txtVwNmMissao2 = view.findViewById(R.id.txtVwNmMissao2);
        TextView txtVwDescricao1 = view.findViewById(R.id.txtVwDescricao1);
        TextView txtVwDescricao2 = view.findViewById(R.id.txtVwDescricao2);

        Query q = db.limitToFirst(2);
        q.get().addOnCompleteListener(task -> {
            if(!task.isSuccessful()) {
                Log.d("firebase", "Error getting data", task.getException());
            }else {
                for (DataSnapshot snp : task.getResult().getChildren()) {
                    Missao missao = snp.getValue(Missao.class);
                    missao.setKey(snp.getKey());
                    missoes.add(missao);
                }
                txtVwNmMissao1.setText(missoes.get(0).getNome() + "");
                txtVwDescricao1.setText(missoes.get(0).getDescricao() + "");
                txtVwNmMissao2.setText(missoes.get(1).getNome() + "");
                txtVwDescricao2.setText(missoes.get(1).getDescricao() + "");

                validaCheckbox(view.findViewById(R.id.chckBxCheckBox1), 0);
                validaCheckbox(view.findViewById(R.id.chckBxCheckBox2), 1);
            }
        });

    }

    private void setMisssao(int quantidade){
        ArrayList<Missao> ms2 = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            ms2.add(new Missao("Missao Legal " + (i+1), "","Missao bacana para ser concluida", (int) (Math.random() * 100)));
        }
        for (Missao ms: ms2) {
            this.db.push().setValue(ms);
        }
    }

    private void validaCheckbox(CheckBox checkBox, int i) {
        if(missoes.get(i).getUsuarios().contains(UsuarioDTO.getId())){
            checkBox.setClickable(false);
            checkBox.setChecked(true);
        }
        checkBox.setOnCheckedChangeListener((compoundButton, b) -> {
            if (checkBox.isChecked()) {
                UsuarioDTO.updateSaldo(missoes.get(i).getValor());
                Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);

                methods.aumentarSaldo(UsuarioDTO.getId(), UsuarioDTO.getSaldo()).enqueue(new Callback<StringModel>() {
                    @Override
                    public void onResponse(Call<StringModel> call, Response<StringModel> response) {
                        System.out.println(response.body().getMessage());
                        Toast toast = Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    @Override
                    public void onFailure(Call<StringModel> call, Throwable t) {
                        Toast toast = Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

                missoes.get(i).add(UsuarioDTO.getId());
                this.db.child(missoes.get(i).getKey()).setValue(missoes.get(i));

                checkBox.setClickable(false);
            }
        });
    }
}