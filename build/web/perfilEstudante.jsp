<%-- 
    Document   : perfilEstudante
    Created on : Sep 5, 2024, 1:53:46 AM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Perfil do Estudante</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

        <!-- Custom CSS -->
        <style>
            body {
                background-color: #f7f9fc;
                font-family: 'Arial', sans-serif;
            }
            /* Sidebar styles */
            .sidebar {
                height: 100vh;
                width: 250px;
                background-color: #004085;
                position: fixed;
                top: 0;
                left: 0;
                padding-top: 20px;
                padding-left: 15px;
            }
            .sidebar a {
                padding: 10px 15px;
                text-decoration: none;
                font-size: 18px;
                color: #f8f9fa;
                display: block;
                transition: 0.3s;
            }
            .sidebar a:hover {
                background-color: #0056b3;
                border-radius: 5px;
            }
            .sidebar .active {
                background-color: #003d75;
                border-radius: 5px;
            }
            /* Main content */
            .main-content {
                margin-left: 260px;
                padding: 20px;
            }
            .container {
                background-color: white;
                padding: 2rem;
                border-radius: 10px;
                box-shadow: 0 4px 12px rgba(0,0,0,0.1);
                margin-top: 30px;
            }
            h2 {
                color: #004085;
            }
            .btn-group .btn {
                margin-right: 5px;
                border: 1px solid #ddd;
            }
            .btn:hover {
                background-color: #0056b3;
                color: white;
            }
            .tablePerfil th {
                background-color: #f7f9fc;
                color: #004085;
                border-bottom: 2px solid #ddd;
            }
            .tablePerfil td {
                background-color: #fff;
                border-bottom: 1px solid #ddd;
            }
            .conteudo h4 {
                margin-bottom: 20px;
                color: #004085;
            }
            .form-control {
                border-radius: 5px;
            }
            .btn-primary {
                background-color: #0056b3;
                border: none;
            }
            .btn-primary:hover {
                background-color: #003d75;
            }
        </style>
    </head>
    <body>
        <c:if test="${sessionScope.eLogado eq null}">
            <c:redirect url="loginEstudante.jsp"/>
        </c:if>
        
        <!-- Sidebar -->
        <div class="sidebar">
            <a href="indexEstudante.jsp">Home</a>
            <a href="#" class="active">Perfil</a>
            <a href="EstudanteAccessController?op=logout" class="text-danger">Sair</a>
        </div>

        <!-- Main content -->
        <div class="main-content">
            <div class="container">
                <h2>Perfil do Estudante</h2>
                <small class="text-danger">${sessionScope.msg}</small>
                <c:remove var="msg" scope="session"/>
                
                <div class="btn-group mb-4" role="group">
                    <button type="button" class="btn btn-outline-primary" id="btnMeusDados">Meus Dados</button>
                    <button type="button" class="btn btn-outline-secondary" id="btnEditarDados">Editar Dados</button>
                    <button type="button" class="btn btn-outline-warning" id="btnTrocarSenha">Trocar Senha</button>
                </div>

                <div id="conteudoMeusDados" class="conteudo">
                    <h4>Meus Dados</h4>
                    <table class="table table-hover tablePerfil">
                        <tbody>
                            <tr>
                                <th scope="row">Nome</th>
                                <td>${sessionScope.eLogado.nomeEstudante}</td>
                            </tr>
                            <tr>
                                <th scope="row">E-mail</th>
                                <td>${sessionScope.eLogado.emailEstudante}</td>
                            </tr>
                            <tr>
                                <th scope="row">Código</th>
                                <td>${sessionScope.eLogado.codigoEstudante}</td>
                            </tr>
                            <tr>
                                <th scope="row">Ano de Entrada</th>
                                <td>${sessionScope.eLogado.anoEntradaEstudante}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div id="conteudoEditarDados" class="conteudo d-none">
                    <h4>Editar Dados</h4>
                    <form action="EstudanteControllerJSP" method="post">
                        <input type="hidden" name="op" value="1"/>
                        <input type="hidden" name="perfil" value="1"/>
                        <input type="hidden" name="senha" value="${sessionScope.eLogado.senhaEstudante}"/>
                        <input type="hidden" name="codigo" value="${sessionScope.eLogado.codigoEstudante}"/>
                        
                        <div class="mb-3">
                            <label for="nome" class="form-label">Nome</label>
                            <input type="text" id="nome" name="nome" class="form-control" value="${sessionScope.eLogado.nomeEstudante}">
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">E-mail</label>
                            <input type="email" id="email" name="email" class="form-control" value="${sessionScope.eLogado.emailEstudante}">
                        </div>
                        <div class="mb-3">
                            <label for="anoEntrada" class="form-label">Ano de Entrada</label>
                            <input type="number" id="anoEntrada" name="anoEntrada" class="form-control" value="${sessionScope.eLogado.anoEntradaEstudante}">
                        </div>

                        <button type="submit" class="btn btn-primary">Salvar</button>
                    </form>
                </div>

                <div id="conteudoTrocarSenha" class="conteudo d-none">
                    <h4>Trocar Senha</h4>
                    <form action="EstudanteControllerJSP" method="post">
                        <input type="hidden" name="op" value="1"/>
                        <input type="hidden" id="nome" name="nome" value="${sessionScope.eLogado.nomeEstudante}">
                        <input type="hidden" id="email" name="email" value="${sessionScope.eLogado.emailEstudante}">
                        <input type="hidden" id="anoEntrada" name="anoEntrada" value="${sessionScope.eLogado.anoEntradaEstudante}">
                        <input type="hidden" id="codigo" name="codigo" value="${sessionScope.eLogado.codigoEstudante}">
                        
                        <div class="mb-3">
                            <label for="senha0" class="form-label">Senha Atual</label>
                            <input type="password" id="senha0" name="senha0" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label for="senha" class="form-label">Senha Nova</label>
                            <input type="password" id="senha" name="senha" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label for="senha2" class="form-label">Confirmar Senha Nova</label>
                            <input type="password" id="senha2" name="senha2" class="form-control">
                        </div>

                        <button type="submit" class="btn btn-primary">Trocar Senha</button>
                    </form>
                </div>
            </div>
        </div>

        <script>
            document.getElementById('btnMeusDados').addEventListener('click', function () {
                mostrarConteudo('conteudoMeusDados');
            });

            document.getElementById('btnEditarDados').addEventListener('click', function () {
                mostrarConteudo('conteudoEditarDados');
            });

            document.getElementById('btnTrocarSenha').addEventListener('click', function () {
                mostrarConteudo('conteudoTrocarSenha');
            });

            function mostrarConteudo(id) {
                document.querySelectorAll('.conteudo').forEach(function (element) {
                    element.classList.add('d-none');
                });
                document.getElementById(id).classList.remove('d-none');
            }
        </script>
    </body>
</html>

