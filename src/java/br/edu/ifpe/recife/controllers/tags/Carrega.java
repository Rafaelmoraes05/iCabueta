/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers.tags;

import br.edu.ifpe.recife.model.entities.Cadeira;
import br.edu.ifpe.recife.model.entities.Estudante;
import br.edu.ifpe.recife.model.entities.Professor;
import br.edu.ifpe.recife.model.entities.MetodoFila;
import br.edu.ifpe.recife.model.repository.CadeiraRepository;
import br.edu.ifpe.recife.model.repository.EstudanteRepository;
import br.edu.ifpe.recife.model.repository.ProfessorRepository;
import br.edu.ifpe.recife.model.repository.MetodoFilaRepository;
import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Carrega extends SimpleTagSupport {

    private String escopo;
    private String var;
    private String typ;
    private String cod;

    @Override
    public void doTag() throws JspException, IOException {
        int scope = PageContext.PAGE_SCOPE;

        if ("pagina".equalsIgnoreCase(this.escopo)) {;;
            scope = PageContext.PAGE_SCOPE;
        } else if ("requisicao".equalsIgnoreCase(this.escopo)) {
            scope = PageContext.REQUEST_SCOPE;
        } else if ("sessao".equalsIgnoreCase(this.escopo)) {
            scope = PageContext.SESSION_SCOPE;
        } else if ("aplicacao".equalsIgnoreCase(this.escopo)) {
            scope = PageContext.APPLICATION_SCOPE;
        }
        
        if (cod == null || cod.isEmpty()) {
            if (this.typ.equalsIgnoreCase("cadeira")) {
                List<Cadeira> cadeiras = CadeiraRepository.readAll();
                getJspContext().setAttribute(this.var, cadeiras, scope);
            } else if (this.typ.equalsIgnoreCase("professor")) {
                List<Professor> professores = ProfessorRepository.readAll();
                getJspContext().setAttribute(this.var, professores, scope);
            } else if (this.typ.equalsIgnoreCase("metodofila")) {
                List<MetodoFila> metodos = MetodoFilaRepository.readAll();
                getJspContext().setAttribute(this.var, metodos, scope);
            }else if (this.typ.equalsIgnoreCase("estudante")) {
                List<Estudante> estudantes = EstudanteRepository.readAll();
                getJspContext().setAttribute(this.var, estudantes, scope);
            }
        } else {
            int codigo = Integer.parseInt(cod);
            if (this.typ.equalsIgnoreCase("cadeira")) {
                Cadeira c = CadeiraRepository.read(codigo);
                getJspContext().setAttribute(this.var, c, scope);
            } else if (this.typ.equalsIgnoreCase("professor")) {
                Professor p = ProfessorRepository.read(codigo);
                getJspContext().setAttribute(this.var, p, scope);
            } else if (this.typ.equalsIgnoreCase("metodofila")) {
                MetodoFila m = MetodoFilaRepository.read(codigo);
                getJspContext().setAttribute(this.var, m, scope);
            } else if (this.typ.equalsIgnoreCase("estudante")) {
                Estudante e = EstudanteRepository.read(codigo);
                getJspContext().setAttribute(this.var, e, scope);
            }
        }
    }

    public void setVar(String var) {
        this.var = var;
    }

    public void setTyp(String tipo) {
        this.typ = tipo;
    }

    public void setEscopo(String escopo) {
        this.escopo = escopo;
    }

    public void setCod(String codigo) {
        this.cod = codigo;
    }

}
