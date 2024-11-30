<%-- 
    Document   : loginEstudante
    Created on : Sep 4, 2024, 11:50:01 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="minhaTag" uri="/WEB-INF/tlds/cabuetaTags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <style>
            body {
                background-color: #f0f8ff; /* Azul claro */
            }
            .card {
                background-color: #ffffff; /* Fundo branco */
                border: 2px solid #008b8b; /* Borda verde-água */
                border-radius: 15px;
            }
            .card-title {
                color: #008b8b; /* Texto verde-água */
            }
            .btn-primary {
                background-color: #20b2aa; /* Verde-água mais claro */
                border-color: #20b2aa;
            }
            .btn-primary:hover {
                background-color: #2e8b57; /* Verde-escuro */
                border-color: #2e8b57;
            }
            .btn-secondary {
                background-color: #4682b4; /* Azul escuro */
                border-color: #4682b4;
            }
            .btn-secondary:hover {
                background-color: #5f9ea0; /* Azul esverdeado */
                border-color: #5f9ea0;
            }
            .form-label {
                color: #2f4f4f; /* Cinza escuro */
            }
            .form-control {
                border: 2px solid #20b2aa;
            }
            .form-control:focus {
                box-shadow: none;
                border-color: #2e8b57; /* Verde-escuro */
            }
            .modal-content {
                background-color: #f5f5f5; /* Cinza claro */
                border: 2px solid #008b8b; /* Borda verde-água */
            }
            .btn-close {
                background-color: #008b8b;
            }
        </style>
    </head>
    <body>
        <div class="container text-center my-5">
            <div class="row justify-content-center">
                <div class="col-md-4">
                    <div class="card mb-4">
                        <div class="card-body">
                            <h5 class="card-title">Login do Aluno</h5>
                            <small style="color: lightcoral">${sessionScope.msg}</small>
                            <c:remove var="msg" scope="session"/>
                            <form method="post" action="EstudanteAccessController">
                                <div class="mb-3">
                                    <label for="emailLogin" class="form-label">E-mail</label>
                                    <input type="email" class="form-control w-100" id="emailLogin" name="emailLogin" required>
                                </div>
                                <div class="mb-3">
                                    <label for="senhaLogin" class="form-label">Senha</label>
                                    <input type="password" class="form-control w-100" id="senhaLogin" name="senhaLogin" required>
                                </div>
                                <div class="mb-3">
                                    <small class="form-text text-muted">
                                        Caso não tenha cadastro, 
                                        <a href="#" data-bs-toggle="modal" data-bs-target="#modalCadastro">Cadastrar-se.</a>
                                    </small>
                                </div>
                                <div class="d-grid gap-2">
                                    <button type="submit" class="btn btn-primary">Entrar</button>
                                    <a class="btn btn-secondary" href="index2.html">Voltar</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="modalCadastro" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <c:import url="cadastroEstudante.jsp"/>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
