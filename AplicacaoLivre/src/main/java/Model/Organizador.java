package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data                           //Lombok, gera automaticamente getters e setters, hashcode, equals, tostring
@NoArgsConstructor              //gera automaticamente um construtor vazio
@AllArgsConstructor             //gera automaticamente um construtor que aceita todos os campos
@Table(name = "Organizador")      //associa a classe a uma tabela
@Entity(name = "Organizador")     //define a classe como uma entidade do Banco de Dados
public class Organizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrganizador;

    @Column
    private String nome;
    @Column
    private String email = "organizador@email.com"; //tirar daqui e colocar em uma main sla
    @Column
    private String senha = "senha123IFSP";

}
