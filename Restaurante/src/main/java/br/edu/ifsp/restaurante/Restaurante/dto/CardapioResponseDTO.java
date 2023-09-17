package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.Model.Pedido;
import br.edu.ifsp.restaurante.Restaurante.Model.Prato;

import java.util.List;

public record CardapioResponseDTO(Integer id, String nome, String descricao, double preco, List<PedidoResponseDTO>pedidos){
    public CardapioResponseDTO(Prato p){
        this(p.getId(), p.getNome(), p.getDescricao(), p.getPreco(), p.getPedidos().stream().map(PedidoResponseDTO::new).toList());
    }
}
