<%-- 
    Document   : mostrarProfessores
    Created on : Jul 23, 2024, 8:35:44 PM
    Author     : User
--%>

<%@page import="br.edu.ifpe.recife.model.repository.ProfessorRepository"%>
<%@page import="br.edu.ifpe.recife.model.entities.Professor"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="minhaTag" uri="/WEB-INF/tlds/cabuetaTags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
        <title>Professores Cadastrados</title>
    </head>
    <body>
        
        <%
        List<Professor> professores = ProfessorRepository.readAll();
        %>

    <h1>Professores Cadastrados</h1>
    <minhaTag:carrega entidade="professor" var="professores" escopo="pagina"/>
    ${pageScope.professores.size()}
    <a href="index.jsp" class="btn btn-primary ">home</a>
    <h2>${cookie['mC'].value}</h2>

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

    <table class="table">
        <tr>
            <td>Código</td>
            <td>Nome</td>
            <td>Email</td>
            <td>Operações</td>
        </tr>

        <% for (Professor p : professores) { %>
        <tr>
            <td><%= p.getCodigoProfessor() %></td>
            <td><%= p.getNomeProfessor() %></td>
            <td><%= p.getEmailProfessor() %></td>
            <td>
                <a href="ProfessorControllerJSP?codigo=<%= p.getCodigoProfessor() %>">Detalhar</a> 
                <a href="cadastroProfessor.jsp?codigo=<%= p.getCodigoProfessor() %>">Alterar</a> 
                <a href="ProfessorControllerJSP?codigo=<%= p.getCodigoProfessor() %>&op=delete">Deletar</a>
            </td>
        </tr>
        <% } %>
    </table>

    <div class="modal fade" id="modalCadastro" tabindex="-1" aria-labelledby="modalCadastroLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="modalCadastroLabel">Cadastrar Professor</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <jsp:include page="cadastroProfessor.jsp"/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>
