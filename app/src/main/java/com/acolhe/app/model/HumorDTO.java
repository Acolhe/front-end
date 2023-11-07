package com.acolhe.app.model;

import com.acolhe.acolhe_api.R;

import java.time.LocalDate;

public class HumorDTO {
    private LocalDate data;
    private Satisfacao nivelSatisfacao;
    private String comentario;
    private Integer imagem;

    public HumorDTO(Humor humor) {
        this.data = LocalDate.parse(humor.getData());
        setNivelSatisfacao(humor.getNivelSatisfacao());
        this.comentario = humor.getComentario();
    }

    public HumorDTO() {
    }

    public Integer getImagem() {
        return imagem;
    }

    public void setImagem(Integer imagem) {
        this.imagem = imagem;
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
                setImagem(R.drawable.nadabem);
                break;
            case 2:
                this.nivelSatisfacao = Satisfacao.TRISTE;
                setImagem(R.drawable.triste);
                break;
            case 3:
                this.nivelSatisfacao = Satisfacao.NORMAL;
                setImagem(R.drawable.normal);
                break;
            case 4:
                this.nivelSatisfacao = Satisfacao.BEM;
                setImagem(R.drawable.bem);
                break;
            case 5:
                this.nivelSatisfacao = Satisfacao.MUITO_BEM;
                setImagem(R.drawable.muitobem);
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
