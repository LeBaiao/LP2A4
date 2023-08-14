package br.edu.ifsp.restaurante.Restaurante.Model;

import br.edu.ifsp.restaurante.Restaurante.dto.FuncionarioRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.text.DecimalFormat;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
    private Integer id;
    private String nome;
    private String cpf;

    public Funcionario(FuncionarioRequestDTO funcionarioRequestDTO) {
        this.nome = funcionarioRequestDTO.nome();
        this.cpf = funcionarioRequestDTO.cpf();
    }

}
