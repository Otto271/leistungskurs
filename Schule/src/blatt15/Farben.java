package blatt15;
import schisch_visualizer.*;
import blatt13.Zufall;
public class Farben {
    public static String reihenfolge() {
        String reihe = "";
        int[] spieler = {1, 2, 3, 4, 5, 6, 7, 8};

        // Fisher-Yates Shuffle Algorithmus
        for (int i = spieler.length - 1; i > 0; i--) {
            int j = Zufall.zufallGanz(0, i + 1);
            // Tausche spieler[i] mit spieler[j]
            int temp = spieler[i];
            spieler[i] = spieler[j];
            spieler[j] = temp;
        }

        // Konvertiere Array zu String
        for (int i = 0; i < spieler.length; i++) {
            reihe += spieler[i];
        }

        return reihe;
    }
    public static void zugEins(char[][] arr, int[] posx, int[] posy, int spielernummer) {
        char teamfarbe = (spielernummer <= 3) ? '7' : '9';
        int x = posx[spielernummer];
        int y = posy[spielernummer];

        // Wähle zufällige Richtung (0=Nord, 1=Süd, 2=West, 3=Ost)
        int richtung = Zufall.zufallGanz(0, 4);
        int neuX = x;
        int neuY = y;

        if (richtung == 0 && x > 0) {
            neuX = x - 1;  // Nord
        } else if (richtung == 1 && x < arr.length - 1) {
            neuX = x + 1;  // Süd
        } else if (richtung == 2 && y > 0) {
            neuY = y - 1;  // West
        } else if (richtung == 3 && y < arr[0].length - 1) {
            neuY = y + 1;  // Ost
        } else {
            return;  // Ungültige Bewegung (Rand erreicht)
        }

        // Prüfe ob neue Position gültig ist (keine Wand)
        if (arr[neuX][neuY] == '8') {
            return;  // Zug gestrichen
        }

        // Prüfe ob Spieler getroffen wurde
        if (arr[neuX][neuY] == 'P') {
            for (int i = 0; i < 8; i++) {
                if (posx[i] == neuX && posy[i] == neuY && i != spielernummer) {
                    respawn(arr, posx, posy, i);
                    break;
                }
            }
        }

        // Führe Bewegung aus
        arr[x][y] = teamfarbe;
        arr[neuX][neuY] = 'P';
        posx[spielernummer] = neuX;
        posy[spielernummer] = neuY;
    }
    public static void zugZwei(char[][] arr, int[] posx, int[] posy, int spielernummer) {
        char teamfarbe = (spielernummer <= 3) ? '7' : '9';
        int x = posx[spielernummer];
        int y = posy[spielernummer];

        // Wähle zufällige Richtung
        int richtung = Zufall.zufallGanz(0, 4);
        int neuX = x;
        int neuY = y;
        int zwischenX = x;
        int zwischenY = y;

        if (richtung == 0 && x > 1) {  // Nord (2 Felder)
            neuX = x - 2;
            zwischenX = x - 1;
        } else if (richtung == 1 && x < arr.length - 2) {  // Süd
            neuX = x + 2;
            zwischenX = x + 1;
        } else if (richtung == 2 && y > 1) {  // West
            neuY = y - 2;
            zwischenY = y - 1;
        } else if (richtung == 3 && y < arr[0].length - 2) {  // Ost
            neuY = y + 2;
            zwischenY = y + 1;
        } else {
            return;  // Ungültige Bewegung
        }

        // Prüfe ob Zielposition gültig ist
        if (arr[neuX][neuY] == '8') {
            return;  // Zug gestrichen
        }

        // Prüfe Zwischenfeld auf Spieler
        if (arr[zwischenX][zwischenY] == 'P') {
            for (int i = 0; i < 8; i++) {
                if (posx[i] == zwischenX && posy[i] == zwischenY && i != spielernummer) {
                    respawn(arr, posx, posy, i);
                    break;
                }
            }
        }

        // Prüfe Zielfeld auf Spieler
        if (arr[neuX][neuY] == 'P') {
            for (int i = 0; i < 8; i++) {
                if (posx[i] == neuX && posy[i] == neuY && i != spielernummer) {
                    respawn(arr, posx, posy, i);
                    break;
                }
            }
        }

        // Führe Bewegung aus
        arr[x][y] = teamfarbe;
        arr[zwischenX][zwischenY] = teamfarbe;
        arr[neuX][neuY] = 'P';
        posx[spielernummer] = neuX;
        posy[spielernummer] = neuY;
    }
    public static void schritt(char[][] arr, int[] posx, int[] posy) {
        String reihe = reihenfolge();

        for (int i = 0; i < reihe.length(); i++) {
            // Konvertiere Char zu Spielernummer (1-8 -> 0-7)
            int spielernum = Character.getNumericValue(reihe.charAt(i)) - 1;

            // Wähle zufällig zwischen zugEins und zugZwei
            int zugTyp = Zufall.zufallGanz(0, 2);
            if (zugTyp == 0) {
                zugEins(arr, posx, posy, spielernum);
            } else {
                zugZwei(arr, posx, posy, spielernum);
            }
        }
    }
    public static void auswertung(char[][] arr, int[] posx, int[] posy) {
        int team7 = zaehlen(7, arr, posx, posy);
        int team9 = zaehlen(9, arr, posx, posy);
        int leer = zaehlen(0, arr, posx, posy);
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
    public static void simulation(char[][] arr, int[] posx, int[] posy, int anzahlZuege) {
        SchischVisualizer sv = new SchischVisualizer();

        for (int i = 0; i < anzahlZuege; i++) {
            schritt(arr, posx, posy);
            sv.step(arr);
        }

        sv.start();
        auswertung(arr, posx, posy);
    }
    public static void respawn(char[][] arr, int[] posx, int[] posy, int spielernummer) {
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
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == teamfarbe) eigeneFelder++;
            }
        }

        if (eigeneFelder > 0) {
            while (!positionGefunden) {
                neux = Zufall.zufallGanz(1, arr.length - 1);
                neuy = Zufall.zufallGanz(1, arr[0].length - 1);
                if (arr[neux][neuy] == teamfarbe) {
                    positionGefunden = true;
                }
            }
        } else {
            // Wenn kein eigenes Feld vorhanden, suche ein leeres Feld
            while (!positionGefunden) {
                neux = Zufall.zufallGanz(1, arr.length - 1);
                neuy = Zufall.zufallGanz(1, arr[0].length - 1);
                if (arr[neux][neuy] == ' ') {
                    positionGefunden = true;
                }
            }
        }
        
        // Setze alte Position auf Teamfarbe (als Bestrafung/Hinterlassenschaft)
        arr[posx[spielernummer]][posy[spielernummer]] = teamfarbe;
        
        // Setze neue Position
        arr[neux][neuy] = 'P';
        posx[spielernummer] = neux;
        posy[spielernummer] = neuy;
    }
    public static int zaehlen(int teamnummer, char[][] arr, int[] posx, int[] posy){
        int count = 0;
        if (teamnummer == 7) {
            for  (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == '7') {
                        count++;
                    }
                }
            }
            for (int i = 0; i <= 3; i++) {
                if (arr[posx[i]][posy[i]] == 'P') {
                    count++;
                }
            }
        } else if (teamnummer == 9) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == '9') {
                        count++;
                    }
                }
            }
            for (int i = 4; i <= 7; i++) {
                if (arr[posx[i]][posy[i]] == 'P') {
                    count++;
                }
            }
        } else if (teamnummer == 0) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == ' ') {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static void initialisiereSpielfeld(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i == 0 || i == arr.length-1) {
                    arr[i][j] = '8';
                } else if (j == 0 || j == arr[i].length-1) {
                    arr[i][j] = '8';
                } else {
                    arr[i][j] = ' ';
                }
            }
        }
    }
    public static void startPosition(char[][] arr, int[] posx, int[] posy) {
        for (int i = 0; i < 4; i++) {
            int zufallx = Zufall.zufallGanz(1, arr.length/2 + 1);
            int zufally = Zufall.zufallGanz(1, arr[0].length - 1);
            arr[zufallx][zufally] = 'P';
            posx[i] = zufallx;
            posy[i] = zufally;
        }
        for (int i = 4; i < 8; i++) {
            int zufallx = Zufall.zufallGanz(arr.length/2 + 1, arr.length - 1);
            int zufally = Zufall.zufallGanz(1, arr[0].length - 1);
            arr[zufallx][zufally] = 'P';
            posx[i] = zufallx;
            posy[i] = zufally;
        }
    }
    public static int[] positionx(char[][] arr, int[] posx) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 'P') {
                    posx[count] = i;
                    count++;
                }
            }
        }
        return posx;
    }
    public static int[] positiony(char[][] arr, int[] posy) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 'P') {
                    posy[count] = j;
                    count++;
                }
            }
        }
        return posy;
    }
    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        char[][] arr = new char[80][80];
        int[] posx = new int[8];
        int[] posy = new int[8];
        initialisiereSpielfeld(arr);
        startPosition(arr, posx, posy);

        simulation(arr, posx, posy, 1000);
    }
}
