package com.acolhe.app.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public enum Satisfacao implements Serializable {
    MUITO_TRISTE("Nada bem"),
    TRISTE("Triste"),
    NORMAL("Normal"),
    BEM("Bem"),
    MUITO_BEM("Muito bem");

    private final String prettyName;
    Satisfacao(String prettyName) {
        this.prettyName = prettyName;
    }

    @NonNull
    @Override
    public String toString() {
        return prettyName;
    }
}
