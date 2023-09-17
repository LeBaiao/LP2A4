package br.edu.ifsp.restaurante.Restaurante.Controller;

import br.edu.ifsp.restaurante.Restaurante.Model.Cliente;
import br.edu.ifsp.restaurante.Restaurante.Model.Funcionario;
import br.edu.ifsp.restaurante.Restaurante.Model.Pedido;
import br.edu.ifsp.restaurante.Restaurante.Repository.CardapioRepository;
import br.edu.ifsp.restaurante.Restaurante.Repository.ClienteRepository;
import br.edu.ifsp.restaurante.Restaurante.Repository.PedidoRepository;
import br.edu.ifsp.restaurante.Restaurante.dto.ClienteRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.ClienteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping
    public List<ClienteResponseDTO> getAll() {
        return clienteRepository.findAll().stream().map(ClienteResponseDTO::new).toList();
    }

    @PostMapping
    public void addCliente(@RequestBody ClienteRequestDTO data) {
        clienteRepository.save(new Cliente(data));
    }

    @DeleteMapping("/{id}")
    public void removeCliente(@PathVariable Integer id) {
        if (clienteRepository.findById(id).isEmpty()) {
            System.out.println("Id do Cliente inválido :( ");
        } else {
            clienteRepository.deleteById(id);
        }
    }

    @GetMapping("/{id}")
    public Cliente findCliente(@PathVariable Integer id) {
        if (clienteRepository.findById(id).isEmpty()) {
            System.out.println("Cliente não encontrado");
            return null;
        } else {
            return clienteRepository.findById(id).get();
        }
    }

    @PutMapping("/{id}")
    public void updateCliente(@PathVariable Integer id, @RequestBody ClienteRequestDTO data) {
        try {
            Cliente cliente = new Cliente(data);
            cliente.setId(id);
            clienteRepository.save(cliente);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao atualizar o Cliente: " + e.getMessage());
        }
    }


}


