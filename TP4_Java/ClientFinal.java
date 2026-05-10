import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientFinal {

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.print("Requête machine : ");
                String req = sc.nextLine();

                if (req.equals("stop")) break;

                Socket s =
                        new Socket("localhost", 1026);

                PrintWriter pw =
                        new PrintWriter(
                                s.getOutputStream(),
                                true);

                BufferedReader br =
                        new BufferedReader(
                                new InputStreamReader(
                                        s.getInputStream()));

                pw.println(req);

                System.out.println(br.readLine());

                s.close();
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}