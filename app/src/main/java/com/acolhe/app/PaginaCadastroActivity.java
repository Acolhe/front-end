package com.acolhe.app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.acolhe.acolhe_api.R;
import com.google.android.material.textfield.TextInputLayout;

public class PaginaCadastroActivity extends AppCompatActivity {

    private EditText nomeEditText;
    private EditText emailEditText;
    private EditText senhaEditText;
    private Button cadastrarButton;
    private CheckBox concordoCheckBox;
    private boolean senhaVisivel = false;
    private boolean checkBoxMarcado = false;

    public void voltarCadastro(View view) {
        Intent intent = new Intent(this, PaginaInicialActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_cadastro);

        nomeEditText = findViewById(R.id.nomeEditText);
        emailEditText = findViewById(R.id.emailEditText);
        senhaEditText = findViewById(R.id.senhaEditText);
        cadastrarButton = findViewById(R.id.cadastrarButton);
        concordoCheckBox = findViewById(R.id.concordoCheckBox);

        nomeEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        emailEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        senhaEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        TextInputLayout nomeTextInputLayout = findViewById(R.id.nomeTextInputLayout);
        TextInputLayout emailTextInputLayout = findViewById(R.id.emailTextInputLayout);
        TextInputLayout senhaTextInputLayout = findViewById(R.id.senhaTextInputLayout);
        cadastrarButton.setEnabled(false);
        cadastrarButton.setOnClickListener(new View.OnClickListener() {
            private boolean contemApenasLetras(String texto) {
                return texto.matches("[a-zA-Z\\s]+");
            }
            private boolean emailValido(String email) {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }
            @Override
            public void onClick(View v) {
                String senha = senhaEditText.getText().toString();
                String nome = nomeEditText.getText().toString();
                String email = emailEditText.getText().toString();

                boolean camposVazios = false;

                if (senha.isEmpty()) {
                    senhaTextInputLayout.setError("Esse campo é obrigatório");
                    camposVazios = true;
                } else {
                    senhaTextInputLayout.setError(null);
                }

                if (nome.isEmpty()) {
                    nomeTextInputLayout.setError("Esse campo é obrigatório");
                    camposVazios = true;
                } else {
                    nomeTextInputLayout.setError(null);
                }

                if (email.isEmpty()) {
                    emailTextInputLayout.setError("Esse campo é obrigatório");
                    camposVazios = true;
                } else {
                    emailTextInputLayout.setError(null);
                }
                if (!contemApenasLetras(nome)) {
                    nomeTextInputLayout.setError("O nome deve conter apenas letras");
                    camposVazios = true;
                } else {
                    nomeTextInputLayout.setError(null);
                }
                if (!emailValido(email)) {
                    emailTextInputLayout.setError("Email inválido");
                    camposVazios = true;
                } else {
                    emailTextInputLayout.setError(null);
                }
                if (camposVazios) {
                    return;
                }
                Log.d("Senha", senha);
                Log.d("Nome", nome);
                Log.d("Email", email);
            }
        });

        concordoCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cadastrarButton.setEnabled(isChecked);
                if (isChecked) {
                    cadastrarButton.setTextColor(Color.WHITE);
                } else {
                    int corPadrao = ContextCompat.getColor(getApplicationContext(), R.color.gray);
                    cadastrarButton.setTextColor(corPadrao);
                }
            }
        });



        Button visualizarSenhaButton = findViewById(R.id.visualizarSenhaButton);
        visualizarSenhaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senhaEditText.setTransformationMethod(
                        senhaVisivel ? new PasswordTransformationMethod() : null
                );
                senhaVisivel = !senhaVisivel;
                senhaEditText.setSelection(senhaEditText.getText().length());
            }
        });

        senhaEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (senhaVisivel) {
                    senhaEditText.removeTextChangedListener(this);
                    senhaEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
                    senhaEditText.setSelection(senhaEditText.getText().length());
                    senhaEditText.addTextChangedListener(this);
                }
            }
        });

        concordoCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxMarcado = isChecked;
                atualizarBotaoCadastro();
            }

            private void atualizarBotaoCadastro() {
                if (checkBoxMarcado) {
                    cadastrarButton.setEnabled(true);
                    cadastrarButton.setTextColor(Color.WHITE);
                } else {
                    cadastrarButton.setEnabled(false);
                    int corPadrao = ContextCompat.getColor(getApplicationContext(), R.color.gray);
                    cadastrarButton.setTextColor(corPadrao);
                }
            }
        });
    }
}