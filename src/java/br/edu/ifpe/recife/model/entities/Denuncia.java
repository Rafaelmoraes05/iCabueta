/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//import java.lang.String;

/**
 *
 * @author Rafael
 */
public class Denuncia {
    
    private int codigo;
    private long data;
    private String turno;
    private String descricaoDoOcorrido;
    private List<Estudante> denunciados;
    private Estudante denunciante;

    
    private Professor professor;
    private Cadeira cadeira;
    private MetodoFila metodoFila;
    
    

    public Denuncia(int codigo, 
            long data, 
            String turno, 
            String descricaoDoOcorrido, 
            List<Estudante> denunciados,
            Estudante denunciante,
            Professor professor, 
            Cadeira cadeira, 
            MetodoFila metodoFila) {
        this.codigo = codigo;
        this.data = data;
        this.turno = turno;
        this.descricaoDoOcorrido = descricaoDoOcorrido;
        this.denunciados = denunciados;
        this.denunciante = denunciante;
        this.professor = professor;
        this.cadeira = cadeira;
        this.metodoFila = metodoFila;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDescricaoDoOcorrido() {
        return descricaoDoOcorrido;
    }

    public void setDescricaoDoOcorrido(String descricaoDoOcorrido) {
        this.descricaoDoOcorrido = descricaoDoOcorrido;
    }

    public List<Estudante> getDenunciados() {
        return denunciados;
    }

    public void setDenunciados(List<Estudante> estudantes) {
        this.denunciados = estudantes;
    }
    
    public Estudante getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(Estudante denunciante) {
        this.denunciante = denunciante;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Cadeira getCadeira() {
        return cadeira;
    }

    public void setCadeira(Cadeira cadeira) {
        this.cadeira = cadeira;
    }

    public MetodoFila getMetodoFila() {
        return metodoFila;
    }

    public void setMetodoFila(MetodoFila metodoFila) {
        this.metodoFila = metodoFila;
    }
    
    public static String formatDate(long dateLong){
        Date date = new Date(dateLong);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(date);
    }
}