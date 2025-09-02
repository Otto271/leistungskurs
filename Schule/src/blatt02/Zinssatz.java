package blatt02;
import java.util.Scanner;
public class Zinssatz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Wie hoch ist ihr Kapital?");
        double altes_kapital = input.nextDouble();
        System.out.println("Wie hoch ist ihr Zinssatz?");
        double zinsatz = input.nextDouble();
        double zinsen = altes_kapital * zinsatz / 100;
        double neues_kapital = altes_kapital + zinsen;

        System.out.println("Altes kapital: " + altes_kapital + "€");
        System.out.println("Zinsatz: " + zinsatz + "%");
        System.out.println();
        System.out.println("Zinsen: " + zinsen + "€");
        System.out.println("Neues kapital: " + neues_kapital + "€");
    }
}
