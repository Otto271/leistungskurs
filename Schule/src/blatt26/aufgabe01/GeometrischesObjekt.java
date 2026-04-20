package blatt26.aufgabe01;

public abstract class GeometrischesObjekt {
    private Punkt punkt;
    private int breite;
    private int laenge;
    private int radius;
    private double flaecheninhalt;
    private double umfang;

    public GeometrischesObjekt(Punkt punkt, int breite, int laenge, int radius) {
        this.punkt = punkt;
        if (breite < 1) {
            this.breite = breite;
        } else {
            this.breite = 1;
        }
        if (laenge < 1) {
            this.laenge = laenge;
        } else {
            this.laenge = 1;
        }
        if (radius < 1) {
            this.radius = radius;
        } else {
            this.radius = 1;
        }
    }

    public void flaescheninhalt() {
        if (radius == 1) {
            this.flaecheninhalt = this.breite * this.laenge;
        } else {
            this.flaecheninhalt = Math.PI * Math.sqrt(this.radius);
        }
    }
}
