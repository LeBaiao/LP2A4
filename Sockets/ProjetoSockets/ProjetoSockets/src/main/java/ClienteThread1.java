import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteThread1 extends Thread{

    private Socket socket;
    public ClienteThread1(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputReader);

            String mensagem;
            while ((mensagem = bufferedReader.readLine()) != null) {
                System.out.println("Cliente 1: " + mensagem);
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }











    }


