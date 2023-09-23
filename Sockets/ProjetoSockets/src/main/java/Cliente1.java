import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente1 {
    //todas as classes de cliente são iguais, até porque a logica de cada uma é a mesma, o que gerencia todas é a thread

    public static void main(String[] args) throws IOException {

        try {
            Socket socket = new Socket("localhost", 4000);        //a porta definida no servidor
            Scanner scanner = new Scanner(System.in);


            ClienteThread clienteThread = new ClienteThread(socket);
            clienteThread.start();                                          //o método start tem a lógica de receber a mensagem

            PrintStream saida = new PrintStream(socket.getOutputStream()); //permite enviar dados para o outro lado da conexão


            while (true) {                                                  //loop infinito para sempre poder enviar mensagens
                String teclado = scanner.nextLine();                        //lê a mensagem escrita no console e armazena na variavel
                saida.println(teclado);                                     //envia mensagens para o servidor
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //getOutputStream() é usado para enviar dados do cliente para o servidor
    //getInputStream() é usado para receber dados do lado do servidor para o cliente
}
