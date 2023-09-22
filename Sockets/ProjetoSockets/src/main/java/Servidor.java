import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Servidor {

    public static List<ClienteThread> clientes = new ArrayList<>();

    public static void main(String[] args) throws IOException {     //obriga a usar a exception para caso a porta de erro

        ServerSocket serverSocket = new ServerSocket(4000);     //porta que será conectada, serverSocket só será usada no servidor
        System.out.println("Servidor operando na porta 4000");

    while(true) {
        Socket socketCliente = serverSocket.accept();               //quando o cliente conectar com o servidor, o programa vai passar dessa linha, senão vai ficar esperando
        System.out.println("Cliente conectado :) ");

        ClienteThread clienteThread = new ClienteThread(socketCliente);
        clientes.add(clienteThread);
        clienteThread.start();
    }
    }

    public static void broadcast(String mensagem, ClienteThread remetente){
        for (ClienteThread cliente : clientes){
            if(cliente != remetente){
                cliente.enviarMensagem(mensagem);
            }
        }
    }
}
