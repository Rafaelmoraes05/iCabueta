/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.entities;

/**
 *
 * @author Rafael
 */
public class MetodoFila {
    
    private int codigoFila;
    private String descricaoCurta;
    private String descricaoLonga;



    public int getCodigoFila() {
        return codigoFila;
    }

    public void setCodigoFila(int codigoFila) {
        this.codigoFila = codigoFila;
    }

    public String getDescricaoCurta() {
        return descricaoCurta;
    }

    public void setDescricaoCurta(String descricaoCurta) {
        this.descricaoCurta = descricaoCurta;
    }

    public String getDescricaoLonga() {
        return descricaoLonga;
    }

    public void setDescricaoLonga(String descricaoLonga) {
        this.descricaoLonga = descricaoLonga;
    }

}
