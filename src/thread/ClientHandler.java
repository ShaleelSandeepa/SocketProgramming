package thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientHandler extends Thread{

    DateFormat forDate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat forTime = new SimpleDateFormat("hh:mm:ss");
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;


    public ClientHandler(DataInputStream dis, DataOutputStream dos, Socket s) {
        this.dis = dis;
        this.dos = dos;
        this.s = s;
    }

    @Override
    public void run() {
        String received;
        String toReturn;

        while (true) {
            try {

                // ask from client what he wants
                dos.writeUTF("What do you want? [ Date | Time ]\n" +
                        "Type Exit to terminate connection.");

                // get answer from client
                received = dis.readUTF();

                if (received.equals("Exit")) {
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection");
                    this.s.close();
                    System.out.println("Connection closed.");
                    break;
                }

                // create date object
                Date date = new Date();

                // write on output stream based on client response
                switch (received) {
                    case "Date":
                        toReturn = forDate.format(date);
                        dos.writeUTF(toReturn);
                        break;

                    case "Time":
                        toReturn = forTime.format(date);
                        dos.writeUTF(toReturn);
                        break;

                    default:
                        dos.writeUTF("Wrong Input !");
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
