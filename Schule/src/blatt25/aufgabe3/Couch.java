package blatt25.aufgabe3;

public class Couch extends Sitzmoeglichkeit{
    private boolean eckcouch;
    public Couch(int personen) {
        if (personen >= 3) {
            this.eckcouch = true;
        } else  {
            this.eckcouch = false;
        }
        super(personen, 0);
    }
}
