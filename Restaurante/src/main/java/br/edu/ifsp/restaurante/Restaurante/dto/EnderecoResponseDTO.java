package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.Model.Endereco;
import br.edu.ifsp.restaurante.Restaurante.dto.ClienteResponseDTO;

public record EnderecoResponseDTO(Integer id, String rua, String cidade, ClienteResponseDTO cliente) {

    public EnderecoResponseDTO(Endereco endereco) {
        this(endereco.getId(), endereco.getRua(), endereco.getCidade(), new ClienteResponseDTO(endereco.getCliente()));
    }
}
