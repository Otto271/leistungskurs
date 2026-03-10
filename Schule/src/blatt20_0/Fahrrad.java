package blatt20_0;

public class Fahrrad {
    String farbe;
    int anzahlGaenge;
    double reifengroesse;
    boolean lichtAn;
    public void klingeln() {
        System.out.println("Klingeln");
    }
    public void beschreiben() {
        System.out.println("Fahrrad: " + this.farbe + ", " + this.anzahlGaenge + " Gänge, " + this.reifengroesse + " Zoll.");
    }
    public void lichtknopf() {
        if (lichtAn) {
            lichtAn = false;
        } else  {
            lichtAn = true;
        }
    }
    public void beschleunigen(int laenge, int beschleunigung, int geschwindigkeit) {
        for (int i = 0; i < laenge; i++) {
            geschwindigkeit += beschleunigung;
        }
    }
    public void schalten(int gang, boolean hochschalten) {
        if (hochschalten) {
            gang++;
        } else  {
            gang--;
        }
    }
    public void bremsen(int geschwindigkeit, int bremskraft, int laenge) {
        for (int i = 0; i < laenge; i++) {
            geschwindigkeit -= bremskraft;
        }
    }
}
