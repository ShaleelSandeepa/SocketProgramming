import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("client started");
            Socket socket = new Socket("localhost", 9806);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
