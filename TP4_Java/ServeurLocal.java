import java.io.*;
import java.net.*;

public class ServeurLocal {

    public static void main(String[] args) {

        try {

            ServerSocket ss =
                    new ServerSocket(1026);

            System.out.println("Serveur local actif...");

            while (true) {

                Socket client = ss.accept();

                BufferedReader br =
                        new BufferedReader(
                                new InputStreamReader(
                                        client.getInputStream()));

                PrintWriter pw =
                        new PrintWriter(
                                client.getOutputStream(),
                                true);

                String requete = br.readLine();

                // simulation réponse réseau externe
                pw.println("INFO MACHINE : OK -> " + requete);

                client.close();
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}