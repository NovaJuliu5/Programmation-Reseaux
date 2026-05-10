import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientA {

    public static void main(String[] args) {

        try {

            Socket s =
                new Socket("localhost",1027);

            PrintWriter pw =
                new PrintWriter(
                    s.getOutputStream(),
                    true);

            Scanner sc =
                new Scanner(System.in);

            String msg;

            do {

                msg = sc.nextLine();

                pw.println(msg);

            } while(!msg.equals("stop"));

            s.close();
            sc.close();

        } catch(Exception e){

            System.out.println(e);
        }
    }
}