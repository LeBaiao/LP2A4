package Repository;

import Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
    private static List<Usuario> usuarios = new ArrayList<>();

    public void adicionarUsuario(Usuario usuario){}

    public void buscarUsuario(Long idUsuario){}
    public void listarUsuarios(){}

    public List<Usuario> listarOrganizadores(){
        List<Usuario> organizadores = new ArrayList<>();
        Usuario organizador = new Usuario("Leticia Baiao", "lebaiao@email.com", "exemplo123", true);
        usuarios.add(organizador);

        for (Usuario org : usuarios){
            if(org.isOrganizador()){
                organizadores.add(org);
            }
        }
        return organizadores;
    }


}
