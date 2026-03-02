package blatt17;
import blatt14.Simulationen;
import blatt14.MultiArrays;
import schisch_visualizer.SchischVisualizer;

public class GameOfLife {
    static char[][] feld;
    public static void initRandom(double wahrscheinlichkeit) {
        feld = new char[100][100];
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld.length; j++) {
                if (Math.random() < wahrscheinlichkeit) {
                    feld[i][j] = '9';
                } else {
                    feld[i][j] = 'F';
                }
            }
        }
    }
    public static void weiter() {
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                int lebend = 0;
                int tod = 0;
                if (Simulationen.getNorden(feld, i, j, false) == '9') {
                    lebend++;
                } else {
                    tod++;
                }
                if (Simulationen.getOsten(feld, i, j, false) == '9') {
                    lebend++;
                } else {
                    tod++;
                }
                if (Simulationen.getSueden(feld, i, j, false) == '9') {
                    lebend++;
                } else {
                    tod++;
                }
                if (Simulationen.getWesten(feld, i, j, false) == '9') {
                    lebend++;
                } else {
                    tod++;
                }
                if (Simulationen.getNordOst(feld, i, j, false) == '9') {
                    lebend++;
                } else {
                    tod++;
                }
                if (Simulationen.getSuedOst(feld, i, j, false) == '9') {
                    lebend++;
                } else {
                    tod++;
                }
                if (Simulationen.getSuedWest(feld, i, j, false) == '9') {
                    lebend++;
                } else {
                    tod++;
                }
                if (Simulationen.getNordWest(feld, i, j, false) == '9') {
                    lebend++;
                } else {
                    tod++;
                }
            }
        }
    }
    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        initRandom(0.5);
        sv.step(feld);
        sv.start();
    }
}
