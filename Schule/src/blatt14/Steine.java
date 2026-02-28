package blatt14;

import schisch_visualizer.SchischVisualizer;

public class Steine {
    static int aktuellerSteinX;
    static int aktuellerSteinY;
    static int aktuellerSteinTyp;
    static int aktuelleRichtung;
    static char[][] spielfeld = new char[10][40];
    public static void initialisiereSpielfeld() {
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                spielfeld[i][j] = ' ';
            }
        }
    }
    public static void platziereStein(int x, int y, int typ, int richtung, boolean horizontal) {
        aktuellerSteinX = x;
        aktuellerSteinY = y;
        aktuellerSteinTyp = typ;
        switch (typ) {
            case 1:
                zeichneI(x, y, horizontal);
                break;
            case 2:
                zeichneO(x, y);
                break;
            case 3:
                zeichneS(x, y, richtung);
                break;
            case 4:
                zeichneZ(x, y, richtung);
                break;
            case 5:
                zeichneJ(x, y, richtung);
                break;
            case 6:
                zeichneL(x, y, richtung);
                break;
        }
    }

    public static void zeichneI(int x, int y, boolean horizontal) {
        if (horizontal) {
            for (int i = 0; i < 4; i++) {
                if (x + i < 10 && y < 40) {
                    spielfeld[x + i][y] = '6';
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                if (x < 10 && y + i < 40) {
                    spielfeld[x][y + i] = '6';
                }
            }
        }
    }
    public static void zeichneO(int x, int y) {
        if (x + 1 < 10 && y + 1 < 40) {
            spielfeld[x][y] = '5';
            spielfeld[x + 1][y] = '5';
            spielfeld[x][y + 1] = '5';
            spielfeld[x + 1][y + 1] = '5';
        }
    }
    public static void zeichneT(int x, int y, int richtung) {
        if (richtung == 0 && x + 2 < 10 && y + 1 < 40 && x + 1 < 10 && y < 40) {
            spielfeld[x + 1][y] = '7';
            spielfeld[x][y + 1] = '7';
            spielfeld[x + 1][y + 1] = '7';
            spielfeld[x + 2][y + 1] = '7';
        } else if (richtung == 1 && x + 1 < 10 && y + 2 < 40) {
            spielfeld[x][y+1] = '7';
            spielfeld[x+1][y+1] = '7';
            spielfeld[x+1][y+2] = '7';
            spielfeld[x+1][y] = '7';
        } else if (richtung == 2 && x + 2 < 10 && y + 1 < 40) {
            spielfeld[x][y] = '7';
            spielfeld[x+1][y] = '7';
            spielfeld[x+2][y] = '7';
            spielfeld[x+1][y+1] = '7';
        } else if (richtung == 3 && x + 1 < 10 && y + 2 < 40) {
            spielfeld[x][y] = '7';
            spielfeld[x][y + 1] = '7';
            spielfeld[x][y + 2] = '7';
            spielfeld[x + 1][y + 1] = '7';
        }
    }
    public static void zeichneS(int x, int y, int richtung) {
        if (richtung == 0 && x + 2 < 10 && y + 1 < 40) {
            spielfeld[x+1][y] = '9';
            spielfeld[x][y+1] = '9';
            spielfeld[x+1][y+1] = '9';
            spielfeld[x+2][y] = '9';
        } else if (richtung == 1 && x + 1 < 10 && y + 2 < 40) {
            spielfeld[x][y] = '9';
            spielfeld[x+1][y+1] = '9';
            spielfeld[x][y+1] = '9';
            spielfeld[x+1][y+2] = '9';
        }
    }
    public static void zeichneZ(int x, int y, int richtung) {
        if (richtung == 0 && x + 2 < 10 && y + 1 < 40) {
            spielfeld[x+1][y] = 'F';
            spielfeld[x][y] = 'F';
            spielfeld[x+1][y+1] = 'F';
            spielfeld[x+2][y+1] = 'F';
        } else if (richtung == 1 && x + 1 < 10 && y + 2 < 40) {
            spielfeld[x+1][y] = 'F';
            spielfeld[x][y+1] = 'F';
            spielfeld[x+1][y+1] = 'F';
            spielfeld[x][y+2] = 'F';
        }
    }
    public static void zeichneJ(int x, int y, int richtung) {
        if (richtung == 0 && x + 2 < 10 && y + 1 < 40) {
            spielfeld[x][y] = '2';
            spielfeld[x+1][y+1] = '2';
            spielfeld[x][y+1] = '2';
            spielfeld[x+2][y+1] = '2';
        } else if (richtung == 1 && x + 1 < 10 && y + 2 < 40) {
            spielfeld[x+1][y] = '2';
            spielfeld[x+1][y+1] = '2';
            spielfeld[x+1][y+2] = '2';
            spielfeld[x][y+2] = '2';
        } else if (richtung == 2 && x + 2 < 10 && y + 1 < 40) {
            spielfeld[x][y] = '2';
            spielfeld[x+1][y] = '2';
            spielfeld[x+2][y] = '2';
            spielfeld[x+2][y+1] = '2';
        } else if (richtung == 3 && x + 1 < 10 && y + 2 < 40) {
            spielfeld[x][y] = '2';
            spielfeld[x][y+1] = '2';
            spielfeld[x][y+2] = '2';
            spielfeld[x+1][y] = '2';
        }
    }
    public static void zeichneL(int x, int y, int richtung) {
        if (richtung == 0 && x + 2 < 10 && y + 1 < 40) {
            spielfeld[x][y+1] = '4';
            spielfeld[x+1][y+1] = '4';
            spielfeld[x+2][y+1] = '4';
            spielfeld[x+2][y] = '4';
        } else if (richtung == 1 && x + 1 < 10 && y + 2 < 40) {
            spielfeld[x+1][y] = '4';
            spielfeld[x+1][y+1] = '4';
            spielfeld[x+1][y+2] = '4';
            spielfeld[x][y] = '4';
        } else if (richtung == 2 && x + 2 < 10 && y + 1 < 40) {
            spielfeld[x][y] = '4';
            spielfeld[x+1][y] = '4';
            spielfeld[x+2][y] = '4';
            spielfeld[x][y+1] = '4';
        } else if (richtung == 3 && x + 1 < 10 && y + 2 < 40){
            spielfeld[x][y] = '4';
            spielfeld[x][y+1] = '4';
            spielfeld[x][y+2] = '4';
            spielfeld[x+1][y+2] = '4';
        }
    }
    public static void main(String[] args) {
        simuliere(100);
    }
}
