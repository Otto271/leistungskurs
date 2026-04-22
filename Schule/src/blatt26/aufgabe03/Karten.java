package blatt26.aufgabe03;

public enum Karten {
    SCHERE(4),
    STEIN(4),
    PAPIER(4);

    int menge;

    Karten (int menge) {
        this.menge = menge;
    }
}
