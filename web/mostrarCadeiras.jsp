<%-- 
    Document   : mostrarCadeiras
    Created on : Jul 23, 2024, 9:56:27 PM
    Author     : User
--%>


<%@page import="br.edu.ifpe.recife.model.repository.CadeiraRepository"%>
<%@page import="br.edu.ifpe.recife.model.entities.Cadeira"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="minhaTag" uri="/WEB-INF/tlds/cabuetaTags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <title>Cadeiras Cadastradas</title>
    </head>
    <body>

        <h1>Cadeiras Cadastradas</h1>
        <a href="index.jsp" class="btn btn-primary">home</a>

        <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalCadastro">Cadastrar</button>

        <%
            String mensagem = (String) session.getAttribute("msg");

            if (mensagem != null) {
        %>
        <small><%= mensagem %></small>
        <%
                session.removeAttribute("msg");
            }
        %>

        <minhaTag:carrega entidade="cadeira" var="cadeiras" escopo="pagina"/>
        ${pageScope.cadeiras.size()}

        <table class="table">
            <tr><td>Código</td><td>Nome</td><td>Ano</td><td>Semestre</td><td>Descrição</td><td>Operações</td></tr>

             <% 
               List<Cadeira> cadeirasList = CadeiraRepository.readAll();
               if (cadeirasList != null) {
                   for (Cadeira c : cadeirasList) { %>
            <tr>
                <td><%= c.getCodigo() %></td>
                <td><%= c.getNome() %></td>
                <td><%= c.getAno() %></td>
                <td><%= c.getSemestre() %></td>
                <td><%= c.getDescricao() %></td>
                <td>
                    <a href="CadeiraControllerJSP?codigo=<%= c.getCodigo() %>">Detalhar</a> 
                    <a href="cadastroCadeira.jsp?codigo=<%= c.getCodigo() %>">Alterar</a> 
                    <a href="CadeiraControllerJSP?codigo=<%= c.getCodigo() %>&op=delete">Deletar</a>
                </td>
            </tr>
            <%   }
               } else { %>
            <tr>
                <td colspan="6">Nenhuma cadeira cadastrada.</td>
            </tr>
            <% } %>
        </table>

        <div class="modal fade" id="modalCadastro" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Cadastro de Cadeira</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <%@include file="cadastroCadeira.jsp"%>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
