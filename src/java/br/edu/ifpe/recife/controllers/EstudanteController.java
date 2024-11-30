/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.entities.Estudante;
import br.edu.ifpe.recife.model.repository.EstudanteRepository;
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
 * @author Rafael
 */
@WebServlet(name = "EstudanteController", urlPatterns = {"/EstudanteController"})
public class EstudanteController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet EstudanteController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet EstudanteController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

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

        if (request.getParameter("codigo") != null) {

            int codigo = Integer.parseInt(request.getParameter("codigo"));

            if (request.getParameter("opcao") != null) {

                if (request.getParameter("opcao").equals("edit")) {

                    Estudante estudanteEdit = EstudanteRepository.read(codigo);

                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Editar Estudante</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Editar Estudante</h1>");
                        out.println("<a href='EstudanteController'>Ver estudantes cadastrados</a><br/>");
                        out.println("<form method='post' action='EstudanteController'>");
                        out.println("Código: <input type='hidden' name='codigo' value='" + estudanteEdit.getCodigoEstudante() + "'/>" + estudanteEdit.getCodigoEstudante() + "<br/>");
                        out.println("Nome: <input type='text' name='nome' value='" + estudanteEdit.getNomeEstudante() + "'/><br/>");
                        out.println("Email: <input type='text' name='email' value='" + estudanteEdit.getEmailEstudante() + "'/><br/>");
                        out.println("Senha: <input type='password' name='senha' value='" + estudanteEdit.getSenhaEstudante() + "'/><br/>");
                        out.println("Ano de Entrada: <input type='number' name='anoEntrada' value='" + estudanteEdit.getAnoEntradaEstudante() + "'/><br/>");
                        out.println("<input type='submit' value='Editar'/>");
                        out.println("</form>");
                        out.println("</body>");
                        out.println("</html>");

                        return;

                    }
                }

                if (request.getParameter("opcao").equals("delete")) {

                    EstudanteRepository.delete(codigo);

                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Deletar Estudante</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<a href='EstudanteController'>Estudantes Cadastrados</a>");
                        out.println("<h1>O estudante foi pra casa do...</h1>");
                        out.println("</body>");
                        out.println("</html>");
                    }

                }

            }

            Estudante estudanteDetalhes = EstudanteRepository.read(codigo);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Detalhes do Estudante</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Detalhes do Estudante</h1>");
                out.println("<a href='EstudanteController'>Ver Estudantes Cadastrados</a><br/>");
                out.println("<h5>Código: " + estudanteDetalhes.getCodigoEstudante() + "</h5>");
                out.println("<h5>Nome: " + estudanteDetalhes.getNomeEstudante() + "</h5>");
                out.println("<h5>Email: " + estudanteDetalhes.getEmailEstudante() + "</h5>");
                out.println("<h5>Ano de Entrada: " + estudanteDetalhes.getAnoEntradaEstudante() + "</h5>");
                out.println("</body>");
                out.println("</html>");
            }

            return;
        }

        List<Estudante> estudantes = EstudanteRepository.readAll();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Estudantes Cadastrados</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Estudantes Cadastrados no Sistema</h1>");
            out.println("<a href='index.html'>Home</a><br/>");
            out.println("<table border=\"2\">");
            out.println("<tr><th>Código</th><th>Nome</th><th>Ano de Entrada</th><th>Operações</th></tr>");

            for (Estudante estudante : estudantes) {
                out.println("<tr>");
                out.println("<td>" + estudante.getCodigoEstudante() + "</td>");
                out.println("<td>" + estudante.getNomeEstudante() + "</td>");
                out.println("<td>" + estudante.getAnoEntradaEstudante() + "</td>");
                out.println("<td><a href='EstudanteController?codigo=" + estudante.getCodigoEstudante() + "'>Detalhar</a>"
                        + " | <a href='EstudanteController?codigo=" + estudante.getCodigoEstudante() + "&opcao=edit'>Editar</a>"
                        + " | <a href='EstudanteController?codigo=" + estudante.getCodigoEstudante() + "&opcao=delete'>Deletar</a></td>");
                out.println("</tr>");
            }

            out.println("</body>");
            out.println("</html>");
        }
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
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        int anoEntrada = Integer.parseInt(request.getParameter("anoEntrada"));

        Estudante estudante = new Estudante(codigo, nome, email, senha, anoEntrada);

        EstudanteRepository.update(estudante);

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Atualização de Estudante</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href='EstudanteController'>Estudantes Cadastrados</a>");
            out.println("<h1>O estudante " + nome + " foi atualizado com sucesso!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
