package blatt01;

public class Haendler {
    public static void main(String[] args) {
        double sd_preis = 5;
        double mini_preis = 8;
        double micro_preis = 12;
        double sd_menge = 9;
        double mini_menge = 5;
        double micro_menge = 0;
        double gesamt = sd_preis * sd_menge + mini_preis * mini_menge + micro_preis * micro_menge;

        System.out.println("Der Preis für...");
        System.out.println(sd_menge + "normale SD-Karten");
        System.out.println(mini_menge + "MiniSD-Karten");
        System.out.println(micro_menge + "MicroSD-Karten");
        System.out.println("...lautet " + gesamt + " €");
    }
}
