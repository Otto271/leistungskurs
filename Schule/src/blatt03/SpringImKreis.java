package blatt03;
import java.util.Scanner;
public class SpringImKreis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Was soll der Kreis für einen Radius haben!");
        double radius = input.nextDouble();
        System.out.println("Nennen sie eine x-Koordinate!");
        double x = input.nextDouble();
        System.out.println("Nennen sie eine y-Koordinate!");
        double y = input.nextDouble();
        double abstand = x*x +  y*y;
        if (abstand <= 1) {
            if (abstand == 1) {
                System.out.println("Der Punkt liegt auf dem Einheitskreis!");
            } else {
                System.out.println("Der Punkt liegt im Einheitskreis!");
            }

        }
        if (Math.sqrt(abstand) <= radius) {
            System.out.println("Der Punkt ist im Kreis!");
        }else  {
            System.out.println("Der Punkt ist nicht im Kreis!");
        }
    }
}
