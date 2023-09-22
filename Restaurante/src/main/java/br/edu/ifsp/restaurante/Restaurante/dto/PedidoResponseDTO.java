package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.Model.Cliente;
import br.edu.ifsp.restaurante.Restaurante.Model.Pedido;

import java.util.List;

public record PedidoResponseDTO(Integer id, String descricao, ClienteResponseDTO cliente, List<CardapioResponseDTO> pratos ) { //não pode usar o cliente direto sem o dto senão vai entrar em looping

    public PedidoResponseDTO (Pedido pedido){
        this(pedido.getId(), pedido.getDescricao(), new ClienteResponseDTO(pedido.getCliente()) , pedido.getPratos().stream().map(CardapioResponseDTO::new).toList());//esse ultimo converte de uma lista de pratos para uma lista de dto de pratos
    } //o resonse tem construtor, o request não
}
