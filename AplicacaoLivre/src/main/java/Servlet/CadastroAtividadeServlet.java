package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CadastroAtividadeServlet extends HttpServlet {

    //        <form action="cadastro" method="post"> define a url que o jsp vai atender

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/cadastroAtividade.jsp").forward(req, resp);
    }
}
