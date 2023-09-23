<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário de Cadastro</title>
</head>
<body>
<body>
    <h1>Cadastro de Usuario</h1>

    <form action="cadastro" method="post">
        <label for="nome">Nome:</label>
        <input type="text" name="nome" required/>
        <br><br>

        <label for="email">Email:</label>
        <input type="email" name="email" required/>
        <br><br>

        <label for="idade">Idade:</label>
        <input type="number" name="idade" required/>
        <br><br>

        <input type="submit" value="Enviar"/>
    </form>
</body>
</html>