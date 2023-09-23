package servlets;
import model.Pessoa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class CadastroServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("O servlet foi chamado.");
        resp.sendRedirect("formulario.jsp");

        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String idade = req.getParameter("idade");

        try {
            int idadeConvertida = Integer.parseInt(idade);
            Pessoa pessoa = new Pessoa(nome, email, idadeConvertida);
        }catch (NumberFormatException n){
            System.err.println("Erro ao converter idade: " + n.getMessage());
        }
//    }
    }
}

