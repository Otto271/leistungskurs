package blatt26.aufgabe01;

public class Rechteck extends GeometrischesObjekt implements AbstandEbene{
    private Punkt punkt;
    private double breite;
    private double laenge;
    private double umfang;
    private double flaecheninhalt;

    public Rechteck(Punkt punkt, double breite, double laenge, double umfang, double flaecheninhalt) {
        this.punkt = punkt;
        this.breite = breite;
        this.laenge = laenge;
    }

    @Override
    public void flaescheninhalt() {
        this.flaecheninhalt = this.breite * this.laenge;
    }

    @Override
    public void umfang() {
        this.umfang = 2 * this.laenge + 2 * this.breite;
    }

    @Override
    public double distanz(GeometrischesObjekt geometrischesObjekt) {
        return 0;
    }
}
