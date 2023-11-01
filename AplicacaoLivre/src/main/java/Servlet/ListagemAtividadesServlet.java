package Servlet;

import Model.Atividade;
import Repository.AtividadeRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listagemAtividades")
public class ListagemAtividadesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AtividadeRepository atividadeRepository = new AtividadeRepository();
        List<Atividade> atividades = atividadeRepository.listarAtividades();

        request.setAttribute("atividades", atividades);

        request.getRequestDispatcher("listagemAtividades.jsp").forward(request, response);
    }
}
