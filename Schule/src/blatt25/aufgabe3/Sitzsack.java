package blatt25.aufgabe3;

public class Sitzsack extends Sitzmoeglichkeit {
    private int menge;

    public Sitzsack(int menge) {
        super(4, 0);
        this.menge = menge;
    }

    @Override
    public void hinsetzen() {
        if (this.menge < 20) {
            System.out.println("Fehler!");
        } else if (this.menge > 90) {
            System.out.println("Fehler!");
        } else if (this.getPersonenBesetzt() == 1 && this.menge > 80) {
            System.out.println("Fehler!");
        } else if (this.getPersonenBesetzt() == 2 && this.menge > 70) {
            System.out.println("Fehler!");
        } else if (this.getPersonenBesetzt() == 3 && this.menge > 60) {
            System.out.println("Fehler!");
        } else {
            super.hinsetzen();
            menge -= 2;
        }
    }
    public void auffuellen(int menge) {
        if (menge < 0) {
            System.out.println("Fehler!");
            return;
        }
        if (this.menge + menge < 100) {
            this.menge += menge;
        }
    }
}
