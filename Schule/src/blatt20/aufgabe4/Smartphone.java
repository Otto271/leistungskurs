package blatt20.aufgabe4;

public class Smartphone {
    private String marke;
    private String modell;
    private int akku;
    private int speicher;
    private int preis;

    public Smartphone(String marke, String modell, int akku, int speicher, int preis) {
        this.marke = marke;
        this.modell = modell;
        this.akku = akku;
        this.speicher = speicher;
        this.preis = preis;
    }

    public String getMarke() {
        return marke;
    }

    public String getModell() {
        return modell;
    }

    public int getAkku() {
        return akku;
    }

    public void setAkku(int akku) {
        if (akku < 0) {
            this.akku = 0;
        } else if (akku > 100) {
            this.akku = 100;
        } else {
            this.akku = akku;
        }
    }

    public int getSpeicher() {
        return speicher;
    }

    public void setSpeicher(int speicher) {
        this.speicher = speicher;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }
}
