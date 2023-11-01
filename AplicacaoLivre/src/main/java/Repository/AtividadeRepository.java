package Repository;

import Model.Atividade;
import Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AtividadeRepository {
    private static List<Atividade> atividades = new ArrayList<>();
    public static void addAtividade (Atividade atividade){
        atividades.add(atividade);
    }
    public static List<Atividade> listarAtividades(){
        return atividades;
    }

    public Atividade buscarAtividade(Long id){
        for(Atividade atividade : atividades){
            if(atividade.getIdAtividade() == id){
                return atividade;
            }
        }
        return null;
    }

    public void addParticipante(Long id, Usuario usuario){
        Atividade atividade = buscarAtividade(id);
        if (atividade != null) {
            atividade.adicionaParticipante(usuario);
        } else {
            throw  new RuntimeException("ID não encontrado para a atividade :(");
        }
    }

}
