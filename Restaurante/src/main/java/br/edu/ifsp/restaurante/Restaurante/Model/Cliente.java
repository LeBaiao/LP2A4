package br.edu.ifsp.restaurante.Restaurante.Model;

import br.edu.ifsp.restaurante.Restaurante.dto.CardapioRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.ClienteRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cliente")
@Entity(name = "Cliente")
public class Cliente {


    public Cliente(ClienteRequestDTO clienteRequestDTO){
        this.nome = clienteRequestDTO.nome();
        this.endereco = clienteRequestDTO.endereco();
        //colocar os pedidos
       /* this.nome = cardapioRequestDTO.nome();
        this.descricao = cardapioRequestDTO.descricao();
        this.preco = cardapioRequestDTO.preco();*/
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")//cria uma chave estrangeira na tabela cliente para se relacionar com endereco
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();



}
