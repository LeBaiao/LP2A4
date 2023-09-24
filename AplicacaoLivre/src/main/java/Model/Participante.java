package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data                               //Lombok, gera automaticamente getters e setters, hashcode, equals, tostring
@NoArgsConstructor                  //gera automaticamente um construtor vazio
@AllArgsConstructor                 //gera automaticamente um construtor que aceita todos os campos
@Table(name = "Participante")      //associa a classe a uma tabela
@Entity(name = "Participante")     //define a classe como uma entidade do Banco de Dados
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idParticipante;
    @Column
    private String nome;
    @Column
    private String cpf;
    @Column
    private String email;
    @Column
    private String senha;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "participante_atividade", joinColumns = @JoinColumn(name = "participante_id"), inverseJoinColumns = @JoinColumn(name = "atividade_id"))
    private List<Atividade> atividades;


}
