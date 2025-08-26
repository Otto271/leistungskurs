package blatt01;

public class Haendler {
    public static void main(String[] args) {
        double normal_sd_karte_preis = 5;
        double mini_sd_karte_preis = 8;
        double micro_sd_karte_preis = 12;
        int normal_menge = 9;
        int mini_menge = 5;
        int micro_menge = 0;
        double end_preis = normal_sd_karte_preis * normal_menge + mini_sd_karte_preis * mini_menge + micro_sd_karte_preis * micro_menge;
        System.out.println("Der Preis für...\n" + normal_menge + " normale SD-Karten\n" + mini_menge + " MiniSD-Karten\n" + micro_menge + " MicroSD-Karten\n" + "...lautet " + end_preis + "€");
    }
}
