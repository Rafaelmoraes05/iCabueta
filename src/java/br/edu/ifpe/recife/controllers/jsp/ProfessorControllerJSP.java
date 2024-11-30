/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers.jsp;

import br.edu.ifpe.recife.model.entities.Professor;
import br.edu.ifpe.recife.model.repository.ProfessorRepository;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@WebServlet(name = "ProfessorControllerJSP", urlPatterns = {"/ProfessorControllerJSP"})
public class ProfessorControllerJSP extends HttpServlet {


    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String op = request.getParameter("op");
        
        if(op != null) {
            ProfessorRepository.delete(codigo);
            
            request.getSession().setAttribute("msg", "Professor deletado com sucesso!");
            
            response.sendRedirect("mostrarProfessores.jsp");
            
            return;
        }
        
        Professor p = ProfessorRepository.read(codigo);
        
        request.setAttribute("professor", p);
        
        getServletContext().getRequestDispatcher("/detalheProfessor.jsp")
                .forward(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String op = request.getParameter("op");

        int codigoProfessor = Integer.parseInt(request.getParameter("codigo"));
        String nomeProfessor = request.getParameter("nome");
        String emailProfessor = request.getParameter("email");
        String senhaProfessor = request.getParameter("senha");
        String confirmaSenha = request.getParameter("senha2");
        String senha0 = request.getParameter("senha0");
        Professor p = new Professor();
        p.setCodigoProfessor(codigoProfessor);
        p.setNomeProfessor(nomeProfessor);
        p.setEmailProfessor(emailProfessor);
        p.setSenhaProfessor(senhaProfessor);

        /* Sessao e um local para armazena atributos sessao de memoria tempo de amazenamento armazenado em webxml*/
        HttpSession session = request.getSession();
        
        Professor p0 = ProfessorRepository.read(codigoProfessor);
        if (senha0 != null && !senha0.equals(p0.getSenhaProfessor())) {
            session.setAttribute("msg", "Erro: Senha atual incorreta.");
            response.sendRedirect("perfilProfessor.jsp");
            return;
        }
        
        if(confirmaSenha != null && !senhaProfessor.equalsIgnoreCase(confirmaSenha)){
            session.setAttribute("msg", "Cadastro não realizado: Senhas diferentes.");
            String url = request.getParameter("perfil") == null? "loginProfessor.jsp" : "perfilProfessor.jsp";
            response.sendRedirect(url);
            return;
        }
        if(request.getParameter("perfil") != null){
            ProfessorRepository.update(p);
            session.setAttribute("msg", "Professor alterado com sucesso!");
            response.sendRedirect("perfilProfessor.jsp");
            return;
        }
        if (op == null) {
            ProfessorRepository.create(p);
            session.setAttribute("msg", "Professor " + p.getNomeProfessor() + " Foi cadastrado com sucesso");
        } else {
            ProfessorRepository.update(p);
            session.setAttribute("msg", "Professor alterado com sucesso!");
        }
        /*Redirecionar o fluxo da pagina para jsp*/
        response.sendRedirect("loginProfessor.jsp");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
