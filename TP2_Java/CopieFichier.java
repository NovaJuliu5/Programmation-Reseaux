import java.io.*;
import java.util.Scanner;

public class CopieFichier {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Source : ");
            String in = sc.nextLine();

            System.out.print("Destination : ");
            String out = sc.nextLine();

            BufferedReader br =
                new BufferedReader(
                    new FileReader(in));

            PrintStream ps =
                new PrintStream(out);

            String ligne;

            while((ligne = br.readLine()) != null){

                ps.println(ligne);
            }

            br.close();
            ps.close();

        } catch(Exception e){

            System.out.println(e);
        }

        sc.close();
    }
}