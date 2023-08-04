package agendaLP2;

import java.util.Date;

public class AgendaFuncoes {

	private String nome;
	private Date dataHora;
	private boolean repeticao;
	
	
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
	public boolean isRepeticao() {
		return repeticao;
	}
	public void setRepeticao(boolean repeticao) {
		this.repeticao = repeticao;
	}
	
	//aqui fica as funcionalidades que tem em todas as classes, ai elas herdam dessa aqui
}
