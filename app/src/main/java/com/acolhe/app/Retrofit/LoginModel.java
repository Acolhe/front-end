package com.acolhe.app.Retrofit;

public class LoginModel {

    String dataultimologin;
    int saldo;
    String email, senha, data_cadastro;
    Boolean premium;
    int id;
    int diasConsecutivos;
    Integer codSkinPrincipal;
    String dataCadastro, nome;

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

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiasConsecutivos() {
        return diasConsecutivos;
    }

    public void setDiasConsecutivos(int diasConsecutivos) {
        this.diasConsecutivos = diasConsecutivos;
    }

    public Integer getCodSkinPrincipal() {
        return codSkinPrincipal;
    }

    public void setCodSkinPrincipal(Integer codSkinPrincipal) {
        this.codSkinPrincipal = codSkinPrincipal;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "LoginModel{" +
                "dataultimologin='" + dataultimologin + '\'' +
                ", saldo=" + saldo +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", data_cadastro='" + data_cadastro + '\'' +
                ", premium=" + premium +
                ", id=" + id +
                ", diasConsecutivos=" + diasConsecutivos +
                ", codSkinPrincipal=" + codSkinPrincipal +
                ", dataCadastro='" + dataCadastro + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
