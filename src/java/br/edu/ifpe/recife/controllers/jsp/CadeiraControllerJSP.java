/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers.jsp;

import br.edu.ifpe.recife.model.entities.Cadeira;
import br.edu.ifpe.recife.model.entities.Estudante;
import br.edu.ifpe.recife.model.repository.CadeiraRepository;
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
@WebServlet(name = "CadeiraControllerJSP", urlPatterns = {"/CadeiraControllerJSP"})
public class CadeiraControllerJSP extends HttpServlet {

    

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
        
         String codigoParam = request.getParameter("codigo");
        String op = request.getParameter("op");

        if (codigoParam != null) {
            int codigo = Integer.parseInt(codigoParam);

            if ("delete".equals(op)) {
                CadeiraRepository.delete(codigo);
                HttpSession session = request.getSession();
                session.setAttribute("msg", "Cadeira deletada com sucesso!");
                response.sendRedirect("mostrarCadeiras.jsp");
                return;
            }

            Cadeira c = CadeiraRepository.read(codigo);
            request.setAttribute("cadeira", c);
            getServletContext().getRequestDispatcher("/detalheCadeira.jsp").forward(request, response);
            return;
        }

        // Mostrar todas as cadeiras
        getServletContext().getRequestDispatcher("/mostrarCadeiras.jsp").forward(request, response);
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

        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        int anoEntrada = Integer.parseInt(request.getParameter("anoEntrada"));
        String confirmaSenha = request.getParameter("senha2");
        String senha0 = request.getParameter("senha0");
        
        
        HttpSession session = request.getSession();
        
        Estudante e0 = EstudanteRepository.read(codigo);
        if (senha0 != null && !senha0.equals(e0.getSenhaEstudante())) {
            session.setAttribute("msg", "Erro: Senha atual incorreta.");
            response.sendRedirect("estPerfil.jsp");
            return;
        }
        
        if(confirmaSenha != null && !senha.equalsIgnoreCase(confirmaSenha)){
            session.setAttribute("msg", "Procedimento não realizado: Senhas diferentes.");
            String url = request.getParameter("perfil") == null? "estLogin.jsp" : "estPerfil.jsp";
            response.sendRedirect(url);
            return;
        }

        Estudante e = new Estudante();
        e.setCodigoEstudante(codigo);
        e.setNomeEstudante(nome);
        e.setEmailEstudante(email);
        e.setSenhaEstudante(senha);
        e.setAnoEntradaEstudante(anoEntrada);

        /* Sessao e um local para armazena atributos sessao de memoria tempo de amazenamento armazenado em webxml*/
        
        if(request.getParameter("perfil") != null){
            EstudanteRepository.update(e);
            session.setAttribute("msg", "Estudante alterado com sucesso!");
            response.sendRedirect("estPerfil.jsp");
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
