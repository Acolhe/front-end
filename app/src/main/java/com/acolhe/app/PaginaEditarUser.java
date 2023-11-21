package com.acolhe.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.acolhe.acolhe_api.R;
import com.acolhe.app.Retrofit.Methods;
import com.acolhe.app.Retrofit.RetrofitClient;
import com.acolhe.app.Retrofit.StringModel;
import com.acolhe.app.model.UsuarioDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaginaEditarUser extends AppCompatActivity {
    private int id;

    EditText novoNome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        id = UsuarioDTO.getId();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_user);
        ImageView setinhaVoltar = findViewById(R.id.setinhavoltarmenuprincipal);
        LinearLayout btnAcolhePlus = findViewById(R.id.lnrLytAcolhePlus);
        ImageView imagemPlus = findViewById(R.id.imgVwAcolhePlus);
        novoNome = findViewById(R.id.editTextTextPersonName2);

        setinhaVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnAcolhePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PaginaAcolhePlus.class);
                startActivity(intent);
            }
        });


        imagemPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PaginaAcolhePlus.class);
                startActivity(intent);
            }
        });
    }


    public void salvarNovoNome(View view){
        if(novoNome.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "O novo nome não pode ser vazio", Toast.LENGTH_SHORT).show();
        }else{
            Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
            methods.updateName(id, novoNome.getText().toString()).enqueue(new Callback<StringModel>() {
                @Override
                public void onResponse(Call<StringModel> call, Response<StringModel> response) {
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println(id);
                    System.out.println(novoNome.getText().toString());
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    if(response.isSuccessful()) {
                        UsuarioDTO.setNome(novoNome.getText().toString());
                    }
                    Toast.makeText(getApplicationContext(), "Nome Alterado", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<StringModel> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Erro", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

}
