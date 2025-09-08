package blatt03;
import  java.util.Scanner;
public class Haendler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double sd_preis = 5;
        double mini_preis = 8;
        double micro_preis = 12;

        System.out.println("Wie viele normalen SD-Karten wollen Sie erwerben?");
        int sd_menge = input.nextInt();
        if (sd_menge < 0) {
            System.out.println("Keine Negativen Zahlen!");
            System.exit(0);
        }
        if (sd_menge > 50) {
            System.out.println("Das Maximum ist 50! Die Menge wird auf 50 gesetzt!");
            sd_menge = 50;
        }
        System.out.println("Wie viele MiniSD-Karten wollen Sie erwerben?");
        int mini_menge = input.nextInt();
        if (mini_menge < 0) {
            System.out.println("Keine Negativen Zahlen!");
            System.exit(0);
        }
        if (mini_menge > 50) {
            System.out.println("Das Maximum ist 50! Die Menge wird auf 50 gesetzt!");
            mini_menge = 50;
        }
        System.out.println("Wie viele MicroSD-Karten wollen Sie erwerben?");
        int micro_menge = input.nextInt();
        if (micro_menge < 0) {
            System.out.println("Keine Negativen Zahlen!");
            System.exit(0);
        }
        if (micro_menge > 50) {
            System.out.println("Das Maximum ist 50! Die Menge wird auf 50 gesetzt!");
            micro_menge = 50;
        }
        double gesamt;

        if (sd_menge + mini_menge + micro_menge > 14) {
            gesamt = sd_preis * sd_menge + mini_preis * mini_menge + micro_preis * micro_menge;
            double rabatt = gesamt * 0.15;
            double preis = gesamt - rabatt;
            System.out.println("Sie bekommen einen Rabatt von 15%!");
            System.out.println("Der Preis für...");
            System.out.println(sd_menge + " normale SD-Karten");
            System.out.println(mini_menge + " MiniSD-Karten");
            System.out.println(micro_menge + " MicroSD-Karten");
            System.out.println("...lautet " + preis + " €");

        }else {
            gesamt = sd_preis * sd_menge + mini_preis * mini_menge + micro_preis * micro_menge;
            System.out.println("Der Preis für...");
            System.out.println(sd_menge + " normale SD-Karten");
            System.out.println(mini_menge + " MiniSD-Karten");
            System.out.println(micro_menge + " MicroSD-Karten");
            System.out.println("...lautet " + gesamt + " €");
        }


    }
}