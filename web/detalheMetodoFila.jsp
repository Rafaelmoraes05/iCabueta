<%-- 
    Document   : detalheMetodoFila
    Created on : Jul 23, 2024, 11:03:21 PM
    Author     : User
--%>

<%@page import="br.edu.ifpe.recife.model.entities.MetodoFila"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalhe do Método Fila</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>

    </head>
    <body>
        <%
        MetodoFila mf = (MetodoFila) request.getAttribute("metodoFila");
        %>
        
        <div class="container my-5">
            <h1>Detalhe do Método Fila</h1>
            <a href="mostrarMetodosFila.jsp" class="btn btn-secondary mb-3">Mostrar Métodos Fila</a>

            <table class="table table-striped">
                <tr>
                    <td>Código</td>
                    <td>${requestScope.metodoFila.codigoFila}</td>
                </tr>
                <tr>
                    <td>Descrição Curta</td>
                    <td>${requestScope.metodoFila.descricaoCurta}</td>
                </tr>
                <tr>
                    <td>Descrição Longa</td>
                    <td>${requestScope.metodoFila.descricaoLonga}</td>
                </tr>
            </table>
        </div>
    </body>
</html>
