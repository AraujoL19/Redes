import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

    public static void main(String[] args) throws Exception {

        String host = "localhost";
        int port = 4444;

        Socket socket = new Socket(host, port);

        BufferedReader keyboard = new BufferedReader(
            new InputStreamReader(System.in)
        );

        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream())
        );

        PrintWriter out = new PrintWriter(
            socket.getOutputStream(),
            true
        );

        System.out.println("Conectado ao servidor.");

        String message;

        while ((message = keyboard.readLine()) != null) {

            out.println(message);

            if (message.equals("quit")) {
                break;
            }

            String response = in.readLine();

            System.out.println("Resposta: " + response);
        }

        socket.close();

        System.out.println("Conexão encerrada.");
    }
}