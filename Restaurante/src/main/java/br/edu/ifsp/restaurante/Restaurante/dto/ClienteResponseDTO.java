package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.Model.Cliente;
import br.edu.ifsp.restaurante.Restaurante.Model.Endereco;
import br.edu.ifsp.restaurante.Restaurante.Model.Pedido;
import br.edu.ifsp.restaurante.Restaurante.Model.Prato;

import java.util.List;

public record ClienteResponseDTO(Integer id, String nome, Endereco endereco, List<PedidoResponseDTO> pedidos) {

    public ClienteResponseDTO(Cliente c){
        this(c.getId(), c.getNome(), c.getEndereco(), c.getPedidos().stream().map(PedidoResponseDTO::new).toList());
    }
}
