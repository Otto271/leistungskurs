package blatt20.aufgabe3;

public class Ofenherd {
    int beheizungsmodus;
    int temp;
    int groesse;
    int stufe;
    int menge;
    void stufe(int stufe) {
        Kochfeld k = new Kochfeld(this.stufe, this.groesse);
        if (this.stufe < stufe) {
            for (int i = this.stufe; i <= stufe; i++) {
                k.erhoehen();
            }
        } else {
            for (int i = this.stufe; i >= stufe; i--) {
                k.senken();
            }
        }
    }
    void modus(int beheizungsmodus) {
        this.beheizungsmodus = beheizungsmodus;
    }
}
