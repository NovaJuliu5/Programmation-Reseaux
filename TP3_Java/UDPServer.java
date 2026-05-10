import java.net.*;

public class UDPServer {

    public static void main(String[] args) {

        try {

            DatagramSocket ds =
                new DatagramSocket(9876);

            byte[] buffer =
                new byte[1024];

            DatagramPacket dp =
                new DatagramPacket(
                    buffer,
                    buffer.length);

            while(true){

                ds.receive(dp);

                String msg =
                    new String(
                        dp.getData(),
                        0,
                        dp.getLength());

                System.out.println(msg);
            }

        } catch(Exception e){

            System.out.println(e);
        }
    }
}