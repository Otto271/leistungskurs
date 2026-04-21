package blatt26.aufgabe01;

public class Kreis extends GeometrischesObjekt implements AbstandEbene{
    private Punkt punkt;
    private double radius;
    private double umfang;
    private double flaecheninhalt;

    public Kreis(Punkt punkt, double radius) {
        this.punkt = punkt;
        this.radius = radius;
    }

    @Override
    public void umfang() {
        this.umfang = 2 * Math.PI * this.radius;
    }

    @Override
    public void flaescheninhalt() {
        this.flaecheninhalt = Math.PI * Math.sqrt(this.umfang);
    }

    @Override
    public double distanz(GeometrischesObjekt geometrischesObjekt) {
        return 0;
    }
}
