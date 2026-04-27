package blatt26.aufgabe03;

import blatt13.Zufall;

public class Player {
    private Karten karteS;
    private Karten karteSt;
    private Karten karteP;
    private int sterne;
    private int mengeS;
    private int mengeSt;
    private int mengeP;

    public Player() {
        this.karteS = Karten.SCHERE;
        this.karteSt = Karten.STEIN;
        this.karteP = Karten.PAPIER;
        this.sterne = 3;
        this.mengeS = 4;
        this.mengeSt = 4;
        this.mengeP = 4;
    }

    public int getSterne() {
        return this.sterne;
    }

    public int getKartenMenge(Karten karten) {
        if (karten == Karten.SCHERE) {
            return this.mengeS;
        } else if (karten == Karten.STEIN) {
            return this.mengeSt;
        } else {
            return this.mengeP;
        }
    }

    public void minusKarten(Karten karten) {
        if (karten == Karten.SCHERE) {
            this.mengeS--;
        } else if (karten == Karten.STEIN) {
            this.mengeSt--;
        } else {
            this.mengeP--;
        }
    }

    public void minusSterne() {
        this.sterne--;
    }

    public void plusSterne() {
        this.sterne++;
    }

    public boolean checkKarten() {
        if (this.mengeS == 0 &&  this.mengeSt == 0 && this.mengeP == 0) {
            return true;
        }
        return false;
    }

    public int kartenMenge(Karten karte) {
        if (karte == Karten.SCHERE) {
            return this.mengeS;
        }  else if (karte == Karten.STEIN) {
            return this.mengeSt;
        } else {
            return this.mengeP;
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

    public void kampf(Player[] players, int j) {
        Karten karte1 = this.random();
        Karten karte2 = players[j].random();
        if (karte1 == karte2) {
            return;
        } else if (karte1 == Karten.SCHERE) {
            if (karte2 == Karten.STEIN) {
                this.minusSterne();
                players[j].plusSterne();
                return;
            } else if (karte2 == Karten.PAPIER) {
                this.plusSterne();
                players[j].minusSterne();
                return;
            }
        } else if (karte1 == Karten.STEIN) {
            if (karte2 == Karten.PAPIER) {
                this.minusSterne();
                players[j].plusSterne();
                return;
            } else if (karte2 == Karten.SCHERE) {
                this.plusSterne();
                players[j].minusSterne();
                return;
            }
        } else if (karte1 == Karten.PAPIER) {
            if (karte2 == Karten.STEIN) {
                this.plusSterne();
                players[j].minusSterne();
                return;
            } else  if (karte2 == Karten.SCHERE) {
                this.minusSterne();
                players[j].plusSterne();
                return;
            }
        }
    }
}
