<%-- 
    Document   : mostrarEstudantes
    Created on : Jul 23, 2024, 10:15:00 AM
    Author     : User
--%>

<%@page import="br.edu.ifpe.recife.model.repository.EstudanteRepository"%>
<%@page import="br.edu.ifpe.recife.model.entities.Estudante"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="minhaTag" uri="/WEB-INF/tlds/cabuetaTags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <title>Mostrar Estudantes</title>
    </head>
    <body>

        <%
            List<Estudante> estudantes = EstudanteRepository.readAll();
        %>

        <h1>Estudantes Cadastrados</h1>
        <minhaTag:carrega entidade="estudante" var="estudantes" escopo="pagina"/>
        ${pageScope.estudantes.size()}
        
        <a href="index.jsp" class="btn btn-primary ">home</a>

        <button class="btn btn-primary"
                data-bs-toggle="modal" data-bs-target="#modalCadastro">Cadastrar</button>

        <%
            String mensagem = (String) session.getAttribute("msg");

            if (mensagem != null) {
        %>
        <small><%= mensagem%></small> 
        <%

                session.removeAttribute("msg");
            }

        %>

        <table class="table">
            <tr><td>Código</td><td>Nome</td><td>Email</td><td>Ano de Entrada</td><td>Operações</td></tr>

            <% for (Estudante e : estudantes) { %>

            <tr>
                <td><%= e.getCodigoEstudante() %></td>
                <td><%= e.getNomeEstudante() %></td>
                <td><%= e.getEmailEstudante() %></td>
                <td><%= e.getAnoEntradaEstudante() %></td>
                <td>
                    <a href="EstudanteControllerJSP?codigoEstudante=<%= e.getCodigoEstudante() %>">Detalhar</a> 
                    <a href="cadastroEstudante.jsp?codigoEstudante=<%= e.getCodigoEstudante() %>">Alterar</a> 
                    <a href="EstudanteControllerJSP?codigoEstudante=<%= e.getCodigoEstudante() %>&op=delete">Deletar</a>
                </td>
            </tr>

            <% } %>
        </table>

        <div class="modal fade" id="modalCadastro" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Cadastrar Estudante</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <%@include file="cadastroEstudante.jsp"%>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
