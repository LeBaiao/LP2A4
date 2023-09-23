import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteThread extends Thread{

    private Socket socket;
    private PrintWriter out; //classe em Java que fornece métodos para escrever dados formatados em texto para uma saída

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
            InputStreamReader inputReader = new InputStreamReader(socket.getInputStream()); //recebe os dados do lado do servidor para o cliente
            BufferedReader bufferedReader = new BufferedReader(inputReader);                //armazena os dados em um buffer temporário antes de enviar, ajuda no desempenho

            String mensagem;
            while ((mensagem = bufferedReader.readLine()) != null) {                        //continua lendo o texto enviado enquanto ele estiver disponível
                System.out.println("Cliente: " + mensagem);                                 // Exibe mensagens recebidas do cliente

                Servidor.broadcast(mensagem, this);                                // Encaminha a mensagem para todos os outros clientes, nao deixa que o "this" que enviou a mensagem receba ela
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    public void enviarMensagem(String mensagem){                                            //usado no broadcast para enviar mensagens aos outros participantes da conexão
        out.println(mensagem);
        }

    }


