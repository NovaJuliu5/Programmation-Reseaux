import java.net.*;
import java.util.Scanner;

public class Exercice1_InetAddress {

    public static void main(String[] args) {

        try {

            InetAddress local =
                    InetAddress.getLocalHost();

            System.out.println("Machine locale : "
                    + local.getHostAddress());

            Scanner sc = new Scanner(System.in);
            String nom;

            while (true) {

                System.out.print("Nom machine (stop pour quitter) : ");
                nom = sc.nextLine();

                if (nom.equals("stop")) break;

                InetAddress ia =
                        InetAddress.getByName(nom);

                System.out.println("Adresse : "
                        + ia.getHostAddress());
            }

            sc.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}