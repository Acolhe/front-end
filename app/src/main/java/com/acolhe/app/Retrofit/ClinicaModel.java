package com.acolhe.app.Retrofit;

import java.util.ArrayList;

public class ClinicaModel {
    ArrayList<data> clinicas;

    public ArrayList<data> getClinicas() {
        return clinicas;
    }

    public void setClinicas(ArrayList<data> clinicas) {
        this.clinicas = clinicas;
    }

    public class data{
        int codClinica;
        String nmClinica, email, telefone, descricao, imagem, bairro, cidade, nmEstado, sgEstado;
        Boolean patrocinada;

        public int getCodClinica() {
            return codClinica;
        }

        public void setCodClinica(int codClinica) {
            this.codClinica = codClinica;
        }

        public String getNmClinica() {
            return nmClinica;
        }

        public void setNmClinica(String nmClinica) {
            this.nmClinica = nmClinica;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public String getImagem() {
            return imagem;
        }

        public void setImagem(String imagem) {
            this.imagem = imagem;
        }

        public String getBairro() {
            return bairro;
        }

        public void setBairro(String bairro) {
            this.bairro = bairro;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public String getNmEstado() {
            return nmEstado;
        }

        public void setNmEstado(String nmEstado) {
            this.nmEstado = nmEstado;
        }

        public String getSgEstado() {
            return sgEstado;
        }

        public void setSgEstado(String sgEstado) {
            this.sgEstado = sgEstado;
        }

        public Boolean getPatrocinada() {
            return patrocinada;
        }

        public void setPatrocinada(Boolean patrocinada) {
            this.patrocinada = patrocinada;
        }
    }
}
