package br.edu.ifsp.restaurante.Restaurante.Controller;

import br.edu.ifsp.restaurante.Restaurante.Model.Pedido;
import br.edu.ifsp.restaurante.Restaurante.Model.Prato;
import br.edu.ifsp.restaurante.Restaurante.Repository.CardapioRepository;
import br.edu.ifsp.restaurante.Restaurante.Repository.ClienteRepository;
import br.edu.ifsp.restaurante.Restaurante.Repository.PedidoRepository;
import br.edu.ifsp.restaurante.Restaurante.dto.ClienteResponseDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.PedidoRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.PedidoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CardapioRepository cardapioRepository;

    List<Pedido> pedidos = new ArrayList<>();

    public PedidoController(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, CardapioRepository cardapioRepository, List<Pedido> pedidos) { //alt + insert
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.cardapioRepository = cardapioRepository;
        this.pedidos = pedidos;
    }

    @GetMapping
    public List<PedidoResponseDTO> getAll() {

        return pedidos.stream().map(PedidoResponseDTO::new).toList();
    }


    @PostMapping
    public void addPedido(@RequestBody PedidoRequestDTO data) {
        List<Prato> p = new ArrayList<>();
        for(Integer id : data.pratos()){
        p.add(cardapioRepository.findById(id).get());
        }
       pedidoRepository.save(new Pedido(data.descricao(), clienteRepository.findById(data.cliente()).get(), p)); //converte pra dto
    }

    @DeleteMapping("/{id}")
    public void removePedido(@PathVariable Integer id) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                pedidos.remove(p);
            } else {
                System.out.println("Id do pedido inválido :( ");
            }
        }
    }





}
