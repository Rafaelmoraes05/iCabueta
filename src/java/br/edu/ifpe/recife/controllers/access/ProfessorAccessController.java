/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers.access;

import br.edu.ifpe.recife.model.entities.Denuncia;
import br.edu.ifpe.recife.model.entities.Estudante;
import br.edu.ifpe.recife.model.entities.Professor;
import br.edu.ifpe.recife.model.repository.DenunciaRepository;
import br.edu.ifpe.recife.model.repository.EstudanteRepository;
import br.edu.ifpe.recife.model.repository.ProfessorRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "ProfessorAccessController", urlPatterns = {"/ProfessorAccessController"})
public class ProfessorAccessController extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        if (op.equals("logout")) {
            request.getSession().invalidate();
            response.sendRedirect("loginProfessor.jsp");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("pesquisaPorAluno") != null){
            String tipo = request.getParameter("tipo");
            int codigo = Integer.parseInt(request.getParameter("aluno"));
            Estudante e = EstudanteRepository.read(codigo);
            
            List<Denuncia> listResult =  tipo.equalsIgnoreCase("denunciado")? 
                    DenunciaRepository.filterByDenunciado(e):
                    DenunciaRepository.filterByDenunciante(e);
            request.getSession().setAttribute("listResult", listResult);
            response.sendRedirect("todasDenuncias.jsp");
            return;
        }
        String email = request.getParameter("emailLogin");
        String senha = request.getParameter("senhaLogin");

        Professor pLogado = ProfessorRepository.fazerLogin(email, senha);

        if (pLogado == null) {
            request.getSession().setAttribute("msg", "Professor não encontrado");
            response.sendRedirect("loginProfessor.jsp");
            return;
        }
        request.getSession().setAttribute("pLogado", pLogado);
        response.sendRedirect("indexProfessor.jsp");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}