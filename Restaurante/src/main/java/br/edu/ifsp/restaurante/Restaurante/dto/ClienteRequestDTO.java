package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.Model.Endereco;
import br.edu.ifsp.restaurante.Restaurante.Model.Pedido;

import java.util.List;

public record ClienteRequestDTO(String nome, Endereco endereco, List<Pedido> pedidos) { //lista de integer p só pegar os id
}
