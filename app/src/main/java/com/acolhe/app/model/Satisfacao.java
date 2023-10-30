package com.acolhe.app.model;

import androidx.annotation.NonNull;

public enum Satisfacao {
    MUITO_TRISTE("Muito triste"),
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
