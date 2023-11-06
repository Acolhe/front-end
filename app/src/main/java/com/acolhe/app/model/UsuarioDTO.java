package com.acolhe.app.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class UsuarioDTO implements Serializable {
    private static Integer id;
    private static String nome;
    private static int saldo;
    private static int ofensiva;
    private static String email;
    private static int codSkin;
    private static LocalDateTime dataCadastro;
    private static LocalDateTime ultimoAcesso;
    private static boolean premium;
    private static List<HumorDTO> historicoHumor = new ArrayList<>();

    public UsuarioDTO(Usuario user) {
        UsuarioDTO.id = user.getId();
        UsuarioDTO.nome = user.getNome();
        UsuarioDTO.saldo = user.getSaldo();
        UsuarioDTO.ofensiva = user.getDiasConsecutivos();
        UsuarioDTO.email = user.getEmail();
        UsuarioDTO.codSkin = 0;
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        UsuarioDTO.dataCadastro = LocalDateTime.parse(user.getData_cadastro(), formatter2);
        UsuarioDTO.ultimoAcesso = LocalDateTime.parse(user.getDataultimologin(), formatter2);
        UsuarioDTO.premium = user.getPremium();
        if(user.getHistoricoHumor() != null) {
            user.getHistoricoHumor().forEach(UsuarioDTO::addHistorico);
        }
    }

    private static void addHistorico(Humor humor) {
        UsuarioDTO.historicoHumor.add(new HumorDTO(humor));
    }

    public static Integer getId(){
        return UsuarioDTO.id;
    }
    public static void setId(Integer id) {
        UsuarioDTO.id = id;
    }
    public static String getNome() {
        return UsuarioDTO.nome;
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

    public static LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public static boolean isPremium() {
        return premium;
    }

    public static void setPremium(boolean premium) {
        UsuarioDTO.premium = premium;
    }

    public static List<HumorDTO> getHistoricoHumor() {
        return historicoHumor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDTO usuarioDTO = (UsuarioDTO) o;
        return saldo == usuarioDTO.saldo && ofensiva == usuarioDTO.ofensiva && codSkin == usuarioDTO.codSkin && premium == usuarioDTO.premium && Objects.equals(nome, usuarioDTO.nome) && Objects.equals(email, usuarioDTO.email) && Objects.equals(dataCadastro, usuarioDTO.dataCadastro) && Objects.equals(ultimoAcesso, usuarioDTO.ultimoAcesso) && Objects.equals(historicoHumor, usuarioDTO.historicoHumor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, saldo, ofensiva, email, codSkin, dataCadastro, ultimoAcesso, premium, historicoHumor);
    }
}
