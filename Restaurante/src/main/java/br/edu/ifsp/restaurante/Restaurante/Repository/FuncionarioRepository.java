package br.edu.ifsp.restaurante.Restaurante.Repository;

import br.edu.ifsp.restaurante.Restaurante.Model.Funcionario;
import br.edu.ifsp.restaurante.Restaurante.Model.Prato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
