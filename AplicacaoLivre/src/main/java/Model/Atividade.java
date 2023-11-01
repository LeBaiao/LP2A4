package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data                           //Lombok, gera automaticamente getters e setters, hashcode, equals, tostring
@NoArgsConstructor              //gera automaticamente um construtor vazio
@AllArgsConstructor             //gera automaticamente um construtor que aceita todos os campos
@Table(name = "Atividade")      //associa a classe a uma tabela
@Entity(name = "Atividade")     //define a classe como uma entidade do Banco de Dados
public class Atividade {

    private static Long idClasse = 0L;
    private Long idAtividade;

    private String descricao;

    private LocalDate dia;

    private LocalTime hora;

    private List<Usuario> participantes = new ArrayList<>();


    public Atividade(String descricao, LocalDate dia, LocalTime hora) {
        this.descricao = descricao;
        this.dia = dia;
        this.hora = hora;
        this.idAtividade = idClasse++;
    }

    public void adicionaParticipante(Usuario usuario){
        participantes.add(usuario);
    }

    public String getDia() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dia.format(formatter);
    }

    public String getHora() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return hora.format(formatter);
    }
    public List<Usuario> getParticipantes() {
        return participantes;
    }
}
