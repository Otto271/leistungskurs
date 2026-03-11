package blatt20.aufgabe2;

public class Auto {
    String marke;
    String modell;
    int tank;
    int geschwindigkeit;
    int kilometerstand;

    public void beschleunigen(int v) {
        this.geschwindigkeit = v;
    }
    public void bremsen(int v) {
        this.geschwindigkeit = v;
    }
    public void fahren(int km) {
        this.kilometerstand += km;
    }
    public Auto() {
        marke = "unbekannt";
        modell = "unbekannt";
        tank = 50;
        geschwindigkeit = 0;
        kilometerstand = 0;
    }
    public Auto(String marke, String modell, int tank, int geschwindigkeit, int kilometerstand) {
        this.marke = marke;
        this.modell = modell;
        this.tank = tank;
        this.geschwindigkeit = geschwindigkeit;
        this.kilometerstand = kilometerstand;
    }
    public Auto(Auto a) {
        this.marke = a.marke;
        this.modell = a.modell;
        this.tank = a.tank;
        this.geschwindigkeit = a.geschwindigkeit;
        this.kilometerstand = a.kilometerstand;
    }

    public static void main(String[] args) {
        Auto a = new Auto("BMW", "M3", 60, 0, 120000);
        Auto b = new Auto(a);
    }
}
