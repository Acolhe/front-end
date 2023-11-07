package com.acolhe.app.model;

import java.util.List;

public class Usuario {

    private int codUsuario;
    private String dataultimologin;
    private int saldo;
    private String email, senha, datacadastro;
    private Boolean premium;
    private int diasconsecutivos;
    private Integer codSkinPrincipal;
    private String nome;
    private List<Humor> humores;

    public Usuario(String dataultimologin, int saldo, String email, String senha, String datacadastro, Boolean premium, int codUsuario, int diasconsecutivos, Integer codSkinPrincipal, String dataCadastro, String nome, List<Humor> humores) {
        this.dataultimologin = dataultimologin;
        this.saldo = saldo;
        this.email = email;
        this.senha = senha;
        this.datacadastro = datacadastro;
        this.premium = premium;
        this.codUsuario = codUsuario;
        this.diasconsecutivos = diasconsecutivos;
        this.codSkinPrincipal = codSkinPrincipal;
        this.nome = nome;
        this.humores = humores;
    }

    public String getDataultimologin() {
        return dataultimologin;
    }

    public void setDataultimologin(String dataultimologin) {
        this.dataultimologin = dataultimologin;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(String datacadastro) {
        this.datacadastro = datacadastro;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public int getDiasconsecutivos() {
        return diasconsecutivos;
    }

    public void setDiasconsecutivos(int diasconsecutivos) {
        this.diasconsecutivos = diasconsecutivos;
    }

    public Integer getCodSkinPrincipal() {
        return codSkinPrincipal;
    }

    public void setCodSkinPrincipal(Integer codSkinPrincipal) {
        this.codSkinPrincipal = codSkinPrincipal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Humor> getHumores() {
        return humores;
    }

    public void setHumores(List<Humor> humores) {
        this.humores = humores;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "dataultimologin='" + dataultimologin + '\'' +
                ", saldo=" + saldo +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", data_cadastro='" + datacadastro + '\'' +
                ", premium=" + premium +
                ", id=" + codUsuario +
                ", diasConsecutivos=" + diasconsecutivos +
                ", codSkinPrincipal=" + codSkinPrincipal +
                ", nome='" + nome + '\'' +
                ", historicoHumor=" + humores +
                '}';
    }
}
