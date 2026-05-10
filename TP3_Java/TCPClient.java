import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {

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

            while(true){

                String msg =
                    sc.nextLine();

                pw.println(msg);
            }

        } catch(Exception e){

            System.out.println(e);
        }
    }
}