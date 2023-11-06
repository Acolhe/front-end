package com.acolhe.app.model;

import com.acolhe.acolhe_api.R;

import java.time.LocalDate;

public class HumorDTO {
    private LocalDate data;
    private Satisfacao nivelSatisfacao;
    private String comentario;
    private Integer res;

    public HumorDTO(Humor humor) {
        this.data = LocalDate.parse(humor.getData());
        setNivelSatisfacao(humor.getNivelSatisfacao());
        this.comentario = humor.getComentario();
    }

    public HumorDTO() {
    }

    public Integer getRes() {
        return res;
    }

    public void setRes(Integer res) {
        this.res = res;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Satisfacao getNivelSatisfacao() {
        return nivelSatisfacao;
    }

    public void setNivelSatisfacao(Integer nivelSatisfacao) {
        switch (nivelSatisfacao){
            case 1:
                this.nivelSatisfacao = Satisfacao.MUITO_TRISTE;
                setRes(R.drawable.nadabem);
                break;
            case 2:
                this.nivelSatisfacao = Satisfacao.TRISTE;
                setRes(R.drawable.triste);
                break;
            case 3:
                this.nivelSatisfacao = Satisfacao.NORMAL;
                setRes(R.drawable.normal);
                break;
            case 4:
                this.nivelSatisfacao = Satisfacao.BEM;
                setRes(R.drawable.bem);
                break;
            case 5:
                this.nivelSatisfacao = Satisfacao.MUITO_BEM;
                setRes(R.drawable.muitobem);
                break;
        }
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
