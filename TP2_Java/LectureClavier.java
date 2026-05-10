import java.util.Scanner;

public class LectureClavier {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String texte;

        do {

            System.out.print("Entrer : ");

            texte = sc.nextLine();

            System.out.println(texte);

        } while(!texte.equals("stop"));

        sc.close();
    }
}