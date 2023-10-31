package com.acolhe.app.Retrofit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HumorDiario {


    private String data;

    private Integer nivelSatisfacao;
    private String comentario;


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getNivelSatisfacao() {
        return nivelSatisfacao;
    }

    public void setNivelSatisfacao(Integer nivelSatisfacao) {
        this.nivelSatisfacao = nivelSatisfacao;
    }

    public String getComentario() {
        return comentario;
    }



    public void setComentario(String comentario) {
        this.comentario = comentario;
    }



    public HumorDiario(String data, Integer nivelSatisfacao, String comentario) {
        this.data = data;
        this.nivelSatisfacao = nivelSatisfacao;
        this.comentario = comentario;
    }

    public HumorDiario(){

    }


}
