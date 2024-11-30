/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.entities.MetodoFila;
import br.edu.ifpe.recife.model.repository.MetodoFilaRepository;
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
@WebServlet(name = "MetodoFilaController", urlPatterns = {"/MetodoFilaController"})
public class MetodoFilaController extends HttpServlet {

    

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

                    MetodoFila metodoFilaEdit = MetodoFilaRepository.read(codigo);

                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Editar Método Fila</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Editar Método Fila</h1>");
                        out.println("<a href='MetodoFilaController'>Ver métodos fila cadastrados</a><br/>");
                        out.println("<form method='post' action='MetodoFilaController'>");
                        out.println("Código: <input type='hidden' name='codigo' value='" + metodoFilaEdit.getCodigoFila() + "'/>" + metodoFilaEdit.getCodigoFila() + "<br/>");
                        out.println("Descrição Curta: <input type='text' name='descricaoCurta' value='" + metodoFilaEdit.getDescricaoCurta()+ "'/><br/>");
                        out.println("Descrição Longa: <textarea name='descricaoLonga'>" + metodoFilaEdit.getDescricaoLonga() + "</textarea><br/>");
                        out.println("<input type='submit' value='Editar'/>");
                        out.println("</form>");
                        out.println("</body>");
                        out.println("</html>");

                        return;
                    }
                }

                if (request.getParameter("opcao").equals("delete")) {

                    MetodoFilaRepository.delete(codigo);

                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Deletar Método Fila</title>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<a href='MetodoFilaController'>Métodos fila cadastrados</a>");
                        out.println("<h1>O método fila foi removido com sucesso</h1>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }
            }

            MetodoFila metodoFilaTable = MetodoFilaRepository.read(codigo);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Detalhes do Método Fila</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Método Fila cadastrado no sistema</h1>");
                out.println("<a href='MetodoFilaController'>Ver métodos fila cadastrados</a><br/>");
                out.println("<h5>Código:" + metodoFilaTable.getCodigoFila() + "</h5>");
                out.println("<h5>Descrição Curta:" + metodoFilaTable.getDescricaoCurta() + "</h5>");
                out.println("<h5>Descrição Longa:" + metodoFilaTable.getDescricaoLonga() + "</h5>");
                out.println("</body>");
                out.println("</html>");
            }

            return;
        }
        
        List<MetodoFila> metodosFila = MetodoFilaRepository.readAll();

    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet CadastroController</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Métodos fila cadastrados no sistema</h1>");
        out.println("<a href='index.html'>Home</a><br/>");
        out.println("<table border=\"2\">");
        out.println("<tr><th>Código</th><th>Descrição Curta</th><th>Descrição Longa</th><th>Operações</th></tr>");

        for (MetodoFila metodoFila : metodosFila) {
            out.println("<tr>");
            out.println("<td>" + metodoFila.getCodigoFila() + "</td>");
            out.println("<td>" + metodoFila.getDescricaoCurta() + "</td>");
            out.println("<td>" + metodoFila.getDescricaoLonga() + "</td>");
            out.println("<td><a href='MetodoFilaController?codigo=" + metodoFila.getCodigoFila() + "'>Detalhar</a>"
                        + " <a href='MetodoFilaController?codigo=" + metodoFila.getCodigoFila() + "&opcao=edit'>Editar</a>"
                        + " <a href='MetodoFilaController?codigo=" + metodoFila.getCodigoFila() + "&opcao=delete'>Deletar</a></td>");
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
    String descricaoCurta = request.getParameter("descricaoCurta");
    String descricaoLonga = request.getParameter("descricaoLonga");

    MetodoFila metodoFila = new MetodoFila();
    
    metodoFila.setCodigoFila(codigo);
    metodoFila.setDescricaoCurta(descricaoCurta);
    metodoFila.setDescricaoLonga(descricaoLonga);

    MetodoFila metodoFilaCadastrado = MetodoFilaRepository.read(codigo);
    metodoFila.setCodigoFila(metodoFilaCadastrado.getCodigoFila());
    
    MetodoFilaRepository.update(metodoFila);

    response.setContentType("text/html;charset=UTF-8");

    try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet CadastroMetodoFilaServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<a href='MetodoFilaController'>Métodos de Fila Cadastrados</a>");
        out.println("<h1>O Método de Fila foi alterado com sucesso</h1>");
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
