package blatt17;

import blatt14.Simulationen;
import schisch_visualizer.SchischVisualizer;

public class Waldentwicklung {
    static char[][] feld = new char[100][100];
    public static void init() {
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                if (i == 0 || i == feld.length - 1 || j == 0 || j == feld[i].length - 1) {
                    feld[i][j] = '8';
                } else {
                    feld[i][j] = ' ';
                }
            }
        }
    }
    public static void baum(double prozent) {
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                if (feld[i][j] == ' ') {
                    if (Math.random() < prozent) {
                        feld[i][j] = 'B';
                    }
                }
                int zähler = 0;
                if (Simulationen.getNorden(feld, i, j, false) == 'B') {
                    zähler++;
                }
                if (Simulationen.getOsten(feld, i, j, true) == 'B') {
                    zähler++;
                }
                if (Simulationen.getSueden(feld, i, j, false) == 'B') {
                    zähler++;
                }
                if (Simulationen.getWesten(feld, i, j, true) == 'B') {
                    zähler++;
                }
                if (feld[i][j] == ' ') {
                    if (zähler == 1) {
                        if (Math.random()*100 < 2) {
                            feld[i][j] = 'B';
                        }
                    } else if (zähler == 2) {
                        if (Math.random()*100 < 4) {
                            feld[i][j] = 'B';
                        }
                    } else if (zähler == 3) {
                        if (Math.random()*100 < 6) {
                            feld[i][j] = 'B';
                        }
                    } else if (zähler == 4) {
                        if (Math.random()*100 < 8) {
                            feld[i][j] = 'B';
                        }
                    }
                }
            }
        }
    }
    public static void feuer(double prozent) {
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                if (feld[i][j] == 'B') {
                    if (Math.random() < prozent) {
                        feld[i][j] = 'F';
                    }
                } else if (feld[i][j] == 'F') {
                    if (Simulationen.getNorden(feld, i, j, false) == 'B') {
                        feld[i][j-1] = 'F';
                    }
                    if (Simulationen.getOsten(feld, i, j, false) == 'B') {
                        feld[i+1][j] = 'F';
                    }
                    if (Simulationen.getSueden(feld, i, j, false) == 'B') {
                        feld[i][j+1] = 'F';
                    }
                    if (Simulationen.getWesten(feld, i, j, false) == 'B') {
                        feld[i-1][j] = 'F';
                    }
                    feld[i][j] = ' ';
                }

            }
        }
    }

    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        init();
        sv.step(feld);
        for (int i = 0; i < 8000; i++) {
            baum(0.3);
            feuer(0.1);
            sv.step(feld);
        }
        sv.start();
    }
}
