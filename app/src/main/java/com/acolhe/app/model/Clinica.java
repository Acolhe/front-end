package com.acolhe.app.model;

public class Clinica {
    private String nome;
    private String email;
    private String telefone;
    private String descricao;
    private String imagem;
    private String bairro;
    private String cidade;
    private String estado;
    private String uf;
    private boolean patrocinada;

    public Clinica(String nome, String email, String telefone, String descricao, String imagem, String bairro, String cidade, String estado, String uf, boolean patrocinada) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.descricao = descricao;
        this.imagem = imagem;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.uf = uf;
        this.patrocinada = patrocinada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public boolean isPatrocinada() {
        return patrocinada;
    }

    public void setPatrocinada(boolean patrocinada) {
        this.patrocinada = patrocinada;
    }
}