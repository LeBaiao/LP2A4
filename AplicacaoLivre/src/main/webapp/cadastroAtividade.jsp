<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário de Cadastro</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/cadastroAtividade.css">
</head>
<body>
    <div class="container">
        <h1>Cadastro de Atividades</h1>
        <form action="criarAtividade" method="POST">
            <label for="descricao">Descrição:</label>
            <input type="text" name="descricao" required><br>

            <label for="dia">Data:</label>
            <input type="date" name="dia" required><br>

            <label for="hora">Hora:</label>
            <input type="time" name="hora" required><br>

            <input type="submit" value="Enviar">
        </form>
    </div>
</body>
</html>
