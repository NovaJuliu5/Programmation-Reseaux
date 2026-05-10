import java.io.*;
import java.net.*;
import java.time.*;

class ClientHandler extends Thread {

    Socket s;

    ClientHandler(Socket s) {
        this.s = s;
    }

    public void run() {

        try {

            PrintWriter pw =
                    new PrintWriter(
                            s.getOutputStream(),
                            true);

            BufferedReader br =
                    new BufferedReader(
                            new InputStreamReader(
                                    s.getInputStream()));

            String msg;

            while ((msg = br.readLine()) != null) {

                if (msg.equals("stop")) break;

                pw.println("Serveur : "
                        + LocalTime.now()
                        + " -> " + msg);
            }

            s.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}

public class ServeurMulti {

    public static void main(String[] args) {

        try {

            ServerSocket ss =
                    new ServerSocket(1027);

            System.out.println("Serveur multi-clients...");

            while (true) {

                Socket s = ss.accept();

                new ClientHandler(s).start();
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}