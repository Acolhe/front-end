package com.acolhe.app.model;

import java.util.List;

public class Usuario {

    private int codUsuario;
    private String nomeUsuario;
    private int saldo;
    private boolean premium;
    private String senha;
    private String dataultimologin;
    private String email;
    private int diasconsecutivos;
    private String datacadastro;
    private List<Humor> humores;

    public Usuario(int codUsuario, String nomeUsuario, int saldo, boolean premium, String senha, String dataultimologin, String email, int diasconsecutivos, String datacadastro) {
        this.codUsuario = codUsuario;
        this.nomeUsuario = nomeUsuario;
        this.saldo = saldo;
        this.premium = premium;
        this.senha = senha;
        this.dataultimologin = dataultimologin;
        this.email = email;
        this.diasconsecutivos = diasconsecutivos;
        this.datacadastro = datacadastro;
    }

    public Usuario() {
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataultimologin() {
        return dataultimologin;
    }

    public void setDataultimologin(String dataultimologin) {
        this.dataultimologin = dataultimologin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDiasconsecutivos() {
        return diasconsecutivos;
    }

    public void setDiasconsecutivos(int diasconsecutivos) {
        this.diasconsecutivos = diasconsecutivos;
    }

    public String getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(String datacadastro) {
        this.datacadastro = datacadastro;
    }

    public List<Humor> getHumores() {
        return humores;
    }

    public void setHumores(List<Humor> humores) {
        this.humores = humores;
    }
}
