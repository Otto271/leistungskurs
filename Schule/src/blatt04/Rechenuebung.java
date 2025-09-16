package blatt04;
import java.util.Scanner;
public class Rechenuebung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Gebe zwei Zahlen an die Multipliziert werden sollen!");
        double zahl_1 = input.nextDouble();
        double zahl_2 = input.nextDouble();
        double antwort;
        double ergebnis = zahl_1 * zahl_2;
        while (true) {
            System.out.println("Gebe die Lösung von " + zahl_1 + " * " +  zahl_2 + " ein.");
            antwort = input.nextDouble();
            if (antwort == ergebnis) {
                System.out.println("Gut! Die Lösung ist " + ergebnis + "!");
                break;
            }
        }
    }
}
