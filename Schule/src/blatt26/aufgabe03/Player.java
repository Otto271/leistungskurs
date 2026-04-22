package blatt26.aufgabe03;

import blatt13.Zufall;

public class Player {
    private Karten karteS;
    private Karten karteSt;
    private Karten karteP;
    private int sterne;

    public Player() {
        this.karteS = Karten.SCHERE;
        this.karteSt = Karten.STEIN;
        this.karteP = Karten.PAPIER;
        this.sterne = 3;
    }

    public int getSterne() {
        return this.sterne;
    }

    public int getKartenMenge(Karten karten) {
        if (karten == Karten.SCHERE) {
            return this.karteS.menge;
        } else if (karten == Karten.STEIN) {
            return this.karteSt.menge;
        } else {
            return this.karteP.menge;
        }
    }

    public void minusKarten(Karten karten) {
        if (karten == Karten.SCHERE) {
            this.karteS.menge--;
        } else if (karten == Karten.STEIN) {
            this.karteSt.menge--;
        } else {
            this.karteP.menge--;
        }
    }

    public void minusSterne() {
        this.sterne--;
    }

    public boolean checkKarten() {
        if (this.karteS.menge == 0 &&  this.karteSt.menge == 0 && this.karteP.menge == 0) {
            return true;
        }
        return false;
    }

    public int kartenMenge(Karten karte) {
        if (karte == Karten.SCHERE) {
            return this.karteS.menge;
        }  else if (karte == Karten.STEIN) {
            return this.karteSt.menge;
        } else {
            return this.karteP.menge;
        }
    }

    public boolean checkSterne() {
        if (this.sterne == 0) {
            return false;
        } else if (this.sterne > 3) {
            return true;
        }
        return false;
    }

    public Karten random() {
        while (true) {
            int zufall = Zufall.zufallGanz(3);
            if (zufall == 0) {
                if (kartenMenge(karteS) != 0) {
                    minusKarten(Karten.SCHERE);
                    return Karten.SCHERE;
                }
            }
            if (zufall == 1) {
                if (kartenMenge(karteSt) != 0) {
                    minusKarten(Karten.STEIN);
                    return Karten.STEIN;
                }
            }
            if (zufall == 2) {
                if (kartenMenge(karteP) != 0) {
                    minusKarten(Karten.PAPIER);
                    return Karten.PAPIER;
                }
            }
        }
    }
}
