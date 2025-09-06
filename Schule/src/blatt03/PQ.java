package blatt03;
import java.util.Scanner;
public class PQ {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nennen Sie mir erst p und dann q!");
        double p =  input.nextDouble();
        double q = input.nextDouble();
        if (p < q) { //wenn p kleiner q ist, ist ein Minus unter der Wurzel
            System.out.println("Diese Rechnung hat keine Lösung! \nStarten Sie das Programm neu mit anderen werten!");
            System.exit(0);
        }
        double loesung_1 = -p / 2 + Math.sqrt((p / 2 * p /2) - q); //pq-formel ausrechnen
        double loesung_2 = -p / 2 - Math.sqrt((p / 2 * p /2) - q);
        if (loesung_1 == loesung_2) { //wenn es das gleiche ergebnis ist gibt es nur eine Lösung
            System.out.print("Es gibt eine Lösung. Die ist: ");
            System.out.printf("%.2f", loesung_1);
        }
        System.out.printf("Die erste Lösung ist:  %.2f", loesung_1); //es wird auf zwei Nachkommastellen gerundet
        System.out.println();
        System.out.printf("Die zweite Lösung ist:  %.2f", loesung_2);
    }
}
