import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientMulti {

    public static void main(String[] args) {

        try {

            Socket s =
                    new Socket("localhost", 1027);

            PrintWriter pw =
                    new PrintWriter(
                            s.getOutputStream(),
                            true);

            BufferedReader br =
                    new BufferedReader(
                            new InputStreamReader(
                                    s.getInputStream()));

            Scanner sc = new Scanner(System.in);

            // Thread réception
            new Thread(() -> {

                try {

                    String msg;

                    while ((msg = br.readLine()) != null) {

                        System.out.println(msg);
                    }

                } catch (Exception e) {}
            }).start();

            String input;

            while (true) {

                input = sc.nextLine();

                pw.println(input);

                if (input.equals("stop")) break;
            }

            s.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}