package servlets;
import model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ClienteRepository;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet
public class CadastroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/formulario.jsp").forward(req, resp);
        System.out.println("O servlet foi chamado.");
        // resp.sendRedirect("formulario.jsp");                           // Redireciona para o "formulario.jsp" após o processamento
    }


        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String telefone = req.getParameter("telefone");
        String cpf = req.getParameter("cpf");
        String dataNascimentoStr = req.getParameter("dataNascimento");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

//        getParameter é um método fornecido pela classe HttpServletRequest em servlets Java que é usado
//        para obter os valores dos parâmetros passados em uma solicitação HTTP. Esses parâmetros podem ser
//        passados pela URL (no caso de solicitações GET) ou no corpo da solicitação (no caso de solicitações POST).

        System.out.println("socorro deus funciona");

        Cliente cliente = new Cliente(nome, telefone, cpf, dataNascimento);
        ClienteRepository.addCliente(cliente);                                 //adiciona na repository para poder manipular depois
        System.out.println( ClienteRepository.listarClientes().size());
    }
}

