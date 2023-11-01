package com.acolhe.app.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Missao {
    private String nome;
    private String key;
    private String descricao;
    private int valor;
    private List<Integer> usuarios = new ArrayList<>();

    public Missao(String nome, String key, String descricao, int valor) {
        this.nome = nome;
        this.key = key;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Missao(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public List<Integer> getUsuarios() {
        return Collections.unmodifiableList(usuarios);
    }

    public void add(Integer usr) {
        usuarios.add(usr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Missao missao = (Missao) o;
        return valor == missao.valor && Objects.equals(nome, missao.nome) && Objects.equals(descricao, missao.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, valor);
    }
}

