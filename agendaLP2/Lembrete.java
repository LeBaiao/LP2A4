package agendaLP2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lembrete extends AgendaFuncoes {
	
	private static List<Lembrete> lembretes = new ArrayList<>();
	
	
	public Lembrete(String nome, Date dataHora, boolean lembreteRepeticao) {
		super(nome, dataHora, lembreteRepeticao);
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
	

}
