package br.edu.ifsp.restaurante.Restaurante.Controller;

import br.edu.ifsp.restaurante.Restaurante.Model.Cliente;
import br.edu.ifsp.restaurante.Restaurante.Model.Funcionario;
import br.edu.ifsp.restaurante.Restaurante.Repository.CardapioRepository;
import br.edu.ifsp.restaurante.Restaurante.Repository.ClienteRepository;
import br.edu.ifsp.restaurante.Restaurante.dto.ClienteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    List<Cliente> clientes = new ArrayList<>();

    @GetMapping
    public List<ClienteResponseDTO> getAll(){
    return clientes.stream().map(ClienteResponseDTO::new).toList();
    }

    @PostMapping
    public void addCliente(@RequestBody Cliente cliente){
        clientes.add(cliente);
    }

    @DeleteMapping("/{id}")
    public void removeCliente(@PathVariable Integer id){
        for (Cliente c : clientes){
            if(c.getId() == id){
                clientes.remove(c);
            }else {
                System.out.println("Id do Cliente inválido :( ");
            }
        }
    }

    @GetMapping("/{id}")
    public Cliente findCliente(@PathVariable Integer id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @PutMapping
    public void updateCliente(@RequestBody ClienteResponseDTO clienteResponseDTO){
        Cliente cliente = findCliente(clienteResponseDTO.id());
        if(cliente == null) {
            System.out.println("Id do Cliente inválido");
        } else {
            cliente.setNome(clienteResponseDTO.nome());
            cliente.setEndereco(clienteResponseDTO.endereco());
        }
    }

    //cadastro, edição e remoção e llistagem de clientes
}
