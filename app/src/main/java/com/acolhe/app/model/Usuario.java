package com.acolhe.app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Usuario {
    private String nome;
    private int saldo;
    private int ofensiva;
    private String email;
    private int codSkin;
    private LocalDateTime dataCadastro;
    private LocalDate ultimoAcesso;
    private boolean premium;
    private ArrayList<Humor> historicoHumor;

    public Usuario(String nome, int saldo, int ofensiva, String email, int codSkin, LocalDateTime dataCadastro, LocalDate ultimoAcesso, boolean premium, ArrayList<Humor> historicoHumor) {
        this.nome = nome;
        this.saldo = saldo;
        this.ofensiva = ofensiva;
        this.email = email;
        this.codSkin = codSkin;
        this.dataCadastro = dataCadastro;
        this.ultimoAcesso = ultimoAcesso;
        this.premium = premium;
        this.historicoHumor = historicoHumor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getOfensiva() {
        return ofensiva;
    }

    public void setOfensiva(int ofensiva) {
        this.ofensiva = ofensiva;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodSkin() {
        return codSkin;
    }

    public void setCodSkin(int codSkin) {
        this.codSkin = codSkin;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDate ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public ArrayList<Humor> getHistoricoHumor() {
        return historicoHumor;
    }

    public void setHistoricoHumor(ArrayList<Humor> historicoHumor) {
        this.historicoHumor = historicoHumor;
    }
}
