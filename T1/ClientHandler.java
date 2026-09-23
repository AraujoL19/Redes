import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        try {

            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
            );

            PrintWriter out = new PrintWriter(
                clientSocket.getOutputStream(),
                true
            );

            String message;

            while ((message = in.readLine()) != null) {

                System.out.println("Recebido: " + message);

                if (message.startsWith("echo ")) {

                    String text = message.substring(5);

                    out.println(text);

                } else if (message.equals("quit")) {

                    break;

                } else {

                    out.println("Comando desconhecido.");
                }
            }

            clientSocket.close();

            System.out.println("Cliente desconectado.");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}