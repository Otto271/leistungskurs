package blatt20.aufgabe2;

public class Auto {
    private String marke;
    private String modell;
    private int tank;
    private int geschwindigkeit;
    private int kilometerstand;

    public void setTank(int tank) {
        if (tank < 0) {
            this.tank = 0;
        } else if (tank > 100) {
            this.tank = 100;
        } else {
            this.tank = tank;
        }
    }

    public void setGeschwindigkeit(int geschwindigkeit) {
        if (geschwindigkeit < 0) {
            this.geschwindigkeit = 0;
        } else if (geschwindigkeit > 250) {
            geschwindigkeit = 250;
        } else {
            this.geschwindigkeit = geschwindigkeit;
        }
    }

    public void setKilometerstand(int kilometerstand) {
        if (kilometerstand < 0) {
            this.kilometerstand = 0;
        } else {
            this.kilometerstand = kilometerstand;
        }
    }

    public String getMarke() {
        return marke;
    }

    public String getModell() {
        return modell;
    }

    public int getTank() {
        return tank;
    }

    public int getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public int getKilometerstand() {
        return kilometerstand;
    }

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
}
