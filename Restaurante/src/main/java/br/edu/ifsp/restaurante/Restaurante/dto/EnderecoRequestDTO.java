package br.edu.ifsp.restaurante.Restaurante.dto;
import br.edu.ifsp.restaurante.Restaurante.Model.Cliente;

public record EnderecoRequestDTO(String rua, String cidade, Cliente cliente) {
}
