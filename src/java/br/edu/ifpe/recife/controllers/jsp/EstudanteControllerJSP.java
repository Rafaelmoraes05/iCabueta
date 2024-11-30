/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers.jsp;

import br.edu.ifpe.recife.model.entities.Estudante;
import br.edu.ifpe.recife.model.repository.EstudanteRepository;
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
@WebServlet(name = "EstudanteControllerJSP", urlPatterns = {"/EstudanteControllerJSP"})
public class EstudanteControllerJSP extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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

        int codigoEstudante = Integer.parseInt(request.getParameter("codigoEstudante"));
        String op = request.getParameter("op");

        if (op != null) {
            EstudanteRepository.delete(codigoEstudante);
            request.getSession().setAttribute("msg", "Estudante deletado com sucesso!");
            response.sendRedirect("mostrarEstudantes.jsp");
            return;
        }

        Estudante e = EstudanteRepository.read(codigoEstudante);
        request.setAttribute("estudante", e);
        getServletContext().getRequestDispatcher("/detalheEstudante.jsp").forward(request, response);
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

        int codigoEstudante = Integer.parseInt(request.getParameter("codigo"));
        String nomeEstudante = request.getParameter("nome");
        String emailEstudante = request.getParameter("email");
        String senhaEstudante = request.getParameter("senha");
        int anoEntradaEstudante = Integer.parseInt(request.getParameter("anoEntrada"));
        String confirmaSenha = request.getParameter("senha2");
        String senha0 = request.getParameter("senha0");
        
        
        HttpSession session = request.getSession();
        
        Estudante e0 = EstudanteRepository.read(codigoEstudante);
        if (senha0 != null && !senha0.equals(e0.getSenhaEstudante())) {
            session.setAttribute("msg", "Erro: Senha atual incorreta.");
            response.sendRedirect("perfilEstudante.jsp");
            return;
        }
        
        if(confirmaSenha != null && !senhaEstudante.equalsIgnoreCase(confirmaSenha)){
            session.setAttribute("msg", "Procedimento não realizado: Senhas diferentes.");
            String url = request.getParameter("perfil") == null? "loginEstudante.jsp" : "perfilEstudante.jsp";
            response.sendRedirect(url);
            return;
        }

        Estudante e = new Estudante();
        e.setCodigoEstudante(codigoEstudante);
        e.setNomeEstudante(nomeEstudante);
        e.setEmailEstudante(emailEstudante);
        e.setSenhaEstudante(senhaEstudante);
        e.setAnoEntradaEstudante(anoEntradaEstudante);

        /* Sessao e um local para armazena atributos sessao de memoria tempo de amazenamento armazenado em webxml*/
        
        if(request.getParameter("perfil") != null){
            EstudanteRepository.update(e);
            session.setAttribute("msg", "Estudante alterado com sucesso!");
            response.sendRedirect("perfilEstudante.jsp");
            return;
        }
        if (op == null) {
            EstudanteRepository.create(e);
            session.setAttribute("msg", "Estudante " + e.getNomeEstudante() + " Foi cadastrado com sucesso");
        } else {
            EstudanteRepository.update(e);
            session.setAttribute("msg", "Estudante alterado com sucesso!");
        }
        /*Redirecionar o fluxo da pagina para jsp*/
        response.sendRedirect("loginEstudante.jsp");
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
