<%-- 
    Document   : cadastroEstudante
    Created on : Jul 23, 2024, 9:09:41 PM
    Author     : User
--%>

<%@page import="br.edu.ifpe.recife.model.entities.Estudante"%>
<%@page import="br.edu.ifpe.recife.model.repository.EstudanteRepository"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <title>Cadastro de Estudante</title>
    </head>
    <body>
        <h1>${(param['codigoEstudante'] eq null)?'Cadastro':'Alterar Dados'} de Estudante</h1>
        ${(param.codigoEstudante eq null)?'':'<a href="mostrarEstudantes.jsp">Mostrar Estudantes</a></br>'}
        
        <a href="index.jsp" class="btn btn-primary">home</a>
        
        <% 
            if (request.getParameter("codigoEstudante") != null) {
                Estudante e = EstudanteRepository
                    .read(Integer.parseInt(request.getParameter("codigoEstudante")));
            
                request.setAttribute("estudante", e);
            }
        %>
        
        <form method="post" action="EstudanteControllerJSP">
            
            ${(requestScope.estudante ne null)?'<input type="hidden" name="op" value="1"/>':''}
            
            <table class="table">
                <tr>
                    <td>Código</td>
                    <td><input class="form-control" type="${(requestScope.estudante ne null)?'hidden':'text'}" name="codigoEstudante" ${(requestScope.estudante ne null)?'value="'.concat(requestScope.estudante.codigoEstudante).concat('"'):''}/>
                        ${(requestScope.estudante ne null)?requestScope.estudante.codigoEstudante:''}</td>
                </tr>
                <tr>
                    <td>Nome</td>
                    <td><input class="form-control" type="text" name="nomeEstudante" value="${(requestScope.estudante ne null)?requestScope.estudante.nomeEstudante:''}"/></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input class="form-control" type="text" name="emailEstudante" value="${(requestScope.estudante ne null)?requestScope.estudante.emailEstudante:''}"/></td>
                </tr>
                <tr>
                    <td>Ano de Entrada</td>
                    <td><input class="form-control" type="number" name="anoEntradaEstudante" value="${(requestScope.estudante ne null)?requestScope.estudante.anoEntradaEstudante:''}"/></td>
                </tr>
                ${(requestScope.estudante eq null)?'<tr><td>Senha</td><td><input type="password" class="form-control" name="senhaEstudante"/></td></tr>':''}
                ${(requestScope.estudante eq null)?'<tr><td>Confirmação Senha</td><td><input type="password" class="form-control" name="confirm"/></td></tr>':''}
            </table>
            <button type="submit" class="btn btn-primary">${(param['codigoEstudante'] eq null)?'Cadastrar':'Alterar'}</button>
        </form>
    </body>
</html>
