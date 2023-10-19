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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.acolhe.acolhe_api.R;
import com.acolhe.app.config.ConfigFirebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PaginaInicialActivity extends AppCompatActivity {
    ConstraintLayout layout;
    FirebaseAuth auth = ConfigFirebase.getFirebaseAuth();
    EditText email;
    private View popupView;
    EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference();

        myRef.child("teste").setValue("Hello World");
        layout = findViewById(R.id.linearLayout);


    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = ConfigFirebase.getFirebaseAuth();

        FirebaseUser actual_user = auth.getCurrentUser();
        if(actual_user != null){
            Intent intent = new Intent(PaginaInicialActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

//    private View  CreatePopUpWindow() {
//        LayoutInflater inflater= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//        View popUpView=inflater.inflate(R.layout.mainpopup,null);
//
//        int width= ViewGroup.LayoutParams.MATCH_PARENT;
//        int height=ViewGroup.LayoutParams.MATCH_PARENT;
//        boolean focusable=true;
//        PopupWindow popupWindow=new PopupWindow(popUpView,width,height,focusable);
//        layout.post(new Runnable() {
//            @Override
//            public void run() {
//                popupWindow.showAtLocation(layout, Gravity.BOTTOM,0,0);
//
//            }
//        });
//
//        popUpView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                popupWindow.dismiss();
//                return true;
//            }
//        });
//
//        return popUpView;
//
//    }
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
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        EditText emailPopup = popupView.findViewById(R.id.emailinput);
        EditText senhaPopup = popupView.findViewById(R.id.senhainput);

        String emailString = emailPopup.getText().toString();
        String senhaString = senhaPopup.getText().toString();



        auth = ConfigFirebase.getFirebaseAuth();
        auth.signInWithEmailAndPassword(emailString, senhaString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(PaginaInicialActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    String msg = "";
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
}