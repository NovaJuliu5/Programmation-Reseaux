import java.io.*;
import java.net.*;

public class ServeurB {

    public static void main(String[] args) {

        try {

            ServerSocket ss =
                new ServerSocket(1027);

            Socket s = ss.accept();

            BufferedReader br =
                new BufferedReader(
                    new InputStreamReader(
                        s.getInputStream()));

            String msg;

            while((msg = br.readLine()) != null){

                System.out.println(msg);

                if(msg.equals("stop")){
                    break;
                }
            }

            s.close();
            ss.close();

        } catch(Exception e){

            System.out.println(e);
        }
    }
}