package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.Model.Cliente;
import br.edu.ifsp.restaurante.Restaurante.Model.Pedido;

import java.util.List;

public record PedidoRequestDTO(String descricao, Integer cliente, List<Integer> pratos) { //id do cliente e lista de pratos
    //request não tem construtor
}
