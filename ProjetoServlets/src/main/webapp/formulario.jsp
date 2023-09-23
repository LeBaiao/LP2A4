<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário de Cadastro</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                margin: 0;
                padding: 0;
            }

            h1 {
                text-align: center;
                background-color: #007bff; /* Cor de fundo azul */
                color: #fff;
                padding: 20px;
                margin-top: 0;
            }

            form {
                width: 80%;
                margin: 20px auto;
                background-color: #fff;
                padding: 20px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            label {
                display: block;
                margin-bottom: 5px;
            }

            input[type="text"],
            input[type="email"],
            input[type="date"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            input[type="submit"] {
                background-color: #007bff; /* Cor de fundo azul */
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #0056b3; /* Cor de fundo azul mais escura */
            }
        </style>
</head>
<body>
    <h1>Cadastro de Usuario</h1>

    <form action="cadastro" method="post">
        <label for="nome">Nome:</label>
        <input type="text" name="nome" required/>
        <br><br>

        <label for="email">Email:</label>
        <input type="email" name="email" required/>
        <br><br>

        <label for="cpf">CPF:</label>
        <input type="text" name="cpf" required/>
        <br><br>

        <label for="dataNascimento">Data de Nascimento:</label>
        <input type="date" name="dataNascimento" required/>
        <br><br>

        <input type="submit" value="Enviar"/>
    </form>
</body>
</html>