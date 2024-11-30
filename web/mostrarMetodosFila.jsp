<%-- 
    Document   : mostrarMetodosFila
    Created on : Jul 23, 2024, 10:00:00 AM
    Author     : User
--%>

<%@page import="br.edu.ifpe.recife.model.repository.MetodoFilaRepository"%>
<%@page import="br.edu.ifpe.recife.model.entities.MetodoFila"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="minhaTag" uri="/WEB-INF/tlds/cabuetaTags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>

        <title>Mostrar Métodos Fila</title>
    </head>
    <body>

        <%
            List<MetodoFila> metodosFila = MetodoFilaRepository.readAll();
        %>

        <h1>Métodos Fila Cadastrados</h1>
        <minhaTag:carrega entidade="metodofila" var="mfilas" escopo="pagina"/>
        ${pageScope.mfilas.size()}
        <a href="index.jsp" class="btn btn-primary">home</a>
        <h2>${cookie['mF'].value}</h2>

        <button class="btn btn-primary"
                data-bs-toggle="modal" data-bs-target="#modalCadastro">Cadastrar</button>

        <%
            String mensagem = (String) session.getAttribute("msg");

            if (mensagem != null) {
        %>
        <small><%= mensagem %></small> 
        <%

                session.removeAttribute("msg");
            }

        %>

        <table class="table">
            <tr>
                <td>Código</td>
                <td>Descrição Curta</td>
                <td>Descrição Longa</td>
                <td>Operações</td>
            </tr>

            <% for (MetodoFila m : metodosFila) { %>
            <tr>
                <td><%= m.getCodigoFila() %></td>
                <td><%= m.getDescricaoCurta() %></td>
                <td><%= m.getDescricaoLonga() %></td>
                <td>
                    <a href="MetodoFilaControllerJSP?codigo=<%= m.getCodigoFila() %>">detalhar</a> 
                    <a href="cadastroMetodoFila.jsp?codigo=<%= m.getCodigoFila() %>">alterar</a> 
                    <a href="MetodoFilaControllerJSP?codigo=<%= m.getCodigoFila() %>&op=delete">deletar</a>
                </td>
            </tr>
            <% } %>
        </table>

        <div class="modal fade" id="modalCadastro" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <%@include file="cadastroMetodoFila.jsp" %>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>