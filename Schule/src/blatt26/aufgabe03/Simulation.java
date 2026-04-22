package blatt26.aufgabe03;

import blatt13.Zufall;

public class Simulation {
    public boolean checkEnd(Player[] players) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].checkKarten()) {
                return false;
            }
        }
        return true;
    }

    public int[] reihe(Player[] players) {
        int[] reihenfolge = new int[players.length];
        for (int i = reihenfolge.length - 1; i > 0; i--) {
            int j = Zufall.zufallGanz(0, i + 1);
            int temp = reihenfolge[i];
            reihenfolge[i] = reihenfolge[j];
            reihenfolge[j] = temp;
        }
        return reihenfolge;
    }

    public void kampf(Player[] players, int i, int j) {
        Karten karte1 = players[i].random();
        Karten karte2 = players[j].random();
    }

    public void sim(Player[] players) {
        while (checkEnd(players)) {
            int[] reihenfolge = reihe(players);
            for (int i = 0; i < players.length; i += 2) {

            }
        }
    }
}
