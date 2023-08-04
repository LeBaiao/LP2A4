package agendaLP2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tarefa extends AgendaFuncoes{
	
	public String nome;
	public Date dataHora;
	public boolean repeticaoTarefa = false;
	public String detalhes;
	private static List<Tarefa> tarefas = new ArrayList<>();
	
	
	public Tarefa(String nome, Date dataHora, boolean repeticaoTarefa, String detalhes) {
		super();
		this.nome = nome;
		this.dataHora = dataHora;
		this.repeticaoTarefa = repeticaoTarefa;
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
    
    public static List<Tarefa> consultarTarefasPorData(Date dataHora) {//Ver com a Thamiris se ela deixou a consulta pela data com a hora junto 
        List<Tarefa> tarefasPorDataHora = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDataHora().equals(dataHora)) {
                tarefasPorDataHora.add(tarefa);
            }
        }
        return tarefasPorDataHora;
    }
    
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	
    public boolean isRepeticao() {
        return repeticaoTarefa;
    }

    public void setRepeticao(boolean repeticao) {
        this.repeticaoTarefa = repeticao;
    }
	
	
}


