<%-- 
    Document   : detalheProfessor
    Created on : Jul 23, 2024, 8:43:06 PM
    Author     : User
--%>

<%@page import="br.edu.ifpe.recife.model.entities.Professor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <title>Detalhe Professor</title>
    </head>
    <body>
        <%
        Professor p = (Professor) request.getAttribute("professor");
        %>
        
        <div class="container my-5">
            <h1>Detalhe do Professor</h1>
            <a href="mostrarProfessores.jsp" class="btn btn-secondary mb-3">Mostrar Professores</a>

            <table class="table table-striped">
                <tr>
                    <td>Código</td>
                    <td><%= p.getCodigoProfessor() %></td>
                </tr>
                <tr>
                    <td>Nome</td>
                    <td><%= p.getNomeProfessor() %></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><%= p.getEmailProfessor() %></td>
                </tr>
            </table>
        </div>
    </body>
</html>
