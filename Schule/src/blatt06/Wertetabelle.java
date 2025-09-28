package blatt06;
import java.util.Scanner;
public class Wertetabelle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welchen Grad soll das Polynom haben?");
        int n = input.nextInt();

        double[] koeff = new double[n + 1];

        for (int i = 0; i < koeff.length; i++) {
            System.out.println("Nenne den Koeffizient " + i + ":");
            koeff[i] = input.nextDouble();
        }

        System.out.println("Gib die Grenzen der Wertetabelle ein.");
        int unten = input.nextInt();
        int oben = input.nextInt();

        if (unten > oben) {
            int tmp = unten;
            unten = oben;
            oben = tmp;
        }
        for (int x = unten; x <= oben; x++) {
            double ergebnis = 0;
            for (int i = n; i >= 0; i--) {
                ergebnis += koeff[i] * Math.pow(x, i);

            }
            System.out.println(x + ": " + ergebnis);
        }
    }
}