import java.io.*;
import java.net.*;

public class TCPServer {

    public static void main(String[] args) {

        try {

            ServerSocket ss =
                new ServerSocket(1027);

            System.out.println("Serveur actif");

            while(true){

                Socket s = ss.accept();

                BufferedReader br =
                    new BufferedReader(
                        new InputStreamReader(
                            s.getInputStream()));

                String msg = br.readLine();

                System.out.println(msg);

                s.close();
            }

        } catch(Exception e){

            System.out.println(e);
        }
    }
}