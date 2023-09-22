import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteThread extends Thread{

    private Socket socket;
    private PrintWriter out;

    public ClienteThread(Socket socket) {
        this.socket = socket;
        try{
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputReader);

            String mensagem;
            while ((mensagem = bufferedReader.readLine()) != null) {
                System.out.println("Cliente: " + mensagem);// Exibe mensagens recebidas do cliente


                Servidor.broadcast(mensagem, this);// Encaminha a mensagem para todos os outros clientes
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    public void enviarMensagem(String mensagem){
        out.println(mensagem);
        }

    }


