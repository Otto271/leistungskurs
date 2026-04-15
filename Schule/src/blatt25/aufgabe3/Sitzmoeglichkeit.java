package blatt25.aufgabe3;

public class Sitzmoeglichkeit {
    private int personen;
    private int personenBesetzt;

    public Sitzmoeglichkeit(int personen, int personenBesetzt) {
        this.personen = personen;
        this.personenBesetzt = personenBesetzt;
    }

    public int getPersonen() {
        return personen;
    }

    public void setPersonen(int personen) {
        this.personen = personen;
    }

    public int getPersonenBesetzt() {
        return personenBesetzt;
    }

    public void setPersonenBesetzt(int personenBesetzt) {
        this.personenBesetzt = personenBesetzt;
    }

    public void aufstehen() {
        if (this.personenBesetzt > 0) {
            this.personenBesetzt--;
        }
    }

    public void hinsetzen() {
        if (this.personenBesetzt == this.personen) {
            System.out.println("Zu viele Personen!");
        } else {
            this.personenBesetzt++;
        }
    }
}
