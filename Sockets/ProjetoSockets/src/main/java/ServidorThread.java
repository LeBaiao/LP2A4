import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServidorThread extends Thread{
    private Socket cliente1;

    public ServidorThread(Socket cliente1){
        this.cliente1 = cliente1;
    }

    @Override
    public void run() {
        try {
            InputStreamReader inputReader = new InputStreamReader(cliente1.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputReader);
            String mensagem;
            while ((mensagem = bufferedReader.readLine()) != null) {
                System.out.println("Servidor: " + mensagem);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
