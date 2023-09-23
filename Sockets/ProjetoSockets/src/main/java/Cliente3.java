import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente3 {

    public static void main(String[] args) {

        try{
            Socket socket = new Socket("localhost", 4000);
            Scanner scanner = new Scanner(System.in);

            ClienteThread clienteThread = new ClienteThread(socket);
            clienteThread.start();

            PrintStream saida = new PrintStream(socket.getOutputStream());

            while(true){
                String teclado = scanner.nextLine();
                saida.println(teclado);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
