package com.acolhe.app.model;

public class Clinica {
    private int codClinica;
    private String nmClinica;
    private String email;
    private String telefone;
    private String descricao;
    private String imagem;
    private String bairro;
    private String cidade;
    private String nmEstado;
    private String sgEstado;
    private boolean patrocinada;
    private Integer nivelSatisfacao;

    public Clinica() {
    }

    public Clinica(int codClinica, String nmClinica, String email, String telefone, String descricao, String imagem, String bairro, String cidade, String nmEstado, String sgEstado, boolean patrocinada, Integer nivelSatisfacao) {
        this.codClinica = codClinica;
        this.nmClinica = nmClinica;
        this.email = email;
        this.telefone = telefone;
        this.descricao = descricao;
        this.imagem = imagem;
        this.bairro = bairro;
        this.cidade = cidade;
        this.nmEstado = nmEstado;
        this.sgEstado = sgEstado;
        this.patrocinada = patrocinada;
        this.nivelSatisfacao = nivelSatisfacao;
    }

    public int getCodClinica() {
        return codClinica;
    }

    public void setCodClinica(int codClinica) {
        this.codClinica = codClinica;
    }

    public String getNmClinica() {
        return nmClinica;
    }

    public void setNmClinica(String nmClinica) {
        this.nmClinica = nmClinica;
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

    public String getNmEstado() {
        return nmEstado;
    }

    public void setNmEstado(String nmEstado) {
        this.nmEstado = nmEstado;
    }

    public String getSgEstado() {
        return sgEstado;
    }

    public void setSgEstado(String sgEstado) {
        this.sgEstado = sgEstado;
    }

    public boolean isPatrocinada() {
        return patrocinada;
    }

    public void setPatrocinada(boolean patrocinada) {
        this.patrocinada = patrocinada;
    }

    public Integer getNivelSatisfacao() {
        return nivelSatisfacao;
    }

    public void setNivelSatisfacao(Integer nivelSatisfacao) {
        this.nivelSatisfacao = nivelSatisfacao;
    }
}