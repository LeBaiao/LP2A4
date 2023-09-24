package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;
import repository.ClienteRepository;

import java.io.IOException;

@WebServlet
public class ListagemUnicaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cpf = req.getParameter("cpf");
        Cliente cliente = ClienteRepository.getClientePorCpf(cpf);

        req.setAttribute("cliente", cliente);
        req.getRequestDispatcher("/clienteUnico.jsp").forward(req, resp);
    }

    //http://localhost:8080/cliente?cpf=numero_do_cpf
}
