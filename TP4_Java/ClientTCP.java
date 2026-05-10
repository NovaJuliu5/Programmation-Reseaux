import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientTCP {

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.print("Adresse machine : ");
                String addr = sc.nextLine();

                if (addr.equals("stop")) break;

                Socket s =
                        new Socket(addr, 1027);

                BufferedReader br =
                        new BufferedReader(
                                new InputStreamReader(
                                        s.getInputStream()));

                String msg = br.readLine();

                System.out.println("Réponse serveur : " + msg);

                s.close();
            }

            sc.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}