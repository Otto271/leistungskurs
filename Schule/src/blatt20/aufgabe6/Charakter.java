package blatt20.aufgabe6;

public class Charakter {
    private String name;
    private Gewichtsklasse gewichtsklasse;
    private String spezialitem;

    private Item item;
    private Kart kart;

    public Charakter(String name, Gewichtsklasse gewichtsklasse, String spezialitem) {
        this.name = name;
        this.gewichtsklasse = gewichtsklasse;
        this.spezialitem = spezialitem;
    }

    public String getName() {
        return name;
    }

    public Gewichtsklasse getGewichtsklasse() {
        return gewichtsklasse;
    }

    public String getSpezialitem() {
        return spezialitem;
    }

    public void lenkeKart(Kart kart) {

    }

    public void halteitem(Item item) {

    }

    public void wirftitem(Item item) {

    }
}
