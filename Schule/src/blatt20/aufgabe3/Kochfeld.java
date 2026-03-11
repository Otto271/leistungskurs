package blatt20.aufgabe3;

public class Kochfeld {
    int stufe;
    int groesse;
    public Kochfeld(int stufe, int groesse) {
        this.stufe = stufe;
        this.groesse = groesse;
    }
    void erhoehen() {
        this.stufe ++;
    }
    void senken() {
        this.stufe--;
    }
}
