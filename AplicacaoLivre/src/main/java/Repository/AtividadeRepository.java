package Repository;

import Model.Atividade;
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

//    public static Cliente getClientePorCpf(String cpf){
//        for (Cliente c: clientes) {
//            if(c.getCpf().equals(cpf)){
//                return c;
//            }
//        } return null;
//    }

}
