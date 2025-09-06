package blatt03;
import java.util.Scanner;
public class PQAllgemein {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nennen Sie mir erst a ,dann b ,dann c ,dann d");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        if (a < 1) {
            System.out.println("Starten Sie das Programm neu und geben sie einen anderen Wert für a ein!");
        System.exit(0);
        }
        if (b / a < c / a - (d / a)) {
            System.out.println("Diese Rechnung hat keine Lösung! \nStarten Sie das Programm neu mit anderen werten!");
            System.exit(0);
        }
        double loesung_1 = -((b / a) / 2) + Math.sqrt((b / a) / 2 * ((b / a) / 2) - (c / a - (d / a)));
        double loesung_2 = -((b / a) / 2) - Math.sqrt((b / a) / 2 * ((b / a) / 2) - (c / a - (d / a)));
        if (loesung_1 == loesung_2) {
            System.out.println("Es gibt eine Lösung. Die ist: ");
            System.out.printf("%.2f", loesung_1);
        } else if (loesung_1 != loesung_2) {
            System.out.printf("Die erste Lösung ist: %.2f", loesung_1);
            System.out.println();
            System.out.printf("Die zweite Lösung ist: %.2f", loesung_2);
        }
    }
}
