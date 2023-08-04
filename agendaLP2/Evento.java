package agendaLP2;

import java.util.Date;

public class Evento extends AgendaFuncoes{
	
	public String nome;
	public String descricao;
	public Date dataHora;
	public String local;
	public Lembrete lembrete;
	
	
	public Evento() {
		super();
		//dar uma olhada em herança como faz depois
	}
	public boolean repeticao;
	

	public Evento(String nome, String descricao, Date dataHora, String local, Lembrete lembrete, boolean repeticao) {
	super();
	this.nome = nome;
	this.descricao = descricao;
	this.dataHora = dataHora;
	this.local = local;
	this.lembrete = lembrete;
	this.repeticao = repeticao;
	}
	
	
	public boolean isRepeticao() {
		return repeticao;
	}
	public void setRepeticao(boolean repeticao) {
		this.repeticao = repeticao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Lembrete getLembrete() {
		return lembrete;
	}
	public void setLembrete(Lembrete lembrete) {
		this.lembrete = lembrete;
	}

}
