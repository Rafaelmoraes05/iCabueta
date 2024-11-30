/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers.access;

import br.edu.ifpe.recife.model.entities.Denuncia;
import br.edu.ifpe.recife.model.entities.Estudante;
import br.edu.ifpe.recife.model.repository.CadeiraRepository;
import br.edu.ifpe.recife.model.repository.DenunciaRepository;
import br.edu.ifpe.recife.model.repository.EstudanteRepository;
import br.edu.ifpe.recife.model.repository.MetodoFilaRepository;
import br.edu.ifpe.recife.model.repository.ProfessorRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "EstudanteAccessController", urlPatterns = {"/EstudanteAccessController"})
public class EstudanteAccessController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");

        if (op.equals("logout")) {
            request.getSession().invalidate();
            response.sendRedirect("loginEstudante.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("denuncia") != null) {
            String[] alunosDenunciados = request.getParameterValues("alunosDenunciados");
            List<Estudante> denunciados = new ArrayList<>();
            List<Integer> denunciadosInt = Arrays.stream(alunosDenunciados)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            for (int d : denunciadosInt) {
                denunciados.add(EstudanteRepository.read(d));
            }

            int codigoDenuncia = Integer.parseInt(request.getParameter("codigo"));
            int codigoProfessor = Integer.parseInt(request.getParameter("professor"));
            int codigoCadeira = Integer.parseInt(request.getParameter("cadeira"));
            int codigoMetodoFila = Integer.parseInt(request.getParameter("metodosFila"));
            String descricao = request.getParameter("descricaoDoOcorrido");
            String turno = request.getParameter("turno");
            Estudante denunciante = (Estudante) request.getSession().getAttribute("eLogado");
            Denuncia denuncia = new Denuncia(codigoDenuncia,
                    System.currentTimeMillis(),
                    turno,
                    descricao,
                    denunciados,
                    denunciante,
                    ProfessorRepository.read(codigoProfessor),
                    CadeiraRepository.read(codigoCadeira),
                    MetodoFilaRepository.read(codigoMetodoFila));

            DenunciaRepository.create(denuncia);
            request.getSession().setAttribute("msg", "Sua denúncia "
                    + "foi criada com sucesso!");

            response.sendRedirect(request.getContextPath() + "/indexEstudante.jsp");
            return;
        }

        String emailEstudante = request.getParameter("emailLogin");
        String senhaEstudante = request.getParameter("senhaLogin");

        Estudante eLogado = EstudanteRepository.fazerLogin(emailEstudante, senhaEstudante);

        if (eLogado == null) {
            request.getSession().setAttribute("msg", "Aluno não encontrado");
            response.sendRedirect("loginEstudante.jsp");
            return;
        }
        request.getSession().setAttribute("eLogado", eLogado);
        response.sendRedirect("indexEstudante.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
