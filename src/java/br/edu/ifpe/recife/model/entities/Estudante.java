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
public class Estudante {
    
    private int codigoEstudante;

    public Estudante(int codigoEstudante, String nomeEstudante, String emailEstudante, String senhaEstudante, int anoEntradaEstudante) {
        this.codigoEstudante = codigoEstudante;
        this.nomeEstudante = nomeEstudante;
        this.emailEstudante = emailEstudante;
        this.senhaEstudante = senhaEstudante;
        this.anoEntradaEstudante = anoEntradaEstudante;
    }
    private String nomeEstudante;
    private String emailEstudante;
    private String senhaEstudante;
    private int anoEntradaEstudante;
    
    public Estudante(){}
    
    
    //Getter e setters
    public int getCodigoEstudante() {
        return codigoEstudante;
    }

    public void setCodigoEstudante(int codigoEstudante) {
        this.codigoEstudante = codigoEstudante;
    }

    public String getNomeEstudante() {
        return nomeEstudante;
    }

    public void setNomeEstudante(String nomeEstudante) {
        this.nomeEstudante = nomeEstudante;
    }

    public String getEmailEstudante() {
        return emailEstudante;
    }

    public void setEmailEstudante(String emailEstudante) {
        this.emailEstudante = emailEstudante;
    }

    public String getSenhaEstudante() {
        return senhaEstudante;
    }

    public void setSenhaEstudante(String senhaEstudante) {
        this.senhaEstudante = senhaEstudante;
    }

    public int getAnoEntradaEstudante() {
        return anoEntradaEstudante;
    }

    public void setAnoEntradaEstudante(int anoEntradaEstudante) {
        this.anoEntradaEstudante = anoEntradaEstudante;
    }
    
    
}
