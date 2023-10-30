package com.acolhe.app.model;

import com.acolhe.acolhe_api.R;

import java.io.Serializable;
import java.time.LocalDate;

public class Humor implements Serializable {
    private LocalDate dataAvaliacao;
    private Satisfacao nivelSatisfacao;
    private int res;

    public Humor(LocalDate dataAvaliacao, Satisfacao nivelSatisfacao) {
        this.dataAvaliacao = dataAvaliacao;
        this.nivelSatisfacao = nivelSatisfacao;
        setRes();
    }

    public int getRes() {
        return res;
    }

    private void setRes() {
        switch (this.nivelSatisfacao) {
            case MUITO_TRISTE:
                this.res = R.drawable.nadabem;
                break;
            case TRISTE:
                this.res = R.drawable.triste;
                break;
            case NORMAL:
                this.res = R.drawable.normal;
                break;
            case BEM:
                this.res = R.drawable.bem;
                break;
            case MUITO_BEM:
                this.res = R.drawable.muitobem;
                break;
        }
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
