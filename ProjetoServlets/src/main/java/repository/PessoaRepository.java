package repository;

import model.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {

    private static List<Pessoa> pessoas = new ArrayList<>();

    public static void addPessoa(Pessoa pessoa){
        pessoas.add(pessoa);
    }
    public static List<Pessoa> listarPessoas(){
        return pessoas;
    }

}
