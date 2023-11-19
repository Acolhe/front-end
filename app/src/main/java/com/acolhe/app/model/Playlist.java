package com.acolhe.app.model;

import java.util.ArrayList;

public class Playlist {
    private String titulo;
    private String descricao;
    private int imagem;
    private boolean isPremium;
    private ArrayList<Respiracao> respiracoes;

    public Playlist(String titulo, String descricao, int imagem, boolean isPremium, ArrayList<Respiracao> respiracoes) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.imagem = imagem;
        this.isPremium = isPremium;
        this.respiracoes = respiracoes;
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

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public ArrayList<Respiracao> getRespiracoes() {
        return respiracoes;
    }

    public void setRespiracoes(ArrayList<Respiracao> respiracoes) {
        this.respiracoes = respiracoes;
    }
}
