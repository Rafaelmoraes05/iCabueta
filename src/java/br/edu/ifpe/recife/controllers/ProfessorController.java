/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.entities.Professor;
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
 * @author Rafael
 */
@WebServlet(name = "ProfessorController", urlPatterns = {"/ProfessorController"})
public class ProfessorController extends HttpServlet {

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
//            out.println("<title>Servlet ProfessorController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ProfessorController at " + request.getContextPath() + "</h1>");
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

                    Professor professorEdit = ProfessorRepository.read(codigo);

                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Editar Professor</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Editar Professor</h1>");
                        out.println("<a href='ProfessorController'>Ver professores cadastrados</a><br/>");
                        out.println("<form method='post' action='ProfessorController'>");
                        out.println("Código: <input type='hidden' name='codigo' value='" + professorEdit.getCodigoProfessor() + "'/>" + professorEdit.getCodigoProfessor() + "<br/>");
                        out.println("Nome: <input type='text' name='nome' value='" + professorEdit.getNomeProfessor() + "'/><br/>");
                        out.println("Email: <input type='text' name='email' value='" + professorEdit.getEmailProfessor() + "'/><br/>");
                        out.println("Senha: <input type='password' name='senha' value='" + professorEdit.getSenhaProfessor() + "'/><br/>");
                        out.println("<input type='submit' value='Editar'/>");
                        out.println("</form>");
                        out.println("</body>");
                        out.println("</html>");

                        return;
                    }
                }

                if (request.getParameter("opcao").equals("delete")) {

                    ProfessorRepository.delete(codigo);

                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Deletar Professor</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<a href='ProfessorController'>Professores Cadastrados</a>");
                        out.println("<h1>O professor foi removido com sucesso!</h1>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }
            }

            Professor professorDetalhes = ProfessorRepository.read(codigo);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Detalhes do Professor</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Detalhes do Professor</h1>");
                out.println("<a href='ProfessorController'>Ver Professores Cadastrados</a><br/>");
                out.println("<h5>Código: " + professorDetalhes.getCodigoProfessor() + "</h5>");
                out.println("<h5>Nome: " + professorDetalhes.getNomeProfessor() + "</h5>");
                out.println("<h5>Email: " + professorDetalhes.getEmailProfessor() + "</h5>");
                out.println("</body>");
                out.println("</html>");
            }

            return;
        }

        List<Professor> professores = ProfessorRepository.readAll();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Professores Cadastrados</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Professores Cadastrados</h1>");
            out.println("<a href='index.html'>Voltar à Página Inicial</a><br/>");
            out.println("<table border=\"2\">");
            out.println("<tr><th>Código</th><th>Nome</th><th>Email</th><th>Operações</th></tr>");

            for (Professor professor : professores) {
                out.println("<tr>");
                out.println("<td>" + professor.getCodigoProfessor() + "</td>");
                out.println("<td>" + professor.getNomeProfessor() + "</td>");
                out.println("<td>" + professor.getEmailProfessor() + "</td>");
                out.println("<td><a href='ProfessorController?codigo=" + professor.getCodigoProfessor() + "'>Detalhar</a>"
                        + " | <a href='ProfessorController?codigo=" + professor.getCodigoProfessor() + "&opcao=edit'>Editar</a>"
                        + " | <a href='ProfessorController?codigo=" + professor.getCodigoProfessor() + "&opcao=delete'>Deletar</a></td>");
                out.println("</tr>");
                }

            out.println("</table>");
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

        Professor professor = new Professor(codigo, nome, email, senha);
        
        professor.setCodigoProfessor(codigo);
        professor.setNomeProfessor(nome);
        professor.setEmailProfessor(email);
        professor.setSenhaProfessor(senha);
        
        Professor professorCadastrado = ProfessorRepository.read(codigo);
        professor.setCodigoProfessor(professorCadastrado.getCodigoProfessor());

        ProfessorRepository.update(professor);

        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastro de Professor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href='ProfessorController'>Professores Cadastrados</a>");
            out.println("<h1>O Professor "+ nome + " foi cadastrado com sucesso!</h1>");
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
