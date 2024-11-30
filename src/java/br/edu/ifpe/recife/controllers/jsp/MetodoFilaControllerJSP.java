/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers.jsp;

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
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@WebServlet(name = "MetodoFilaControllerJSP", urlPatterns = {"/MetodoFilaControllerJSP"})
public class MetodoFilaControllerJSP extends HttpServlet {


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
                MetodoFilaRepository.delete(codigo);
                HttpSession session = request.getSession();
                session.setAttribute("msg", "Método Fila deletado com sucesso!");
                response.sendRedirect("mostrarMetodosFila.jsp");
                return;
            }
            
            MetodoFila metodoFila = MetodoFilaRepository.read(codigo);
            request.setAttribute("metodoFila", metodoFila);
            getServletContext().getRequestDispatcher("/detalheMetodoFila.jsp")
                    .forward(request, response);
            return;
        }
        
        List<MetodoFila> metodosFila = MetodoFilaRepository.readAll();
        request.setAttribute("metodosFila", metodosFila);
        getServletContext().getRequestDispatcher("/mostrarMetodosFila.jsp")
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
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String descricaoCurta = request.getParameter("descricaoCurta");
        String descricaoLonga = request.getParameter("descricaoLonga");

        MetodoFila metodoFila = new MetodoFila();
        metodoFila.setCodigoFila(codigo);
        metodoFila.setDescricaoCurta(descricaoCurta);
        metodoFila.setDescricaoLonga(descricaoLonga);
        
        HttpSession session = request.getSession();
        
        if (op == null) {
            MetodoFilaRepository.create(metodoFila);
            session.setAttribute("msg", "Método de Fila cadastrado com sucesso!");
        } else {
            MetodoFilaRepository.update(metodoFila);
            session.setAttribute("msg", "Método de Fila alterado com sucesso!");
        }
        
        response.sendRedirect("mostrarMetodosFila.jsp");
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
