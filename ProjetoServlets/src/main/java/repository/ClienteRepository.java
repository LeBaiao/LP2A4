package repository;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private static List<Cliente> clientes = new ArrayList<>();

    public static void addCliente(Cliente cliente){
        clientes.add(cliente);
    }
    public static List<Cliente> listarClientes(){
        return clientes;
    }

    public static Cliente getClientePorCpf(String cpf){
        for (Cliente c: clientes) {
            if(c.getCpf().equals(cpf)){
                return c;
            }
        } return null;
    }



}
