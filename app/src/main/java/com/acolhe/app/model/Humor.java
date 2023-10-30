package com.acolhe.app.model;

import java.time.LocalDate;

public class Humor {
    private LocalDate dataAvaliacao;
    private Satisfacao nivelSatisfacao;

    public Humor(LocalDate dataAvaliacao, Satisfacao nivelSatisfacao) {
        this.dataAvaliacao = dataAvaliacao;
        this.nivelSatisfacao = nivelSatisfacao;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public Satisfacao getNivelSatisfacao() {
        return nivelSatisfacao;
    }

    public void setNivelSatisfacao(Satisfacao nivelSatisfacao) {
        this.nivelSatisfacao = nivelSatisfacao;
    }
}
