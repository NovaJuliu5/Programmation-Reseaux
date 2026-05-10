import java.io.*;
import java.net.*;
import java.time.*;

public class ServeurTCP {

    public static void main(String[] args) {

        try {

            ServerSocket ss =
                    new ServerSocket(1027);

            System.out.println("Serveur en écoute...");

            while (true) {

                Socket s = ss.accept();

                PrintWriter pw =
                        new PrintWriter(
                                s.getOutputStream(),
                                true);

                String message =
                        "Serveur actif - Heure : "
                                + LocalTime.now();

                pw.println(message);

                s.close();
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}