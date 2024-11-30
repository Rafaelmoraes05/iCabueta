<%-- 
    Document   : cadastroProfessor
    Created on : Jul 23, 2024, 8:32:08 PM
    Author     : User
--%>

<%@page import="br.edu.ifpe.recife.model.entities.Professor"%>
<%@page import="br.edu.ifpe.recife.model.repository.ProfessorRepository"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <title>Cadastro Professor</title>
    </head>
    <body>
        <h1>${(param['codigo'] == null) ? 'Cadastro' : 'Alterar Dados'} de Professor</h1>
    ${(param.codigo == null) ? '' : '<a href="mostrarProfessores.jsp">Mostrar Professores</a></br>'}
    
    <a href="index.jsp" class="btn btn-primary">home</a>
    
    <%
        if(request.getParameter("codigo") != null) {
            Professor p = ProfessorRepository.read(Integer.parseInt(request.getParameter("codigo")));
            request.setAttribute("professor", p);
        }
    %>
    
    <form method="post" action="ProfessorControllerJSP">
        ${(requestScope.professor != null) ? '<input type="hidden" name="op" value="1"/>' : ''}
        
        <table class="table">
            <tr>
                <td>Código</td>
                <td>
                    <input class="form-control" type="${(requestScope.professor != null) ? 'hidden' : 'text'}" name="codigo" ${(requestScope.professor != null) ? 'value="'.concat(requestScope.professor.codigoProfessor.toString()).concat('"') : ''}/>
                    ${(requestScope.professor != null) ? requestScope.professor.codigoProfessor : ''}
                </td>
            </tr>
            <tr>
                <td>Nome</td>
                <td><input class="form-control" type="text" name="nome" value="${(requestScope.professor != null) ? requestScope.professor.nomeProfessor : ''}"/></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input class="form-control" type="text" name="email" value="${(requestScope.professor != null) ? requestScope.professor.emailProfessor : ''}"/></td>
            </tr>
            ${(requestScope.professor == null) ? '<tr><td>Senha</td><td><input type="password" class="form-control" name="senha"/></td></tr>' : ''}
        </table>
        <button type="submit" class="btn btn-primary">${(param['codigo'] == null) ? 'Cadastrar' : 'Alterar'}</button>
    </form>
    </body>
</html>
