package br.edu.ifsp.restaurante.Restaurante.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cliente")
@Entity(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")//cria uma chave estrangeira na tabela cliente para se relacionar com endereco
    private Endereco endereco;

}
