///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.edu.ifpe.recife.controllers;
//
//
//import br.edu.ifpe.recife.model.entities.Denuncia;
//import br.edu.ifpe.recife.model.repository.DenunciaRepository;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Date;
//import java.util.List;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author Rafael
// */
//@WebServlet(name = "DenunciaController", urlPatterns = {"/DenunciaController"})
//public class DenunciaController extends HttpServlet {
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//        if (request.getParameter("codigo") != null) {
//                
//            int codigo = Integer.parseInt(request.getParameter("codigo"));
//
//            if (request.getParameter("opcao") != null) {
//
//                if (request.getParameter("opcao").equals("edit")) {
//                    Denuncia denuncia = DenunciaRepository.read(codigo);
//
//                    response.setContentType("text/html;charset=UTF-8");
//                    try (PrintWriter out = response.getWriter()) {
//                        out.println("<!DOCTYPE html>");
//                        out.println("<html>");
//                        out.println("<head>");
//                        out.println("<title>Editar Denúncia</title>");
//                        out.println("</head>");
//                        out.println("<body>");
//                        out.println("<h1>Editar Denúncia</h1>");
//                        out.println("<form method='post' action='DenunciaController'>");
//                        out.println("Código: <input type='hidden' name='codigo' value='" + denuncia.getCodigoDenuncia() + "'/>" + denuncia.getCodigoDenuncia() + "</br>");
//                        out.println("Data: <input type='text' name='data' value='" + denuncia.getDataDenucia()+ "'/></br>");
//                        out.println("Turno: <input type='text' name='turno' value='" + denuncia.getTurnoDenuncia()+ "'/></br>");
//                        out.println("Descrição: <textarea name='descricao'>" + denuncia.getDescricaoDoOcorrido() + "</textarea></br>");
//                        out.println("<input type='submit' value='Editar'/>");
//                        out.println("</form>");
//                        out.println("</body>");
//                        out.println("</html>");
//
//                        return;
//                    }
//                }
//
//                if (request.getParameter("opcao").equals("delete")) {
//                    DenunciaRepository.delete(codigo);
//
//                    response.setContentType("text/html;charset=UTF-8");
//                    try (PrintWriter out = response.getWriter()) {
//                        out.println("<!DOCTYPE html>");
//                        out.println("<html>");
//                        out.println("<head>");
//                        out.println("<title>Denúncia Excluída</title>");            
//                        out.println("</head>");
//                        out.println("<body>");
//                        out.println("<a href='DenunciaController'>Denúncias Cadastradas</a>");
//                        out.println("<h1>Denúncia excluída com sucesso</h1>");
//                        out.println("</body>");
//                        out.println("</html>");
//                    }
//                }
//            }
//
//            Denuncia denuncia = DenunciaRepository.read(codigo);
//
//            response.setContentType("text/html;charset=UTF-8");
//            try (PrintWriter out = response.getWriter()) {
//                out.println("<!DOCTYPE html>");
//                out.println("<html>");
//                out.println("<head>");
//                out.println("<title>Detalhes da Denúncia</title>");
//                out.println("</head>");
//                out.println("<body>");
//                out.println("<h1>Detalhes da Denúncia</h1>");
//                out.println("<a href='DenunciaController'>Ver Denúncias Cadastradas</a><br/>");
//
//                out.println("<h5>Código: " + denuncia.getCodigoDenuncia() + "</h5>");
//                out.println("<h5>Data: " + denuncia.getDataDenucia() + "</h5>");
//                out.println("<h5>Turno: " + denuncia.getTurnoDenuncia() + "</h5>");
//                out.println("<h5>Descrição: " + denuncia.getDescricaoDoOcorrido() + "</h5>");
//
//                out.println("</body>");
//                out.println("</html>");
//            }
//            
//            return;
//        }
//        
//        List<Denuncia> denuncias = DenunciaRepository.readAll();
//        
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Denúncias Cadastradas</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Denúncias Cadastradas</h1>");
//            out.println("<a href='index.html'>Home</a><br/>");
//            out.println("<table border=\"2\">");
//            out.println("<tr><th>Código</th><th>Data</th><th>Turno</th><th>Descrição</th><th>Operações</th></tr>");
//
//            for (Denuncia denuncia : denuncias) {
//                out.println("<tr>");
//                out.println("<td>" + denuncia.getCodigoDenuncia() + "</td>");
//                out.println("<td>" + denuncia.getDataDenucia() + "</td>");
//                out.println("<td>" + denuncia.getTurnoDenuncia() + "</td>");
//                out.println("<td>" + denuncia.getDescricaoDoOcorrido() + "</td>");
//                out.println("<td><a href='DenunciaController?codigo=" + denuncia.getCodigoDenuncia() + "'>Detalhar</a>"
//                        + " | <a href='DenunciaController?codigo=" + denuncia.getCodigoDenuncia() + "&opcao=edit'>Editar</a>"
//                        + " | <a href='DenunciaController?codigo=" + denuncia.getCodigoDenuncia() + "&opcao=delete'>Excluir</a></td>");
//                out.println("</tr>");
//            }
//
//            out.println("</table>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int codigo = Integer.parseInt(request.getParameter("codigo"));
//        //Date data = (Date) request.getParameter("data");
//        String turno = request.getParameter("turno");
//        String descricao = request.getParameter("descricao");
//
//        Denuncia denuncia = new Denuncia();
//        denuncia.setCodigoDenuncia(codigo);
//        //denuncia.setDataDenucia(data);
//        denuncia.setTurnoDenuncia(turno);
//        denuncia.setDescricaoDoOcorrido(descricao);
//
//        // Aqui você pode chamar o método do seu repositório para adicionar a denúncia ao banco de dados
//        DenunciaRepository.create(denuncia);
//
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Denúncia Cadastrada</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<a href='DenunciaController'>Voltar para Denúncias Cadastradas</a>");
//            out.println("<h1>A denúncia foi cadastrada com sucesso</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
