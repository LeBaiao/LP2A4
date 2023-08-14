package br.edu.ifsp.restaurante.Restaurante.Repository;

import br.edu.ifsp.restaurante.Restaurante.Model.Endereco;
import br.edu.ifsp.restaurante.Restaurante.Model.Prato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
