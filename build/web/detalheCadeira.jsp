<%-- 
    Document   : detalheCadeira
    Created on : Jul 23, 2024, 9:58:39 PM
    Author     : User
--%>

<%@page import="br.edu.ifpe.recife.model.entities.Cadeira"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <title>Detalhe da Cadeira</title>
    </head>
    <body>
        <%
        Cadeira c = (Cadeira) request.getAttribute("cadeira");
        %>
        
        <div class="container my-5">
            <h1>Detalhe da Cadeira</h1>
            <a href="mostrarCadeiras.jsp" class="btn btn-secondary mb-3">Mostrar Cadeiras</a>

            <table class="table table-striped">
                <tr>
                    <td>Código</td>
                    <td>${requestScope.cadeira.codigo}</td>
                </tr>
                <tr>
                    <td>Nome</td>
                    <td>${requestScope.cadeira.nome}</td>
                </tr>
                <tr>
                    <td>Ano</td>
                    <td>${requestScope.cadeira.ano}</td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td>${requestScope.cadeira.semestre}</td>
                </tr>
                <tr>
                    <td>Descrição</td>
                     <td>${requestScope.cadeira.descricao}</td>
                </tr>
            </table>
        </div>
    </body>
</html>
