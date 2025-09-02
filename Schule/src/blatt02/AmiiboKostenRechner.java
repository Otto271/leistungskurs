package blatt02;
import java.util.Scanner;
public class AmiiboKostenRechner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Wie viele Amiibo-Figuren wollen sie erwerben?\n" + "Eine Figur Kostet 15 €");
        double kosten = 15;
        double menge = input.nextDouble();
        double gesamt = kosten * menge;
        System.out.println("Die Gesamtkosten sind: " + gesamt + "€");
    }
}
