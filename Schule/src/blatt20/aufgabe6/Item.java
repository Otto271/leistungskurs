package blatt20.aufgabe6;

public class Item {
    private String name;
    private String wirkung;
    private boolean aktiv;

    private Charakter charakter;

    public Item(String name, boolean aktiv, String wirkung) {
        this.name = name;
        this.aktiv = aktiv;
        this.wirkung = wirkung;
    }

    public String getName() {
        return name;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public String getWirkung() {
        return wirkung;
    }

    public void wirkeAn(Charakter charakter) {

    }
}
