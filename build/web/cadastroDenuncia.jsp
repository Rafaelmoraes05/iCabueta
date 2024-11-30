<%-- 
    Document   : cadastroDenuncia
    Created on : Sep 5, 2024, 1:35:02 AM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="minhaTag" uri="/WEB-INF/tlds/cabuetaTags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Denúncia</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <style>
        body {
            background-color: #e3f2fd; /* Azul bem claro */
            font-family: 'Arial', sans-serif;
        }
        .navbar {
            background-color: #004085; /* Azul especificado */
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .navbar-brand, .nav-link {
            color: #fff;
        }
        .navbar-brand {
            font-weight: bold;
        }
        .nav-link:hover {
            color: #d4edda; /* Azul claro no hover */
        }
        h1 {
            color: #004085; /* Azul especificado */
        }
        .container {
            background-color: #ffffff; /* Fundo branco */
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .form-label {
            font-weight: bold;
            color: #424242;
        }
        .form-control, .form-select {
            border-radius: 10px;
            border: 1px solid #90caf9; /* Borda azul clara */
        }
        .form-control:focus, .form-select:focus {
            box-shadow: none;
            border-color: #004085; /* Azul especificado */
        }
        .btn-primary {
            background-color: #004085; /* Azul especificado */
            border-color: #004085;
            border-radius: 10px;
        }
        .btn-primary:hover {
            background-color: #002752; /* Azul mais escuro no hover */
            border-color: #002752;
        }
        .mb-3 {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <c:if test="${sessionScope.eLogado eq null}">
        <c:redirect url="loginEstudante.jsp"/>
    </c:if>

    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Sistema de Cabuetagem</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="indexEstudante.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="perfilEstudante.jsp">Perfil</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Main content -->
    <div class="container mt-5">
        <h1 class="mb-4">Cadastro de Denúncias</h1>
        <small style="color: #e57373;">${sessionScope.msg}</small>
        <c:remove var="msg" scope="session"/>
        <form action="EstudanteAccessController" method="post">
            <input type="hidden" name="denuncia"/>
            <div class="mb-3">
                <label for="codigo" class="form-label">Código</label>
                <input type="text" class="form-control" id="codigo" name="codigo">
            </div>
            <div class="mb-3">
                <label for="turno" class="form-label">Escolha o turno do ocorrido:</label>
                <select id="turno" name="turno" class="form-select">
                    <option value="manha">Manhã</option>
                    <option value="tarde">Tarde</option>
                    <option value="noite">Noite</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="descricaoDoOcorrido" class="form-label">Descrição</label>
                <textarea class="form-control" id="descricaoDoOcorrido" name="descricaoDoOcorrido"></textarea>
            </div>
            <div class="mb-3">
                <minhaTag:carrega var="professores" escopo="pagina" typ="professor"/>
                <label for="professor" class="form-label">Escolha o Professor da cadeira:</label>
                <select id="professor" class="form-select" name="professor">
                    <c:forEach var="professor" items="${professores}">
                        <option value="${professor.codigoProfessor}">${professor.nomeProfessor}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <minhaTag:carrega var="cadeiras" escopo="pagina" typ="cadeira"/>
                <label for="cadeira" class="form-label">Escolha a cadeira:</label>
                <select id="cadeira" class="form-select" name="cadeira">
                    <c:forEach var="cadeira" items="${cadeiras}">
                        <option value="${cadeira.codigo}">${cadeira.nome}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3 row">
                <minhaTag:carrega var="alunos" escopo="pagina" typ="estudante"/>
                <div class="col-md-6">
                    <label for="alunosDenunciados" class="form-label">Escolha os alunos envolvidos:</label>
                    <br>
                    <c:forEach var="aluno" items="${alunos}">
                        <b>${aluno.nomeEstudante}:</b> <input type="checkbox" name="alunosDenunciados" value="${aluno.codigoEstudante}" /> <br>
                    </c:forEach>
                </div>
            </div>
            <div class="mb-3">
                <minhaTag:carrega var="mfilas" escopo="pagina" typ="metodofila"/>
                <label for="metodosFila" class="form-label">Escolha o método de fila utilizado:</label>
                <select id="metodoFila" class="form-select" name="metodosFila">
                    <c:forEach var="mfila" items="${mfilas}">
                        <option value="${mfila.codigoFila}">${mfila.descricaoCurta}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Denunciar</button>
        </form>
    </div>
</body>
</html>

