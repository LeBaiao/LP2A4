import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente1 {

    public static void main(String[] args) throws IOException {

        try {
            Socket socket = new Socket("localhost", 4000);        //a porta definida no servidor
            Scanner scanner = new Scanner(System.in);


            ClienteThread clienteThread = new ClienteThread(socket);
            clienteThread.start();                                          //o método start tem a lógica de receber a mensagem

            PrintStream saida = new PrintStream(socket.getOutputStream()); //permite enviar dados para o outro lado da conexão


            while (true) {
                String teclado = scanner.nextLine();
                saida.println(teclado);//envia mensagens para o servidor
            }
        }catch (Exception e){
            e.printStackTrace();
        }




    }

}
