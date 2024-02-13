import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("waiting for clients requests");
            ServerSocket serverSocket = new ServerSocket(9806);
            Socket socket = serverSocket.accept();
            System.out.println("connection is established");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
