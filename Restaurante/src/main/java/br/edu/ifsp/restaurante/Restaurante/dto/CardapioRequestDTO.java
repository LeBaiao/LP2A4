package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.Model.Pedido;
import br.edu.ifsp.restaurante.Restaurante.Model.Prato;

import java.util.List;

public record CardapioRequestDTO(String nome, String descricao, double preco, List<Pedido> pedidos) { //vai salvar só a lista de pedidos

}
