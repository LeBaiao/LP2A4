package br.edu.ifsp.restaurante.Restaurante.Model;

import br.edu.ifsp.restaurante.Restaurante.Repository.EnderecoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Endereco")
@Entity(name = "Endereco")
public class Endereco {


    public Endereco(EnderecoRequestDTO data) {
        this.id = id;
        this.rua = rua;
        this.cidade = cidade;
        this.cliente = cliente;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String rua;

    @Column
    private String cidade;

    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;

}
