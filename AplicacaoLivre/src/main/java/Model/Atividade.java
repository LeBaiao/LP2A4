package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data                           //Lombok, gera automaticamente getters e setters, hashcode, equals, tostring
@NoArgsConstructor              //gera automaticamente um construtor vazio
@AllArgsConstructor             //gera automaticamente um construtor que aceita todos os campos
@Table(name = "Atividade")      //associa a classe a uma tabela
@Entity(name = "Atividade")     //define a classe como uma entidade do Banco de Dados
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAtividade;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private LocalDate data;

    @Column
    private LocalTime horario;

    @ManyToMany(mappedBy = "atividades") //n participantes podem participar de n atividades
    private List<Participante> participantes;

}
