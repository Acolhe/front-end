package com.acolhe.app.model;

import java.io.Serializable;

public class Respiracao implements Serializable {
    private String titulo;
    private String descricao;
    private String tecnica;

    private int arquivo;

    public Respiracao(String titulo, String descricao, String tecnica, int arquivo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tecnica = tecnica;
        this.arquivo = arquivo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public int getArquivo() {
        return arquivo;
    }

    public void setArquivo(int arquivo) {
        this.arquivo = arquivo;
    }
}
