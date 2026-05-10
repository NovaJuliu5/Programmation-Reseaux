// MulticastReceiver.java
// paramètres : @multicast classe D, port d'écoute

import java.net.*;

public class MulticastReceiver {

    public static void main(String[] args) {

        try {

            boolean done = false;

            // paquet de réception
            byte[] buffer = new byte[1024];

            DatagramPacket dp =
                    new DatagramPacket(buffer, buffer.length);

            InetAddress ia =
                    InetAddress.getByName(args[0]);

            int port = Integer.parseInt(args[1]);

            MulticastSocket ms =
                    new MulticastSocket(port);

            // option reuse address
            ms.setReuseAddress(true);

            ms.joinGroup(ia);

            System.out.println("Joined multicast group " + ia);

            while (!done) {

                ms.receive(dp);

                System.out.println(
                        "Received "
                                + dp.getLength()
                                + " bytes from "
                                + dp.getAddress()
                                + " : "
                                + new String(dp.getData(), 0, dp.getLength())
                );
            }

            ms.leaveGroup(ia);

            ms.close();

        } catch (Exception e) {

            System.err.println(e);
        }
    }
}