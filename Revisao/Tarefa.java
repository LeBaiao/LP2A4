package agendaLP2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tarefa extends AgendaFuncoes{
	
	public String detalhes;
	private static List<Tarefa> tarefas = new ArrayList<>();
	
	
	public Tarefa(String nome, Date dataHora, boolean repeticaoTarefa, String detalhes) {
		super(nome, dataHora, repeticaoTarefa);
		this.detalhes = detalhes;
		tarefas.add(this);
	}

	
    public static boolean atualizarTarefa(String nome, Date dataHora, String detalhes, boolean repeticao) {
        Tarefa tarefa = buscarTarefa(nome);
        if (tarefa != null) {
            tarefa.setDataHora(dataHora);
            tarefa.setDetalhes(detalhes);
            tarefa.setRepeticao(repeticao); //boolean por causa desse aqui
            return true;
        }else return false;
    }
    
    public static boolean excluirTarefa(String nome) {
    	Tarefa tarefa = buscarTarefa(nome);
    	if (tarefa != null) {
    		tarefas.remove(tarefa);
    		return true;
    	} else return false;
    }
    
    public static Tarefa buscarTarefa(String nome) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getNome().equalsIgnoreCase(nome)) {
                return tarefa;
            }
        }
        return null;
    }
    
    public static List<Tarefa> consultarTarefas() {
        return tarefas;
    }
    
    public static List<Tarefa> consultarTarefasPorData(Date dataHora) {
        List<Tarefa> tarefasPorDataHora = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDataHora().equals(dataHora)) {
                tarefasPorDataHora.add(tarefa);
            }
        }
        return tarefasPorDataHora;
    }
    
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	
	
	
}


