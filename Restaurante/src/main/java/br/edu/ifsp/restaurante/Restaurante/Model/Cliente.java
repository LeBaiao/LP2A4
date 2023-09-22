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

@Data //Lombok, gera automaticamente getters e setters, hashcode, equals, tostring
@NoArgsConstructor //gera automaticamente um construtor vazio
@AllArgsConstructor //gera automaticamente um construtor que aceita todos os campos
@Table(name = "Cliente") //associa a classe a uma tabela
@Entity(name = "Cliente") //define a classe como uma entidade do Banco de Dados
public class Cliente {


    public Cliente(ClienteRequestDTO data){
        this.nome = data.nome();
        this.endereco = data.endereco();
        this.pedidos = data.pedidos();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @OneToOne(cascade = CascadeType.ALL) //relacionamento
    @JoinColumn(name = "endereco_id")//cria uma chave estrangeira na tabela cliente para se relacionar com endereco
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();



}
