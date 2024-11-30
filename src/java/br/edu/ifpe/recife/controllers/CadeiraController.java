/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.entities.Cadeira;
import br.edu.ifpe.recife.model.repository.CadeiraRepository;
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
@WebServlet(name = "CadeiraController", urlPatterns = {"/CadeiraController"})
public class CadeiraController extends HttpServlet {

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
//            out.println("<title>Servlet CadeiraController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CadeiraController at " + request.getContextPath() + "</h1>");
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
        
//            List<Cadeira> cadeiras = CadeiraRepository.readAll();
            
            if (request.getParameter("codigo") != null) {
                
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                
                //If de formulário de alteração
                if (request.getParameter("opcao") != null) {
                    
                    if (request.getParameter("opcao").equals("edit")) {

                        Cadeira cEdit = CadeiraRepository.read(codigo);

                        response.setContentType("text/html;charset=UTF-8");
                        try (PrintWriter out = response.getWriter()) {
                            /* TODO output your page here. You may use following sample code. */
                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>Servlet CadeiraController</title>");
                            out.println("</head>");
                            out.println("<body>");
                            out.println("<h1>Editar Cadeira</h1>");
                            out.println("<a href='CadeiraController'>ver cadeiras cadastrados</a><br/>");
                            out.println("<form method='post' action='CadeiraController'>");
                            out.println("Codigo: <input type='hidden' name='codigo' value='" + cEdit.getCodigo() + "'/>" + cEdit.getCodigo() + "</br>");
                            out.println("Nome: <input type='text' name='nome' value='" + cEdit.getNome()+ "'/></br>");
                            out.println("Ano: <input type='number' name='ano' value='" + cEdit.getAno()+ "'/></br>");
                            out.println("Semestre: <input type='number' name='semestre' value='" + cEdit.getSemestre()+ "'/></br>");
                            out.println("Descrição: <textarea name='descricao'>" + cEdit.getDescricao() + "</textarea></br>");
                            out.println("<input type='submit' value='editar'/>");
                            out.println("</form>");
                            out.println("</body>");
                            out.println("</html>");

                            return;

                        }
                    }

                    //if Delete Cadeira
                    if (request.getParameter("opcao").equals("delete")) {

                        CadeiraRepository.delete(codigo);

                        response.setContentType("text/html;charset=UTF-8");
                        try (PrintWriter out = response.getWriter()) {
                            /* TODO output your page here. You may use following sample code. */
                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>Servlet CadeiraController</title>");            
                            out.println("</head>");
                            out.println("<body>");
                            out.println("<a href='CadeiraController'>Cadeiras Cadastradas</a>");
                            out.println("<h1>A Cadeira foi removida com sucesso!</h1>");
                            out.println("</body>");
                            out.println("</html>");
                        }

                    }

                }

                //Tabela com as Cadeiras cadastradas
                Cadeira cTab = CadeiraRepository.read(codigo);

                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        /* TODO output your page here. You may use following sample code. */
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet CadeiraController</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Cadeira cadastrada no sistema</h1>");
                        out.println("<a href='CadeiraController'>ver Cadeiras cadastradas</a><br/>");

                        out.println("<h5>Código:" + cTab.getCodigo() + "</h5>");
                        out.println("<h5>Nome:" + cTab.getNome() + "</h5>");
                        out.println("<h5>Ano:" + cTab.getAno() + "</h5>");
                        out.println("<h5>Semestre:" + cTab.getSemestre() + "</h5>");
                        out.println("<h5>Descrição:" + cTab.getDescricao() + "</h5>");

                        out.println("</tr>");

                        out.println("</body>");
                        out.println("</html>");

                }
            
                return;
            }
            List<Cadeira> cadeiras = CadeiraRepository.readAll();
        
            response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cadeiras cadastradas no sistema</h1>");
            out.println("<a href='index.html'>home</a><br/>");
            out.println("<table border=\"2\">");
            out.println("<tr><th>Código</th><th>"
                    + "Nome</th><th>Ano</th><th>operações</th>"
                    + "</tr>");

            for (Cadeira cTabela : cadeiras) {
                out.println("<tr>");
                out.println("<td>" + cTabela.getCodigo() + "</td>");
                out.println("<td>" + cTabela.getNome() + "</td>");
                out.println("<td>" + cTabela.getAno()+ "</td>");
                out.println("<td><a href='CadeiraController?codigo=" + cTabela.getCodigo() + "'>detalhar</a>"
                        + "     <a href='CadeiraController?codigo=" + cTabela.getCodigo() + "&opcao=edit'>editar</a>"
                        + " <a href='CadeiraController?codigo=" + cTabela.getCodigo() + "&opcao=delete'>deletar</a></td>");
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
        String descricao = request.getParameter("descricao");
        String nome = request.getParameter("nome");
        int ano = Integer.parseInt(request.getParameter("ano"));
        int semestre = Integer.parseInt(request.getParameter("semestre"));

        Cadeira cA = new Cadeira();

        cA.setCodigo(codigo);
        cA.setAno(ano);
        cA.setNome(nome);
        cA.setSemestre(semestre);
        cA.setDescricao(descricao);

        Cadeira cACadastrada = CadeiraRepository.read(codigo);
        cA.setCodigo(cACadastrada.getCodigo());

        CadeiraRepository.update(cA);

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroCadeiraServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href='CadeiraController'>Cadeiras Cadastradas</a>");
            out.println("<h1>A Cadeira " + nome + " foi alterado com sucesso</h1>");
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
