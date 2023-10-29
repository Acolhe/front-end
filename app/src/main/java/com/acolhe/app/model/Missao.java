package com.acolhe.app.model;

public class Missao {
    private String nome;
    private String descricao;
    private int valor;
    private boolean isConcluida;

    public Missao() {
    }

    public Missao(String nome, String descricao, int valor, boolean isConcluida) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.isConcluida = isConcluida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isConcluida() {
        return isConcluida;
    }

    public void setConcluida(boolean concluida) {
        isConcluida = concluida;
    }
}

