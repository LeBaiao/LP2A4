import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Servidor {

    public static List<ClienteThread> clientes = new ArrayList<>();     //deixa que x clientes se conectem ao servidor usando threads

    public static void main(String[] args) throws IOException {         //obriga a usar a exception para caso a porta de erro

        ServerSocket serverSocket = new ServerSocket(4000);         //porta que será conectada, serverSocket só será usada no servidor
        System.out.println("Servidor operando na porta 4000");

    while(true) { //loop infinito aguardando as conexões dos clientes
        Socket socketCliente = serverSocket.accept();
        System.out.println("Cliente conectado :) ");

        ClienteThread clienteThread = new ClienteThread(socketCliente);  //para todo cliente conectado, é criado uma instancia da classe thread
        clientes.add(clienteThread);
        clienteThread.start();
    }
    }

    public static void broadcast(String mensagem, ClienteThread remetente){ //manda uma mensagem a todos os clientes, menos ao remetente
        for (ClienteThread cliente : clientes){                             //itera sob todos os clientes e  envia uma mensagem p cada um usando o metodo
            if(cliente != remetente){                                       //garante que a mensagem nao sera enviada dnv ao remetente
                cliente.enviarMensagem(mensagem);
            }
        }
    }

    //***Socket: abstração da comunicação de rede que permite que computadores se comuniquem
    //com os outro através de uma rede, como internet etc. Aqui está sendo usado para conectar os clientes ao servidor permitindo
    //a transferencia de dados entre eles

    //***Thread: unidade de execução de um programa, usadas para permitir que um programa execute multiplas
    //tarefas simultaneamente, aproveitando recursos de CPU de forma eficiente, no contexto desse programa
    //é usada para lidar com várias conexões de clientes no servidor, só precisa de uma classe thread que gerencie tudo

}
