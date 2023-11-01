package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data                           //Lombok, gera automaticamente getters e setters, hashcode, equals, tostring
@NoArgsConstructor              //gera automaticamente um construtor vazio
@AllArgsConstructor
@Entity(name = "usuario")
@Table(name = "usuario")
public class Usuario {

    private static Long idClasse = 0L;

    private Long idUsuario;

    private String nome;

    private String email;

    private String senha;

    private boolean organizador;


    public boolean isOrganizador(){
        return organizador;
    }

        public Usuario(String nome, String email, String senha, boolean organizador) {
            this.nome = nome;
            this.email = email;
            this.senha = senha;
            this.organizador = organizador;
            this.idUsuario = idClasse++;
        }

    }
