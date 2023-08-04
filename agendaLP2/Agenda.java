package agendaLP2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Agenda {
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bem vindo a sua Agenda!");
		System.out.println("O que deseja fazer?");
		System.out.println("Digite o número com a sua opção desejada");
		System.out.println("1- Acessar Tarefas");
		System.out.println("2- Acessar Eventos");
		System.out.println("3- Acessar Lembretes");
		System.out.println("4- Sair do programa");
	
		int valor = sc.nextInt();
		
		switch(valor) {
		case 1:
			System.out.println("----------------TAREFAS--------------------");
			System.out.println("Digite o número com a sua opção desejada");
			System.out.println("1- Criar Tarefa");
			System.out.println("2- Consultar uma tarefa pela data, formato (DD/MM/AAAA)");
			System.out.println("3- Atualizar Tarefa");
			System.out.println("4- Excluir Tarefa");
			break;
		case 2: 
			System.out.println("----------------EVENTOS--------------------");
			System.out.println("Digite o número com a sua opção desejada");
			System.out.println("5- Consultar um evento");
			System.out.println("6- Criar Evento");
			System.out.println("7- Atualizar Evento");
			System.out.println("8- Excluir Evento");
			break;
		case 3:
			System.out.println("--------------LEMBRETES--------------------");
			System.out.println("Digite o número com a sua opção desejada");
			System.out.println("9- Criar Lembrete");
			System.out.println("10- Consultar um Lembrete por sua data. Formato (DD/MM/AAAA)");
			System.out.println("11- Atualizar Lembrete");
			System.out.println("12- Excluir Lembrete");
			break;
		case 4:
			System.out.println("Saindo...");
			break;
		}
		
		valor = sc.nextInt();
		sc.nextLine();
		
		try {
			switch(valor){
			case 1:
				System.out.println("Digite o nome da Tarefa");
				String nomeTarefa = sc.nextLine();
				System.out.println("Digite o dia e horário da Tarefa no formato DD/MM/YYYY HH:mm"); 
				String strDataHoraTarefa = sc.nextLine();
				System.out.println("Digite os detalhes da Tarefa");
				String detalhesTarefa = sc.nextLine();
				System.out.println("A tarefa se repete diariamente? Responda com true ou false");
				boolean repeticaoTarefa = sc.nextBoolean();
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Date dataHoraTarefa = dateFormat.parse(strDataHoraTarefa);

                Tarefa tarefa = new Tarefa(nomeTarefa, dataHoraTarefa, repeticaoTarefa, detalhesTarefa);
                System.out.println("Tarefa criada.");
                break;
                
			case 2:
				System.out.println("Digite a data e horário para consultar a tarefa desejada, no formato DD/MM/YYYY HH:mm respectivamente: "); //arrumar isso aqui pra só pesquisar pela data 
				String strDataHoraConsultaTarefa = sc.nextLine();
				dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Date dataConsultaTarefa = dateFormat.parse(strDataHoraConsultaTarefa);
				
				List<Tarefa> tarefasByData = Tarefa.consultarTarefasPorData(dataConsultaTarefa);
                if (tarefasByData.isEmpty()) {
                    System.out.println("Não há tarefas cadastradas para a data informada.");
                } else {
					System.out.println("Tarefa encontrada: " + strDataHoraConsultaTarefa + ":");
                    for (Tarefa tarefaPorData : tarefasByData) {
                    	 System.out.println(tarefaPorData);
                    }
				}
				break;
				
			case 3: 
			    System.out.println("Digite o nome da tarefa que deseja atualizar:");
			    String nomeTarefaAtualizar = sc.nextLine();

			    Tarefa tarefaAtualizar = Tarefa.buscarTarefa(nomeTarefaAtualizar);
			    if (tarefaAtualizar == null) {
			        System.out.println("Tarefa não encontrada.");
			    } else {
			        System.out.println("Digite a nova data e horario da tarefa no formato dd/MM/yyyy HH:mm: ");
			        String strNovaDataHorario = sc.nextLine();
			        System.out.println("Digite os novos detalhes da tarefa:");
			        String novosDetalhes = sc.nextLine();
			        System.out.println("A tarefa se repete? (true/false):");
			        boolean novaRepeticao = sc.nextBoolean();

			        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			        Date novaDataHorario = dateFormat.parse(strNovaDataHorario);


			        if (Tarefa.atualizarTarefa(nomeTarefaAtualizar, novaDataHorario, novosDetalhes, novaRepeticao)) {
			            System.out.println("Tarefa atualizada com sucesso:");
			            System.out.println(tarefaAtualizar);
			        } else {
			            System.out.println("Falha ao atualizar a tarefa. Tarefa não encontrada.");
			        }
			    }
			    break;
			    
			case 4: 
			
			    System.out.println("Digite o nome da tarefa que deseja excluir:");
			    String nomeTarefaExcluir = sc.nextLine();

			    if (Tarefa.excluirTarefa(nomeTarefaExcluir)) {
			        System.out.println("Tarefa excluída com sucesso.");
			    } else {
			        System.out.println("Falha na exclusão, tarefa não encontrada :(");
			    }
			    break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9: //criar
				System.out.println("Digite o nome do Lembrete");
				String nomeLembrete = sc.nextLine();
				System.out.println("Digite o dia e horário do Lembrete no formato DD/MM/YYYY HH:mm"); 
				String strDiaHoraLembrete = sc.nextLine();
				System.out.println("O lembrete se repete diariamente? Responda com true ou false");
				boolean repeticaoLembrete = sc.nextBoolean();
				
				dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Date dataHoraLembrete = dateFormat.parse(strDiaHoraLembrete);
				
                Lembrete lembrete = new Lembrete(nomeLembrete, dataHoraLembrete, repeticaoLembrete);
                System.out.println("Lembrete criado!");
                break;
                
			case 10: //consultar
				System.out.println("Digite a data para consultar o lembrete desejado: ");
				String strDataConsultaLembrete = sc.nextLine();
				dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date dataConsultaLembrete = dateFormat.parse(strDataConsultaLembrete);
				
				List<Lembrete> lembretesByData = Lembrete.consultarLembretesByData(dataConsultaLembrete);
                if (lembretesByData.isEmpty()) {
                    System.out.println("Não há lembretes cadastradas para a data informada.");
                } else {
					System.out.println("Lembrete encontrado: " + strDataConsultaLembrete + ":");
                    for (Lembrete lembretePorData : lembretesByData) {
                    	 System.out.println(lembretePorData); ////ver se ta certo dps
                    }
				}
				break;
			case 11: //atualizar
			    System.out.println("Digite o nome do lembrete que deseja atualizar:");
			    String nomeLembreteAtualizar = sc.nextLine();

			    Lembrete lembreteAtualizar = Lembrete.buscarLembrete(nomeLembreteAtualizar);
			    if (lembreteAtualizar == null) {
			        System.out.println("Lembrete não encontrado :(");
			    } else {
			        System.out.println("Digite a nova data e horário do lembrete no formato dd/MM/yyyy HH:mm:");
			        String strNovaDataHoraLembrete = sc.nextLine();
			        System.out.println("O lembrete se repete? Responda com true ou false:");
			        boolean novaRepeticaoLembrete = sc.nextBoolean();

			        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			        Date novaDataHoraLembrete = dateFormat.parse(strNovaDataHoraLembrete);

			        if (Lembrete.atualizarLembrete(nomeLembreteAtualizar, novaDataHoraLembrete, novaRepeticaoLembrete)) {
			            System.out.println("Lembrete atualizado com sucesso:");
			            System.out.println(lembreteAtualizar);
			        } else {
			            System.out.println("Falha ao atualizar o lembrete. Lembrete não encontrado :(");
			        }
			    }
				break;
			case 12: //excluir
			    System.out.println("Digite o nome do lembrete que deseja excluir:");
			    String nomeLembreteExcluir = sc.nextLine();

			    if (Lembrete.excluirLembrete(nomeLembreteExcluir)) {
			        System.out.println("Lembrete excluído com sucesso!");
			    } else {
			        System.out.println("Falha na exclusão, lembrete não encontrado :(");
			    }
				break;  
			}
		}catch (Exception e) {
			System.out.println("Ocorreu um erro: " +e.getMessage());
		}	
	}
}
