package thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {

        // server is listening on port 5056
        ServerSocket ss = new ServerSocket(5056);

        // running infinite loop for getting clients requests
        while (true) {

            Socket s = null;

            try {

                // socket object to receive incoming client request
                s = ss.accept();

                System.out.println("A new client is connected : " + s);

                // obtaining input and output stream
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                System.out.println("Assign in new thread for this client");

                // create a new thread object
                Thread t = new ClientHandler(dis, dos, s);
                t.start();

            } catch (Exception e) {
                s.close();
                e.printStackTrace();
            }

        }

    }
}
