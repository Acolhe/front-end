package com.acolhe.app.model;

public class Humor {
    private int codUsuario;
    private int codhumor;
    private String data;
    private int nivelSatisfacao;
    private String comentario;

    public Humor() {
    }

    public Humor(String data, Integer nivelSatisfacao, String comentario) {
        this.data = data;
        this.nivelSatisfacao = nivelSatisfacao;
        this.comentario = comentario;
    }

    public Humor(Integer codUsuario, String data, Integer nivelSatisfacao, String comentario) {
        this.codUsuario = codUsuario;
        this.data = data;
        this.nivelSatisfacao = nivelSatisfacao;
        this.comentario = comentario;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Integer getCodhumor() {
        return codhumor;
    }

    public void setCodhumor(Integer codhumor) {
        this.codhumor = codhumor;
    }

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
}
