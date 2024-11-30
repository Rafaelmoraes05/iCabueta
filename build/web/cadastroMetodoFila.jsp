<%-- 
    Document   : cadastroMetodoFila
    Created on : Jul 23, 2024, 22:00:00 PM
--%>

<%@page import="br.edu.ifpe.recife.model.entities.MetodoFila"%>
<%@page import="br.edu.ifpe.recife.model.repository.MetodoFilaRepository"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <title>${(param['codigo'] eq null)?'Cadastro':'Alterar Dados'} de Método Fila</title>
    </head>
    <body>
        
        <h1>${(param['codigo'] eq null)?'Cadastro':'Alterar Dados'} de Método Fila</h1>
        ${(param.codigo eq null)?'':'<a href="mostrarMetodosFila.jsp">Mostrar Métodos Fila</a></br>'}
        
        <a href="index.jsp" class="btn btn-primary">home</a>
        
        <% 
            if (request.getParameter("codigo") != null) {
                MetodoFila m = MetodoFilaRepository.read(Integer.parseInt(request.getParameter("codigo")));
                request.setAttribute("metodoFila", m);
            }
        %>
        
        <form method="post" action="MetodoFilaControllerJSP">
            ${(requestScope.metodoFila ne null) ? '<input type="hidden" name="op" value="1"/>' : ''}
            
            <table class="table">
                <tr>
                    <td>Código</td>
                    <td>
                        <input class="form-control" type="${(requestScope.metodoFila ne null) ? 'hidden' : 'text'}" name="codigo" ${(requestScope.metodoFila ne null) ? 'value="'.concat(requestScope.metodoFila.codigoFila).concat('"') : ''}/>
                        ${(requestScope.metodoFila ne null) ? requestScope.metodoFila.codigoFila : ''}
                    </td>
                </tr>
                <tr>
                    <td>Descrição Curta</td>
                    <td><input class="form-control" type="text" name="descricaoCurta" value="${(requestScope.metodoFila ne null) ? requestScope.metodoFila.descricaoCurta : ''}"/></td>
                </tr>
                <tr>
                    <td>Descrição Longa</td>
                    <td><textarea class="form-control" name="descricaoLonga">${(requestScope.metodoFila ne null) ? requestScope.metodoFila.descricaoLonga : ''}</textarea></td>
                </tr>
            </table>
            <button type="submit" class="btn btn-primary">${(param['codigo'] eq null) ? 'Cadastrar' : 'Alterar'}</button>
        </form>
    </body>
</html>

