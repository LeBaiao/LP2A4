<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscrição Atividades</title>
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/inscricaoAtividade.css">
    </head>
    </head>
    <body>
        <h1>Inscrição nas Atividades</h1>
        <form action="inscricao" method="POST">

            <label for="nome">Nome:</label>
            <input type="text" name="nome" required><br>

            <label for="email">E-mail:</label>
            <input type="email" name="email" required><br>

            <label for="senha">E-mail:</label>
            <input type="password" name="senha" required><br>

            <input type="submit" value="Enviar">
        </form>
    </body>
    </html>