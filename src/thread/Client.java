package thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        try {

            // assign new scanner
            Scanner scn = new Scanner(System.in);

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            // establish the connection with server port 5056
            Socket s = new Socket(ip, 5056);

            // obtaining input and output streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            // this loop performs the exchange the information between client and client handler
            while (true) {

                System.out.println(dis.readUTF());
                String toSend = scn.nextLine();
                dos.writeUTF(toSend);

                // if client send Exit, close the connection and break from the loop
                if (toSend.equals("Exit")) {
                    System.out.println("Closing this connection " + s);
                    s.close();
                    System.out.println("Connection closed !");
                    break;
                }

                String received = dis.readUTF();
                System.out.println(received);

            }

            // closing resources
            s.close();
            dis.close();
            dos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
