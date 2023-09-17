package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.Model.Cliente;
import br.edu.ifsp.restaurante.Restaurante.Model.Pedido;
import br.edu.ifsp.restaurante.Restaurante.Model.Prato;

import java.util.List;

public record PedidoRequestDTO(String descricao, Cliente cliente, List<Cliente>clientes, List<Prato>pratos) { //define o corpo da solicitação que será feita pelo cliente
    //request não tem construtor
}
