package com.acolhe.app;

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
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.acolhe.acolhe_api.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PaginaInicialActivity extends AppCompatActivity {
    ConstraintLayout layout;
//    EditText editText = findViewById(R.id.senhainput);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference();

        myRef.child("teste").setValue("Hello World");
        layout = findViewById(R.id.linearLayout);
//        CreatePopUpWindow();


// Defina um ouvinte de foco para o EditText
//        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                if (hasFocus) {
//                    // O EditText está em foco, portanto, altere a cor da dica
//                    editText.setHintTextColor(getResources().getColor(R.color.focus_Color));
//                } else {
//                    // O EditText não está mais em foco, restaure a cor da dica padrão
//                    editText.setHintTextColor(getResources().getColor(R.color.focus_Color));
//                }
//            }
//        });


    }

    private void CreatePopUpWindow() {
        LayoutInflater inflater= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popUpView=inflater.inflate(R.layout.mainpopup,null);

        int width= ViewGroup.LayoutParams.MATCH_PARENT;
        int height=ViewGroup.LayoutParams.MATCH_PARENT;
        boolean focusable=true;
        PopupWindow popupWindow=new PopupWindow(popUpView,width,height,focusable);
        layout.post(new Runnable() {
            @Override
            public void run() {
                popupWindow.showAtLocation(layout, Gravity.BOTTOM,0,0);

            }
        });

        popUpView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });

    }


    public void abrirLogin(View view){
        CreatePopUpWindow();
    }

    public void abrirCadastro(View view){
        Intent intent = new Intent(PaginaInicialActivity.this, PaginaCadastroActivity.class);
        startActivity(intent);

    }

    public void abrirHome(View view){
        Intent intent = new Intent(PaginaInicialActivity.this, MainActivity.class);
        startActivity(intent);

    }


}