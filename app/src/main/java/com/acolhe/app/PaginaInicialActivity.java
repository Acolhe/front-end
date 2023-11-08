package com.acolhe.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;


import com.acolhe.acolhe_api.R;
import com.acolhe.app.model.Clinica;
import com.acolhe.app.model.ClinicasDTO;
import com.acolhe.app.model.Usuario;
import com.acolhe.app.Retrofit.Methods;
import com.acolhe.app.Retrofit.RetrofitClient;
import com.acolhe.app.config.ConfigFirebase;
import com.acolhe.app.model.UsuarioDTO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaginaInicialActivity extends AppCompatActivity {

    ConstraintLayout layout;
    FirebaseAuth auth = ConfigFirebase.getFirebaseAuth();
    private View popupView;
    Methods methods;

    public static Intent bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.linearLayout);
        methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        bundle = new Intent(PaginaInicialActivity.this, HumorDiario.class);
        getClinicas();
    }

    private void getClinicas(){
        methods.getAllClinicas().enqueue(new Callback<List<Clinica>>() {
            @Override
            public void onResponse(Call<List<Clinica>> call, Response<List<Clinica>> response) {
                new ClinicasDTO(response.body());
            }

            @Override
            public void onFailure(Call<List<Clinica>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(PaginaInicialActivity.this, "Internal Server Error, can't load clinicas ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private View CreatePopUpWindow() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        popupView = inflater.inflate(R.layout.mainpopup, null);

        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        boolean focusable = true;
        PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        layout.post(new Runnable() {
            @Override
            public void run() {
                popupWindow.showAtLocation(layout, Gravity.BOTTOM, 0, 0);
            }
        });

        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });

        return popupView;
    }



    public void abrirLogin(View view){
        CreatePopUpWindow();
    }

    public void abrirCadastro(View view){
        Intent intent = new Intent(PaginaInicialActivity.this, PaginaCadastroActivity.class);
        startActivity(intent);

    }

    public void abrirHome(){
        Intent intent = new Intent(PaginaInicialActivity.this, MainActivity.class);
        startActivity(intent);
    }




    public void logarUsuario(View view) {
        EditText emailPopup = popupView.findViewById(R.id.emailinput);
        EditText senhaPopup = popupView.findViewById(R.id.senhainput);

        String emailString = emailPopup.getText().toString();
        String senhaString = senhaPopup.getText().toString();

        methods.loginUser(emailString, senhaString).enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                System.out.println("Usuario Logado");
                auth = ConfigFirebase.getFirebaseAuth();
                auth.signInWithEmailAndPassword(emailString, senhaString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            new UsuarioDTO(response.body());
                            System.out.println("Usuario sem ser DTOOOOOO:"+ response.body());
                            System.out.println("clinicas = " + ClinicasDTO.getClinicas());
                            startActivity(PaginaInicialActivity.bundle);
                        } else {
                            String msg;
                            try {
                                throw task.getException();
                            } catch ( FirebaseAuthInvalidCredentialsException  e){
                                msg = "Usuario não cadastrado";
                            } catch (Exception e){
                                msg = "Você errou a senha!";
                            }
                            Toast.makeText(PaginaInicialActivity.this, msg, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(PaginaInicialActivity.this, "Erro ao logar usuário", Toast.LENGTH_SHORT).show();
            }
        });



    }
}