import java.net.*;
import java.util.Scanner;

public class UDPClient {

    public static void main(String[] args) {

        try {

            DatagramSocket ds =
                new DatagramSocket();

            InetAddress ia =
                InetAddress.getByName("localhost");

            Scanner sc =
                new Scanner(System.in);

            while(true){

                String msg =
                    sc.nextLine();

                byte[] data =
                    msg.getBytes();

                DatagramPacket dp =
                    new DatagramPacket(
                        data,
                        data.length,
                        ia,
                        9876);

                ds.send(dp);
            }

        } catch(Exception e){

            System.out.println(e);
        }
    }
}