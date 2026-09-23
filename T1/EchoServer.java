import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws Exception {

        int port = 4444;

        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Servidor iniciado na porta " + port);

        while (true) {

            Socket clientSocket = serverSocket.accept();

            System.out.println("Cliente conectado!");

            ClientHandler clientHandler =
                new ClientHandler(clientSocket);

            Thread thread = new Thread(clientHandler);

            thread.start();
        }
    }
}