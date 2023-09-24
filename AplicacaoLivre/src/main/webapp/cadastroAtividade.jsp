<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário de Cadastro</title>
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            padding: 20px;
            width: 400px;
        }

        label {
            display: block;
            font-size: 18px;
            margin-top: 10px;
            color: #555;
        }

        input[type="text"],
        input[type="date"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        input[type="text"]:focus,
        input[type="date"]:focus {
            outline: none;
            border-color: #007bff;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            font-size: 18px;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
    </head>
    <body>
        <h1>Cadastro de Atividades</h1>

        <form action="cadastroAtividade" method="post">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" required/>
            <br><br>

            <label for="descricao">Descricao:</label>
            <input type="text" name="descricao" required/>
            <br><br>

            <label for="data">Data da Atividade:</label>
            <input type="date" name="data" required/>
            <br><br>

            <label for="horario">Horario ds Atividade:</label>
            <input type="text" name="horario" placeholder="HH:mm" required/>
            <br><br>

            <input type="submit" value="Enviar"/>
        </form>
    </body>
    </html>