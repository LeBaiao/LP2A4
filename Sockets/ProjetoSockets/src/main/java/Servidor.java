import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) throws IOException {     //obriga a usar a exception para caso a porta de erro


        ServerSocket serverSocket = new ServerSocket(4000);     //porta que será conectada, serverSocket só será usada no servidor
        System.out.println("Servidor operando na porta 4000");


        Socket socketCliente1 = serverSocket.accept();               //quando o cliente conectar com o servidor, o programa vai passar dessa linha, senão vai ficar esperando
        System.out.println("Cliente 1 conectado!");

//        Socket socketServidor = serverSocket.accept();
//        System.out.println("Servidor conectou!");

        Scanner scanner = new Scanner(System.in);
        ClienteThread1 clienteThread1 = new ClienteThread1(socketCliente1);
        clienteThread1.start();

//        ServidorThread servidorThread = new ServidorThread(socketServidor);
//        servidorThread.start();


        PrintStream saida = new PrintStream(socketCliente1.getOutputStream()); //permite enviar dados para o outro lado da conexão
        //PrintStream saidaServidor = new PrintStream(socketServidor.getOutputStream());

        while (true) {
            String teclado = scanner.nextLine();
            saida.println(teclado);
            //saidaServidor.println(teclado);
        }


    }
}
