package blatt20.aufgabe4;

public class Smartphone {
    private String marke;
    private String modell;
    private int akku;
    private int speicher;
    private int preis;
    private int displaygroesse;
    private int helligkeit;
    private int lautstaerke;
    private String os;

    public void speicherLeeren(int maxSpeicher) {
        this.speicher = maxSpeicher;
    }

    public void akkuLaden(int akku) {
        if (akku <= 0) {
            this.akku = 0;
        } else if (akku > 100) {
            this.akku = 100;
        } else {
            this.akku = akku;
        }
    }

    public void einschalten() {
        if (akku > 0) {
            this.helligkeit = 10;
        } else {
            this.helligkeit = 0;
        }
    }

    public boolean istAkkuLeer() {
        if (this.akku == 0) {
            return true;
        }
        return false;
    }

    public void appInstallieren(int groesse) {
        if (hatGenugSpeicher(groesse)) {
            this.speicher -= groesse;
        }
    }

    public boolean hatGenugSpeicher(int groesse) {
        if (this.speicher < groesse) {
            return false;
        }
        return true;
    }

    public int getDisplaygroesse() {
        return displaygroesse;
    }

    public void setDisplaygroesse(int displaygroesse) {
        this.displaygroesse = displaygroesse;
    }

    public int getHelligkeit() {
        return helligkeit;
    }

    public void setHelligkeit(int helligkeit) {
        if (helligkeit > 10) {
            this.helligkeit = 10;
        } else if (helligkeit < 0) {
            this.helligkeit = 0;
        } else {
            this.helligkeit = helligkeit;
        }
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getLautstaerke() {
        return lautstaerke;
    }

    public void setLautstaerke(int lautstaerke) {
        if (lautstaerke < 0) {
            this.lautstaerke = 0;
        } else if (lautstaerke > 100) {
            this.lautstaerke = 100;
        } else {
            this.lautstaerke = lautstaerke;
        }
    }

    public Smartphone(String marke, String modell, int akku, int speicher, int preis, int displaygroesse, int helligkeit, int lautstaerke, String os) {
        this.marke = marke;
        this.modell = modell;
        this.akku = akku;
        this.speicher = speicher;
        this.preis = preis;
        this.displaygroesse = displaygroesse;
        this.helligkeit = helligkeit;
        this.lautstaerke = lautstaerke;
        this.os = os;
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
