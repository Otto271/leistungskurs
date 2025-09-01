package blatt02;
import  java.util.Scanner;
public class Haendler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double sd_preis = 5;
        double mini_preis = 8;
        double micro_preis = 12;

        System.out.println("Wie viele normalen SD-Karten wollen Sie erwerben?");
        double sd_menge = input.nextDouble();
        System.out.println("Wie viele MiniSD-Karten wollen Sie erwerben?");
        double mini_menge = input.nextDouble();
        System.out.println("Wie viele MicroSD-Karten wollen Sie erwerben?");
        double micro_menge = input.nextDouble();
        double gesamt = sd_preis * sd_menge + mini_preis * mini_menge + micro_preis * micro_menge;

        System.out.println("Der Preis für...");
        System.out.println(sd_menge + " normale SD-Karten");
        System.out.println(mini_menge + " MiniSD-Karten");
        System.out.println(micro_menge + " MicroSD-Karten");
        System.out.println("...lautet " + gesamt + " €");
    }
}
