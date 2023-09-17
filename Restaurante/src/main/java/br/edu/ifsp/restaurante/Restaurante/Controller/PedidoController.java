package br.edu.ifsp.restaurante.Restaurante.Controller;

import br.edu.ifsp.restaurante.Restaurante.Model.Pedido;
import br.edu.ifsp.restaurante.Restaurante.Repository.CardapioRepository;
import br.edu.ifsp.restaurante.Restaurante.Repository.ClienteRepository;
import br.edu.ifsp.restaurante.Restaurante.Repository.PedidoRepository;
import br.edu.ifsp.restaurante.Restaurante.dto.PedidoRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.PedidoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CardapioRepository cardapioRepository;


    @GetMapping
    public List<PedidoResponseDTO> getAll() {
        return pedidoRepository.findAll()
                .stream()                 //stream é uma api para iterar sobre as collections,  permite usar metodos como .get .filter etc
                .map(PedidoResponseDTO::new)    //mapeia os elementos da lista de pedidos e cria instancias do PedidoDTO
                .toList();                      //converte a instancia do PedidoDTO em lista
    }

    @GetMapping("/{id}")
    public Pedido findPedido(@PathVariable Integer id) {
        if (pedidoRepository.findById(id).isEmpty()) {
            System.out.println("Pedido não encontrado :( ");
            return null;
        }else{
            return pedidoRepository.findById(id).get();
        }
    }


    @PostMapping
    public void addPedido(@RequestBody PedidoRequestDTO data) {
        pedidoRepository.save(new Pedido(data));                                               //salva a lista de id de pratos daquele pedido defiinido no requestDTO
    }

    @DeleteMapping("/{id}")
    public void removePedido(@PathVariable Integer id) {
        if(pedidoRepository.findById(id).isEmpty()){
            System.out.println("Pedido não encontrado para esse ID");
        }else{
            pedidoRepository.deleteById(id);
        }
    }

    @PutMapping("/{id}") //terminar
    public void updatePedido(@PathVariable Integer id, @RequestBody PedidoRequestDTO data) {
       Pedido pedido = new Pedido(data);
       pedido.setId(id);
       pedidoRepository.save(pedido);
    }

}
