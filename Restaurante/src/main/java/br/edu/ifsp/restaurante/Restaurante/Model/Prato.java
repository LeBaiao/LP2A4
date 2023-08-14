package br.edu.ifsp.restaurante.Restaurante.Model;

import br.edu.ifsp.restaurante.Restaurante.dto.CardapioRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Prato")
@Entity(name = "Prato")
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;
    @Column
    private String descricao;
    @Column
    private double preco;

    public Prato(CardapioRequestDTO cardapioRequestDTO){
        this.nome = cardapioRequestDTO.nome();
        this.descricao = cardapioRequestDTO.descricao();
        this.preco = cardapioRequestDTO.preco();
    }
}