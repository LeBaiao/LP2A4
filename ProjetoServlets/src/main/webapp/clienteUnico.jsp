<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Info Cliente</title>
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

            p {
                margin: 10px;
                padding: 5px;
                font-size: 18px;
            }

            strong {
                font-weight: bold;
            }
        </style>
</head>
<body>
    <h1> Detalhes Cliente <h1/>
            <p><strong>Nome:</strong> ${cliente.nome}</p>
            <p><strong>CPF:</strong> ${cliente.cpf}</p>
            <p><strong>Data de nascimento:</strong> ${cliente.dataNascimento}</p>
            <p><strong>Telefone:</strong> ${cliente.telefone}</p>
</body>
</html>