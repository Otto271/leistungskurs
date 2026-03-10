package blatt20.aufgabe1;

public class Kaffeemaschine {
    int bohnen;
    int wasser;
    int dreck;
    int kaffeesatz;
    public void bohnenAuffuellen() {
        this.bohnen = 350;
    }
    public void wasserAuffuellen() {
        this.wasser = 800;
    }
    public void bohnenLeeren() {
        this.bohnen = 0;
    }
    public void wasserLeeren() {
        this.wasser = 0;
    }
    public void wasserReinigen() {
        if (this.wasser == 0) {
            this.dreck = 0;
        } else {
            System.out.println("Wasser erst leeren!");
        }
    }
    public void kaffeesatzLeeren() {
        this.kaffeesatz = 0;
    }
    public void kaffeeziehen(int menge, int intensitaet) {
        double wahrscheinlichkeit;
        if (this.dreck < 75 && this.dreck >= 50) {
            wahrscheinlichkeit = 0.75;
        } else if (this.dreck < 90 && this.dreck >= 75) {
            wahrscheinlichkeit = 0.5;
        } else if (this.dreck >= 90) {
            wahrscheinlichkeit = 0;
        } else {
            wahrscheinlichkeit = 1;
        }
        if (!(menge < 10 || menge > 200 || intensitaet < 1 || intensitaet > 10)) {
            if (this.wasser >= menge && this.bohnen >= (intensitaet / 2) * (menge / 10)) {
                if (this.kaffeesatz < 600) {
                    if (wahrscheinlichkeit >= Math.random()) {
                        this.bohnen -= (intensitaet / 2) * (menge / 10);
                        this.kaffeesatz += (intensitaet / 2) * (menge / 10);
                        this.wasser -= menge;
                        this.dreck += 1;
                    } else {
                        System.out.println("Wasser zu dreckig!");
                    }
                } else {
                    System.out.println("Kaffeesatz voll!");
                }
            } else {
                System.out.println("Wasser oder Bohnen zu niedrig!");
            }
        } else {
            System.out.println("Intensität oder Menge zu niedrig oder zu hoch!");
        }
    }
}
