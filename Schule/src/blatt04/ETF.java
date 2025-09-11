package blatt04;
import java.util.Random;
import java.util.Scanner;
public class ETF {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        System.out.println("Wie viele Jahre wollen Sie ihr Geld anlegen?");
        int jahr_max = input.nextInt(); //alle Variablen
        double zinssatz;
        int jahr = 1;
        double sparbetrag;
        int monat = 1;
        double wert = 3578.89;
        double anteil = 0;
        double kontostand = 0;
        double spar_gesamt = 0;
        while (jahr <= jahr_max) { //falls das Jahr tiefer ist als das eingegebene Jahr wird die Schleife ausgeführt
            System.out.println("Wieviel wollen Sie dieses Jahr monatlich anlegen?");
            sparbetrag = input.nextDouble(); //Sparbetrag wird für jedes jahr neu abgefragt
            while (monat <= 12) { //wenn tiefer gleich 12 ist geht in die schleife
                zinssatz = rand.nextDouble();
                if (zinssatz < 0.5) { //Zinssatz wird errechnet
                    zinssatz = zinssatz * 24;
                } else if (zinssatz > 0.5) {
                    zinssatz = zinssatz * 12;
                }
                spar_gesamt += sparbetrag; //alle rechnungen
                kontostand = spar_gesamt * (zinssatz / 100 + 1);
                anteil = kontostand / wert;
                System.out.println("Jahr: " + jahr); //ausgaben
                System.out.println("Monat: " + monat);
                System.out.println("Sparbetrag: " + sparbetrag + " €");
                System.out.printf("Zinssatz: %.2f", zinssatz);
                System.out.println(" %");
                System.out.printf("Kontostand: %.2f", kontostand);
                System.out.println(" €");
                System.out.printf("Anteil: %.4f", anteil);
                System.out.println("\n");
                monat++; //Monat +1
            }
            monat = 1; //monat wird auf 1 gesetzt
            jahr++; //jahr +1
        }
    }
}
