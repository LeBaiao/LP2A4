package agendaLP2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lembrete extends AgendaFuncoes {
	
	public String nome;
	public Date dataHora;
	public boolean lembreteRepeticao = false;
	private static List<Lembrete> lembretes = new ArrayList<>();
	
	
	public Lembrete(String nome, Date dataHora, boolean lembreteRepeticao) {
		super();
		this.nome = nome;
		this.dataHora = dataHora;
		this.lembreteRepeticao = lembreteRepeticao;
		lembretes.add(this);
	}
	
	public static boolean atualizarLembrete(String nome, Date dataHoraLembrete, boolean repeteLembrete) {
		Lembrete lembrete = buscarLembrete(nome);
		if(lembrete != null) {
			lembrete.setDataHora(dataHoraLembrete);
			lembrete.setRepeticao(repeteLembrete);
			return true;
		}else return false;
	}
	
	public static boolean excluirLembrete(String nome) {
		Lembrete lembrete = buscarLembrete(nome);
		if(lembrete != null) {
			lembretes.remove(lembrete);
			return true;
		}else return false;
	}
	
	public static Lembrete buscarLembrete(String nome) {
		for(Lembrete lembrete : lembretes) {
			if(lembrete.getNome().equalsIgnoreCase(nome)) {
				return lembrete;
			}
		}
		return null;
	}
	
	public static List<Lembrete> consultarLembretesByData(Date dataHoraLembrete){
		List<Lembrete> lembretesPorData = new ArrayList<>();
		for (Lembrete lembrete : lembretes) {
			if(lembrete.getDataHora().equals(dataHoraLembrete)) {
				lembretesPorData.add(lembrete);
			}
		}
		return lembretesPorData;
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
	
	public void setRepeticao(boolean repeticao) {
		this.lembreteRepeticao = repeticao;
	}

}
