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
public class Professor {
    
    private int codigoProfessor;
    private String nomeProfessor;
    private String emailProfessor;
    private String senhaProfessor;

    public Professor(int codigoProfessor, String nomeProfessor, String emailProfessor, String senhaProfessor) {
        this.codigoProfessor = codigoProfessor;
        this.nomeProfessor = nomeProfessor;
        this.emailProfessor = emailProfessor;
        this.senhaProfessor = senhaProfessor;
    }
    public Professor(){}

    public int getCodigoProfessor() {
        return codigoProfessor;
    }

    public void setCodigoProfessor(int codigoProfessor) {
        this.codigoProfessor = codigoProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getEmailProfessor() {
        return emailProfessor;
    }

    public void setEmailProfessor(String emailProfessor) {
        this.emailProfessor = emailProfessor;
    }

    public String getSenhaProfessor() {
        return senhaProfessor;
    }

    public void setSenhaProfessor(String senhaProfessor) {
        this.senhaProfessor = senhaProfessor;
    }
    
}
