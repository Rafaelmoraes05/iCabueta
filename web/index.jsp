<%-- 
    Document   : index
    Created on : Jul 23, 2024, 11:11:21 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <h1>Bem-vindo ao iCabueta</h1>
            
            <div class="list-group">
                <h3>Métodos de Fila</h3>
                <a href="cadastroMetodoFila.jsp" class="list-group-item list-group-item-action">Cadastrar Método Fila</a>
                <a href="mostrarMetodosFila.jsp" class="list-group-item list-group-item-action">Mostrar Métodos Fila</a>

                <h3>Estudante</h3>
                <a href="cadastroEstudante.jsp" class="list-group-item list-group-item-action">Cadastrar Estudante</a>
                <a href="mostrarEstudantes.jsp" class="list-group-item list-group-item-action">Mostrar Estudantes</a>
                
                <h3>Professor</h3>
                <a href="cadastroProfessor.jsp" class="list-group-item list-group-item-action">Cadastrar Professor</a>
                <a href="mostrarProfessores.jsp" class="list-group-item list-group-item-action">Mostrar Professores</a>
                
                <h3>Cadeira</h3>
                <a href="cadastroCadeira.jsp" class="list-group-item list-group-item-action">Cadastrar Cadeira</a>
                <a href="mostrarCadeiras.jsp" class="list-group-item list-group-item-action">Mostrar Cadeiras</a>

            </div>
        </div>
    </body>
</html>
