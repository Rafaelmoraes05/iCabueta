<%-- 
    Document   : detalheEstudante
    Created on : Jul 23, 2024, 10:25:00 AM
    Author     : User
--%>

<%@page import="br.edu.ifpe.recife.model.entities.Estudante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalhe do Estudante</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
        Estudante e = (Estudante) request.getAttribute("estudante");
        %>
        
        <div class="container my-5">
            <h1>Detalhe do Estudante</h1>
            <a href="mostrarEstudantes.jsp" class="btn btn-secondary mb-3">Mostrar Estudantes</a>

            <table class="table table-striped">
                <tr>
                    <td>Código</td>
                    <td><%= e.getCodigoEstudante() %></td>
                </tr>
                <tr>
                    <td>Nome</td>
                    <td><%= e.getNomeEstudante() %></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><%= e.getEmailEstudante() %></td>
                </tr>
                <tr>
                    <td>Ano de Entrada</td>
                    <td><%= e.getAnoEntradaEstudante() %></td>
                </tr>
            </table>
        </div>
    </body>
</html>
