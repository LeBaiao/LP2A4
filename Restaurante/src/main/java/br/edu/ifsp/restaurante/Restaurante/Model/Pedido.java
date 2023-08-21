package br.edu.ifsp.restaurante.Restaurante.Model;

import br.edu.ifsp.restaurante.Restaurante.dto.CardapioRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.PedidoRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.PedidoResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Pedido")
@Entity(name = "Pedido")
public class Pedido {

    public Pedido(String descricao, Cliente cliente, List<Prato> pratos) {
        this.descricao = descricao;
        this.cliente = cliente;
        this.pratos = pratos;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String descricao;

    @JoinColumn(name = "cliente_id") //cria uma chave estrangeira na tabela pedido referenciando a tabela Cliente, se não definisse o nome ficaria o nome do atributo
    @ManyToOne(cascade = CascadeType.ALL) //uma lista de pedidos tem 1 cliente como referencia
    private Cliente cliente;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pedido_prato", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "prato_id"))//usado para criar uma tabela intermediária para duas entidades que se relacionam de n para n
    private List<Prato> pratos;

}
