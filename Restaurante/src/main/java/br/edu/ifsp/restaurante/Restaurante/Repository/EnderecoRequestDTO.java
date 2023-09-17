package br.edu.ifsp.restaurante.Restaurante.Repository;
import br.edu.ifsp.restaurante.Restaurante.Model.Cliente;

public record EnderecoRequestDTO(String rua, String cidade, Cliente cliente) {
}
