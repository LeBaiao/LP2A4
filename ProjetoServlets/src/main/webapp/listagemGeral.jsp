<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Clientes</title>
     <style>
             body {
                 font-family: Arial, sans-serif;
                 background-color: #f0f0f0;
                 margin: 0;
                 padding: 0;
             }

             h1 {
                 text-align: center;
                 background-color: #007bff;
                 color: #fff;
                 padding: 20px;
                 margin-top: 0;
             }

             table {
                 width: 80%;
                 margin: 20px auto;
                 border-collapse: collapse;
                 box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                 background-color: #fff;
             }

             th, td {
                 padding: 10px;
                 text-align: left;
             }

             th {
                 background-color: #007bff;
                 color: #fff;
             }

             tr:nth-child(even) {
                 background-color: #f2f2f2;
             }

             tr:hover {
                 background-color: #ddd;
             }
         </style>
</head>
<body>
    <h1>Lista de Clientes Cadastradas</h1>
    <table>
        <tr>
            <th>Nome</th>
            <th>Telefone</th>
            <th>CPF</th>
            <th>Data de Nascimento</th>
        </tr>
        <c:forEach var="cliente" items="${clientes}">
            <tr>
                <td>${cliente.nome}</td>
                <td>${cliente.telefone}</td>
                <td>${cliente.cpf}</td>
                <td>${cliente.dataNascimento}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
