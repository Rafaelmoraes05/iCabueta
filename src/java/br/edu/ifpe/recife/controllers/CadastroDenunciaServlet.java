///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.edu.ifpe.recife.controllers;
//
//import br.edu.ifpe.recife.model.entities.Denuncia;
//import br.edu.ifpe.recife.model.repository.DenunciaRepository;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Date;
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
//@WebServlet(name = "CadastroDenunciaServlet", urlPatterns = {"/CadastroDenunciaServlet"})
//public class CadastroDenunciaServlet extends HttpServlet {
//
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CadastroDenunciaServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CadastroDenunciaServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//    
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int codigo = Integer.parseInt(request.getParameter("codigo"));
//        Date data = new Date(); // Se necessário, substitua esta linha pela obtenção correta da data
//        String turno = request.getParameter("turno");
//        String descricao = request.getParameter("descricao");
//
//        Denuncia denuncia = new Denuncia();
//        denuncia.setCodigoDenuncia(codigo);
//        denuncia.setDataDenucia(data);
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
