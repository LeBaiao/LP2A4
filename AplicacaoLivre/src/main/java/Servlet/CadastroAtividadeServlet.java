package Servlet;

import Model.Atividade;
import Repository.AtividadeRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/criarAtividade")
public class CadastroAtividadeServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("cadastroAtividade.jsp");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String descricao = request.getParameter("descricao");
        LocalDate dia = LocalDate.parse(request.getParameter("dia"));
        LocalTime hora = LocalTime.parse(request.getParameter("hora"));

        Atividade novaAtividade = new Atividade(descricao, dia, hora);

        AtividadeRepository atividadeRepository = new AtividadeRepository();
        atividadeRepository.addAtividade(novaAtividade);
        System.out.println("nova atividade criada, id: " + novaAtividade.getIdAtividade());

        response.sendRedirect("listagemAtividades");
    }
}


