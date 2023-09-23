package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Pessoa;
import repository.PessoaRepository;
import java.io.IOException;
import java.util.List;

@WebServlet
public class ListagemGeralServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            System.out.println( PessoaRepository.listarPessoas().size());
            List<Pessoa> pessoas = PessoaRepository.listarPessoas();

            req.setAttribute("pessoas", pessoas);
            req.getRequestDispatcher("/listagemGeral.jsp").forward(req,resp);
        }
}

