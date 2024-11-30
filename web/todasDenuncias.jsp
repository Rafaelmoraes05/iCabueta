<%-- 
    Document   : todasDenuncias
    Created on : Sep 5, 2024, 1:56:27 AM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.edu.ifpe.recife.model.repository.DenunciaRepository"%>
<%@page import="br.edu.ifpe.recife.model.entities.Denuncia"%>
<%@ taglib prefix="minhaTag" uri="/WEB-INF/tlds/cabuetaTags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todas as Denúncias</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <style>
            body {
                background-color: #f7f9fc;
                font-family: 'Arial', sans-serif;
            }
            .navbar {
                background-color: #004085;
            }
            .navbar-brand {
                font-weight: bold;
                color: #fff !important;
            }
            .nav-link {
                color: #f8f9fa !important;
            }
            .nav-link:hover {
                color: #d4edda !important;
            }
            .table-hover tbody tr:hover {
                background-color: #e9ecef;
            }
            .thead-dark {
                background-color: #343a40;
                color: #fff;
            }
            h1 {
                font-size: 2.5rem;
                margin-bottom: 2rem;
                color: #004085;
            }
            .btn-primary {
                background-color: #0056b3;
                border-color: #004085;
            }
            .btn-primary:hover {
                background-color: #004085;
                border-color: #002752;
            }
            table {
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
            }
            td, th {
                padding: 1rem;
            }
        </style>
    </head>
    <body>
        <!-- Verificação de login -->
        <c:if test="${sessionScope.pLogado eq null}">
            <c:redirect url="loginProfessor.jsp"/>
        </c:if>

        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Sistema de Cabuetagem</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <a class="nav-link active" href="indexProfessor.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="todasDenuncias.jsp">Todas as Denúncias</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="perfilProfessor.jsp">Perfil</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Conteúdo principal -->
        <div class="container my-5">
            <small class="text-danger">${sessionScope.msg}</small>
            <c:remove var="msg" scope="session"/>

            <div class="container mt-5">
                <div class="mb-3 row">
                    <form action="ProfessorAccessController" method="post" class="d-flex flex-row align-items-start justify-content-around">
                        <input type="hidden" name="pesquisaPorAluno"/>
                        <fieldset class="d-flex align-items-center mb-3">
                            <legend class="col-form-label me-2">Pesquisar por:</legend>
                            <div class="d-flex align-items-center">
                                <div class="form-check me-3">
                                    <input class="form-check-input" type="radio" id="denunciante" name="tipo" value="denunciante">
                                    <label class="form-check-label" for="denunciante">Denunciante</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" id="denunciado" name="tipo" value="denunciado">
                                    <label class="form-check-label" for="denunciado">Denunciado</label>
                                </div>
                            </div>
                        </fieldset>

                        <minhaTag:carrega var="alunos" escopo="pagina" typ="estudante"/>

                        <div class="d-flex">
                            <div class="d-flex flex-row align-items-center justify-content-around">
                                <label for="aluno" class="form-label">Aluno:</label>
                                <select id="aluno" class="form-select" name="aluno">
                                    <c:forEach var="aluno" items="${alunos}">
                                        <option value="${aluno.codigoEstudante}">${aluno.nomeEstudante}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <button type="submit" class="btn btn-primary mt-2">Procurar</button>
                    </form>
                </div>

                <table class="table table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th>Código</th>
                            <th>Data</th>
                            <th>Professor</th>
                            <th>Cadeira</th>
                            <th>Método de Fila</th>
                            <th>Denunciante</th>
                            <th>Turno</th>
                            <th>Denunciados</th>
                            <th>Descrição</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="denuncia" items="${listResult}">
                            <tr>
                                <td>${denuncia.codigo}</td>
                                <td>${Denuncia.formatDate(denuncia.data)}</td>
                                <td>${denuncia.professor.nomeProfessor}</td>
                                <td>${denuncia.cadeira.nome}</td>
                                <td>${denuncia.metodoFila.descricaoCurta}</td>
                                <td>${denuncia.denunciante.nomeEstudante}</td>
                                <td>${denuncia.turno}</td>
                                <td>
                                    <ul>
                                        <c:forEach var="aluno" items="${denuncia.denunciados}">
                                            <li>${aluno.nomeEstudante}</li>
                                        </c:forEach>
                                    </ul>
                                </td>
                                <td>${denuncia.descricaoDoOcorrido}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
