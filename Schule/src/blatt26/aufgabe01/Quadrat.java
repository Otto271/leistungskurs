package blatt26.aufgabe01;

public class Quadrat extends GeometrischesObjekt implements AbstandEbene{
    private Punkt punkt;
    private double breite;
    private double umfang;
    private double flaecheninhalt;

    public Quadrat(Punkt punkt, double breite, double umfang, double flaecheninhalt) {
        this.punkt = punkt;
        this.breite = breite;
    }

    @Override
    public void umfang() {
        this.umfang = 4 * this.breite;
    }

    @Override
    public void flaescheninhalt() {
        this.flaecheninhalt = Math.sqrt(this.breite);
    }

    @Override
    public double distanz(GeometrischesObjekt geometrischesObjekt) {
        return 0;
    }
}
