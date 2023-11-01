package com.acolhe.app.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Usuario implements Serializable {
    private static String nome;
    private static int saldo;
    private static int ofensiva;
    private static String email;
    private static int codSkin;
    private static LocalDateTime dataCadastro;
    private static LocalDate ultimoAcesso;
    private static boolean premium;
    private static List<Humor> historicoHumor;

    public Usuario(String nome, int saldo, int ofensiva, String email, int codSkin, LocalDateTime dataCadastro, LocalDate ultimoAcesso, boolean premium, List<Humor> historicoHumor) {
        Usuario.nome = nome;
        Usuario.saldo = saldo;
        Usuario.ofensiva = ofensiva;
        Usuario.email = email;
        Usuario.codSkin = codSkin;
        Usuario.dataCadastro = dataCadastro;
        Usuario.ultimoAcesso = ultimoAcesso;
        Usuario.premium = premium;
        Usuario.historicoHumor = historicoHumor;
    }

    public static String getNome() {
        return nome;
    }

    public static int getSaldo() {
        return saldo;
    }

    public static void updateSaldo(int novoSaldo) {
        saldo += novoSaldo;
    }

    public static int getOfensiva() {
        return ofensiva;
    }

    public static String getEmail() {
        return email;
    }

    public static int getCodSkin() {
        return codSkin;
    }

    public static LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public static LocalDate getUltimoAcesso() {
        return ultimoAcesso;
    }

    public static boolean isPremium() {
        return premium;
    }

    public static void setPremium(boolean premium) {
        Usuario.premium = premium;
    }

    public static List<Humor> getHistoricoHumor() {
        return historicoHumor;
    }

    public static void setHistoricoHumor(List<Humor> historicoHumor) {
        Usuario.historicoHumor = historicoHumor;
    }
}
