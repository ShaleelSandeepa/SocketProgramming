package tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws Exception {

        String clientSentence;
        String capitalizedSentence;

        System.out.println("waiting for clients");
        ServerSocket welcomeSocket = new ServerSocket(9806);

        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            System.out.println("connection is established");
            System.out.println("getting client data...");

            // to read the string client sent
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            clientSentence = inFromClient.readLine();
            capitalizedSentence = clientSentence.toUpperCase() + '\n';

            outToClient.writeBytes(capitalizedSentence);


        }

    }
}
