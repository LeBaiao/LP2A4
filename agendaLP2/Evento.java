package agendaLP2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evento extends AgendaFuncoes{
	
	public String descricao;
	public String local;
	private static List<Evento> eventos = new ArrayList<>();
	
	
	public Evento(String nome, String descricaoEvento, Date dataHoraEvento, boolean repeticaoEvento, String local) {
		super(nome, dataHoraEvento, repeticaoEvento);
		this.descricao = descricaoEvento;
		this.local = local;
	}


	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	public static boolean atualizarEvento(String nome, Date dataHoraEvento, String detalhesEvento, boolean repeteEvento) {
		Evento evento = buscarEvento(nome);
		if(evento != null) {
			evento.setNome(nome);
			evento.setDataHora(dataHoraEvento);
			evento.setDescricao(detalhesEvento);
			evento.setRepeticao(repeteEvento);
			return true;
		}else return false;
	}
	
	public static boolean excluirEvento(String nome) {
		Evento evento = buscarEvento(nome);
		if(evento != null) {
			eventos.remove(evento);
			return true;
		}else return false;
	}
	
	public static Evento buscarEvento(String nome) {
		for(Evento evento : eventos) {
			if(evento.getNome().equalsIgnoreCase(nome)) {
				return evento;
			}
		}
		return null;
	}
	
	public static List<Evento> consultarEventosByData(Date dataHoraEvento){
		List<Evento> eventosPorData = new ArrayList<>();
		for (Evento evento : eventos) {
			if(evento.getDataHora().equals(dataHoraEvento)) {
				eventosPorData.add(evento);
			}
		}
		return eventosPorData;
	}
	
	
	
	
	
}
