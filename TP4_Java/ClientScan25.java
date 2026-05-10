import java.net.*;
import java.util.Scanner;

public class ClientScan25 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Adresse de base : ");
            String base = sc.nextLine();

            String prefix =
                    base.substring(0, base.lastIndexOf(".") + 1);

            for (int i = 1; i <= 25; i++) {

                String host = prefix + i;

                try {

                    Socket s = new Socket(host, 1027);

                    System.out.println(host + " ACTIF");

                    s.close();

                } catch (Exception e) {

                    System.out.println(host + " INACTIF");
                }
            }

        } catch (Exception e) {

            System.out.println(e);
        }

        sc.close();
    }
}