package blatt04;
import java.util.Scanner;
public class Dart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Erzeuge Scanner

        int punkte = 501; //Variable "punkte" mit 501 initialisiert -->Startwert
        while (true) {
            System.out.println("Gebe deine Punktzahl ein (0-180)");
            int wurf = scanner.nextInt();//Setzt die Variable "wurf" auf den eingegebenen Wert (Es kann angenommen, dass nur gültige Werte eingegeben werden)
            if (wurf > 180)
            if (wurf <= punkte) {
                punkte -= wurf;
            }
            System.out.println("Punkte: " + punkte);
            if (punkte == 0) {
                break;
            }
        }
        System.out.println("Du hast Gewonnen!");
    }
}
