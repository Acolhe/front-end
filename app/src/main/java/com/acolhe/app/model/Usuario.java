package com.acolhe.app.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Usuario implements Serializable {
    private static Integer id;
    private static String nome;
    private static int saldo;
    private static int ofensiva;
    private static String email;
    private static int codSkin;
    private static LocalDateTime dataCadastro;
    private static LocalDate ultimoAcesso;
    private static boolean premium;
    private static List<Humor> historicoHumor;

    public Usuario(Integer id, String nome, int saldo, int ofensiva, String email, int codSkin, LocalDateTime dataCadastro, LocalDate ultimoAcesso, boolean premium, List<Humor> historicoHumor) {
        Usuario.id = id;
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

    public static Integer getId(){
        return Usuario.id;
    }
    public static void setId(Integer id) {
        Usuario.id = id;
    }
    public static String getNome() {
        return Usuario.nome;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return saldo == usuario.saldo && ofensiva == usuario.ofensiva && codSkin == usuario.codSkin && premium == usuario.premium && Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(dataCadastro, usuario.dataCadastro) && Objects.equals(ultimoAcesso, usuario.ultimoAcesso) && Objects.equals(historicoHumor, usuario.historicoHumor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, saldo, ofensiva, email, codSkin, dataCadastro, ultimoAcesso, premium, historicoHumor);
    }
}
