package blatt15;
import blatt14.MultiArrays;
import blatt14.Simulationen;
import schisch_visualizer.*;
import blatt13.Zufall;
public class Test {
    static int[] posx = new  int[8];
    static int[] posy = new  int[8];
    static int[] reihenfolgeV = new int[8];
    static char[][] spielfeld = new char[80][80];

    final static char FARBE1 = '7';
    final static char FARBE2 = '9';

    public static void reihenfolge() {

        reihenfolgeV = new int[]{0,1,2,3,4,5,6,7};
        // Fisher-Yates Shuffle Algorithmus
        for (int i = reihenfolgeV.length - 1; i > 0; i--) {
            int j = Zufall.zufallGanz(0, i + 1);
            // Tausche spieler[i] mit spieler[j]
            int temp = reihenfolgeV[i];
            reihenfolgeV[i] = reihenfolgeV[j];
            reihenfolgeV[j] = temp;
        }
    }
    public static void zugEins(int spielernummer) {
        if (spielernummer < 4) {
            int x = posx[spielernummer];
            int y = posy[spielernummer];

            int random = Zufall.zufallGanz(0, 3);
            int neuX = x;
            int neuY = y;

                if (Simulationen.getWesten(spielfeld, x, y, false) == '9') {
                    neuX--;
                } else if (Simulationen.getNorden(spielfeld, x, y, false) == '9') {
                    neuY--;
                } else if (Simulationen.getSueden(spielfeld, x, y, false) == '9') {
                    neuY++;
                } else if (Simulationen.getOsten(spielfeld, x, y, false) == '9') {
                    neuX++;
                } else if (Simulationen.getOsten(spielfeld, x, y, false) == ' ') {
                    neuX++;
                } else if (random == 0) {
                    neuY++;
                } else if (random == 1) {
                    neuX--;
                } else if (random == 2) {
                    neuY--;
                } else {
                    return;
                }

            // Prüfe ob neue Position gültig ist (keine Wand)
            if (spielfeld[neuX][neuY] == '8') {
                return;  // Zug gestrichen
            }

            // Prüfe ob Spieler getroffen wurde
            if (spielfeld[neuX][neuY] == 'P') {
                for (int i = 0; i < 8; i++) {
                    if (posx[i] == neuX && posy[i] == neuY && i != spielernummer) {
                        respawn(i);
                        break;
                    }
                }
            }

            // Führe Bewegung aus
            spielfeld[x][y] = FARBE1;
            spielfeld[neuX][neuY] = 'P';
            posx[spielernummer] = neuX;
            posy[spielernummer] = neuY;
        }
    }
    public static void zugZwei(int spielernummer) {
        if (spielernummer >= 4) {
            int x = posx[spielernummer];
            int y = posy[spielernummer];

            int random = Zufall.zufallGanz(0, 4);
            int neuX = x;
            int neuY = y;
            if (random == 0) {
                neuX++;
            } else if (random == 1) {
                neuY++;
            } else if (random == 2) {
                neuX--;
            } else if (random == 3) {
                neuY--;
            } else {
                return;
            }

            // Prüfe ob neue Position gültig ist (keine Wand)
            if (spielfeld[neuX][neuY] == '8') {
                return;  // Zug gestrichen
            }

            // Prüfe ob Spieler getroffen wurde
            if (spielfeld[neuX][neuY] == 'P') {
                for (int i = 0; i < 8; i++) {
                    if (posx[i] == neuX && posy[i] == neuY && i != spielernummer) {
                        respawn(i);
                        break;
                    }
                }
            }

            // Führe Bewegung aus
            spielfeld[x][y] = FARBE2;
            spielfeld[neuX][neuY] = 'P';
            posx[spielernummer] = neuX;
            posy[spielernummer] = neuY;
        }
    }
    public static void schritt() {
        reihenfolge();
        for (int i = 0; i < reihenfolgeV.length; i++) {
            if (reihenfolgeV[i] < 4) {
                zugEins(reihenfolgeV[i]);
            } else {
                zugZwei(reihenfolgeV[i]);
            }

        }
    }
    public static void auswertung() {
        int team7 = zaehlen(7);
        int team9 = zaehlen(9);
        int leer = zaehlen(0);
        int gesamt = team7 + team9;

        System.out.println("=== AUSWERTUNG ===");
        System.out.println("Team 7 Felder: " + team7);
        System.out.println("Team 9 Felder: " + team9);
        System.out.println("Leere Felder: " + leer);
        System.out.println("Gesamt (ohne Rand): " + gesamt);

        double prozent7 = (team7 * 100.0) / gesamt;
        double prozent9 = (team9 * 100.0) / gesamt;

        System.out.println("Team 7 (Magenta): " + String.format("%.2f", prozent7) + "%");
        System.out.println("Team 9 (Hellgrün): " + String.format("%.2f", prozent9) + "%");

        if (team7 > team9) {
            System.out.println("Gewinner: Team 7 (Magenta)");
        } else if (team9 > team7) {
            System.out.println("Gewinner: Team 9 (Hellgrün)");
        } else {
            System.out.println("Unentschieden!");
        }
    }
    public static void simulation(int anzahlZuege) {
        SchischVisualizer sv = new SchischVisualizer();
        initialisiereSpielfeld();
        startPosition();
        sv.step(spielfeld);
        for (int i = 0; i < anzahlZuege; i++) {
            schritt();
            sv.step(spielfeld);
        }

        sv.start();
        auswertung();
    }
    public static void respawn(int spielernummer) {
        char teamfarbe;
        int teamnummer;
        if (spielernummer >= 0 && spielernummer <= 3) {
            teamfarbe = '7';
            teamnummer = 7;
        } else {
            teamfarbe = '9';
            teamnummer = 9;
        }
        boolean positionGefunden = false;
        int neux = posx[spielernummer], neuy = posy[spielernummer];

        // Suche nach einem Feld der eigenen Farbe
        int eigeneFelder = 0;
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                if (spielfeld[i][j] == teamfarbe) eigeneFelder++;
            }
        }

        if (eigeneFelder > 4) {
            while (!positionGefunden) {
                neux = Zufall.zufallGanz(1, spielfeld.length - 1);
                neuy = Zufall.zufallGanz(1, spielfeld[0].length - 1);
                if (spielfeld[neux][neuy] == teamfarbe) {
                    positionGefunden = true;
                }
            }
        } else {
            // Wenn kein eigenes Feld vorhanden, suche ein leeres Feld
            while (!positionGefunden) {
                neux = Zufall.zufallGanz(1, spielfeld.length - 1);
                neuy = Zufall.zufallGanz(1, spielfeld[0].length - 1);
                if (spielfeld[neux][neuy] == ' ') {
                    positionGefunden = true;
                }
            }
        }

        // Setze alte Position auf Teamfarbe (als Bestrafung/Hinterlassenschaft)
        spielfeld[posx[spielernummer]][posy[spielernummer]] = teamfarbe;

        // Setze neue Position
        spielfeld[neux][neuy] = 'P';
        posx[spielernummer] = neux;
        posy[spielernummer] = neuy;
    }
    public static int zaehlen(int teamnummer){
        int count = 0;
        if (teamnummer == 7) {
            for  (int i = 0; i < spielfeld.length; i++) {
                for (int j = 0; j < spielfeld[i].length; j++) {
                    if (spielfeld[i][j] == '7') {
                        count++;
                    }
                }
            }
            for (int i = 0; i <= 3; i++) {
                if (spielfeld[posx[i]][posy[i]] == 'P') {
                    count++;
                }
            }
        } else if (teamnummer == 9) {
            for (int i = 0; i < spielfeld.length; i++) {
                for (int j = 0; j < spielfeld[i].length; j++) {
                    if (spielfeld[i][j] == '9') {
                        count++;
                    }
                }
            }
            for (int i = 4; i <= 7; i++) {
                if (spielfeld[posx[i]][posy[i]] == 'P') {
                    count++;
                }
            }
        } else if (teamnummer == 0) {
            for (int i = 0; i < spielfeld.length; i++) {
                for (int j = 0; j < spielfeld[i].length; j++) {
                    if (spielfeld[i][j] == ' ') {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void initialisiereSpielfeld() {
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                if(i == 0 || i == spielfeld.length-1) {
                    spielfeld[i][j] = '8';
                } else if (j == 0 || j == spielfeld[i].length-1) {
                    spielfeld[i][j] = '8';
                } else {
                    spielfeld[i][j] = ' ';
                }
            }
        }
    }
    public static void startPosition() {
        for (int i = 0; i < 4; i++) {
            int zufallx = Zufall.zufallGanz(1, spielfeld.length/2 + 1);
            int zufally = Zufall.zufallGanz(1, spielfeld[0].length - 1);
            spielfeld[zufallx][zufally] = 'P';
            posx[i] = zufallx;
            posy[i] = zufally;
        }
        for (int i = 4; i < 8; i++) {
            int zufallx = Zufall.zufallGanz(spielfeld.length/2 + 1, spielfeld.length - 1);
            int zufally = Zufall.zufallGanz(1, spielfeld[0].length - 1);
            spielfeld[zufallx][zufally] = 'P';
            posx[i] = zufallx;
            posy[i] = zufally;
        }
    }
    public static void main(String[] args) {

        simulation(5000);
    }
}