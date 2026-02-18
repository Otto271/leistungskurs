package blatt15;
import schisch_visualizer.*;
import blatt13.Zufall;

public class Spiegel {
    static char[][] spielfeld = new char[40][40];
    static int[] posy = new int[5];
    static int[] posx = new int[5];
    public static void zufallSpiegel() {
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
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                int zufall = Zufall.zufallGanz(1,3);
                if (spielfeld[i][j] == ' ') {
                    if (Math.random() <= 0.2) {
                        if (zufall == 1) {
                            spielfeld[i][j] = '/';
                        } else if (zufall == 2) {
                            spielfeld[i][j] = '\\';
                        }
                    }
                }
            }
        }
    }
    public static void zufallZiele() {
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                if (spielfeld[i][j] != '/' && spielfeld[i][j] != '\\' && spielfeld[i][j] != '8') {
                    if (Math.random() <= 0.3) {
                        spielfeld[i][j] = 'O';
                    }
                }
            }
        }
    }
    public static void generierePfeil(int y) {
        if (spielfeld[1][y/2] != '8') {
            spielfeld[1][y/2] = '>';
            for (int i = 0; i < posy.length; i++) {
                if (posy[i] == 0) {
                    posy[i] = y/2;
                    posx[i] = 1;
                }
            }
        } else {
            int zufall = Zufall.zufallGanz(1, spielfeld.length-2);
            spielfeld[1][zufall] = '>';
            for (int i = 0; i < posy.length; i++) {
                if (posy[i] == 0) {
                    posy[i] = zufall;
                    posx[i] = 1;
                }
            }
        }
    }
    public static void spiegelSimulation(int schritte, double drehwahrscheinlichkeit, int pfeilabstand) {
        SchischVisualizer sv = new SchischVisualizer();
        sv.step(spielfeld);
        int count = 0;
        int temp = 0;
        for (int i = 0; i < schritte; i++) {
            if (temp == pfeilabstand) {
                generierePfeil(1);
                temp = 0;
            }
            for (int k = 0; k < posy.length; k++) {
                double randm = Math.random();
                if (posy[k] != 0 && posx[k] != 0) {
                    switch (spielfeld[posx[k]][posy[k]]) {
                        case '>':
                            switch (spielfeld[posx[k] + 1][posy[k]]) {
                                case '/':
                                    if (randm < drehwahrscheinlichkeit) {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] + 1][posy[k] - 1] = '^';
                                        posy[k] = posy[k] - 1;
                                        posx[k] = posx[k] + 1;
                                    } else {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                    }
                                    break;
                                case '\\':
                                    if (randm < drehwahrscheinlichkeit) {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] + 1][posy[k] + 1] = 'V';
                                        posy[k] = posy[k] + 1;
                                        posx[k] = posx[k] + 1;
                                    } else {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                    }
                                    break;
                                case ' ':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k] + 1][posy[k]] = '>';
                                    posx[k] = posx[k] + 1;
                                    break;
                                case 'O':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k] + 1][posy[k]] = ' ';
                                    count++;
                                    break;
                            }
                            break;
                        case '<':
                            switch (spielfeld[posx[k] - 1][posy[k]]) {
                                case '/':
                                    if (randm < drehwahrscheinlichkeit) {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] - 1][posy[k] + 1] = 'V';
                                        posy[k] = posy[k] + 1;
                                        posx[k] = posx[k] - 1;
                                    } else {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                    }
                                    break;
                                case '\\':
                                    if (randm < drehwahrscheinlichkeit) {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] - 1][posy[k] - 1] = '^';
                                        posy[k] = posy[k] - 1;
                                        posx[k] = posx[k] - 1;
                                    } else {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                    }
                                    break;
                                case ' ':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k] - 1][posy[k]] = '<';
                                    posx[k] = posx[k] - 1;
                                    break;
                                case 'O':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k] - 1][posy[k]] = ' ';
                                    count++;
                                    break;
                            }
                            break;
                        case '^':
                            switch (spielfeld[posx[k]][posy[k] - 1]) {
                                case '/':
                                    if (randm < drehwahrscheinlichkeit) {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] + 1][posy[k] - 1] = '>';
                                        posy[k] = posy[k] - 1;
                                        posx[k] = posx[k] + 1;
                                    } else {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                    }
                                    break;
                                case '\\':
                                    if (randm < drehwahrscheinlichkeit) {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] - 1][posy[k] - 1] = '<';
                                        posy[k] = posy[k] - 1;
                                        posx[k] = posx[k] - 1;
                                    } else {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                    }
                                    break;
                                case ' ':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k]][posy[k] - 1] = '^';
                                    posy[k] = posy[k] - 1;
                                    break;
                                case 'O':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k]][posy[k] - 1] = ' ';
                                    count++;
                                    break;
                            }
                            break;
                        case 'V':
                            switch (spielfeld[posx[k]][posy[k] + 1]) {
                                case '/':
                                    if (randm < drehwahrscheinlichkeit) {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] - 1][posy[k] + 1] = '<';
                                        posy[k] = posy[k] + 1;
                                        posx[k] = posx[k] - 1;
                                    } else {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                    }
                                    break;
                                case '\\':
                                    if (randm < drehwahrscheinlichkeit) {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] + 1][posy[k] + 1] = '>';
                                        posy[k] = posy[k] + 1;
                                        posx[k] = posx[k] + 1;
                                    } else {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                    }
                                    break;
                                case ' ':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k]][posy[k] + 1] = 'V';
                                    posy[k] = posy[k] + 1;
                                    break;
                                case 'O':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k]][posy[k] + 1] = ' ';
                                    count++;
                                    break;
                            }
                            break;
                    }
                }
            }
            sv.step(spielfeld);
            temp++;
        }
        sv.start();
        System.out.println(count);
    }
    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        zufallSpiegel();
        zufallZiele();
        generierePfeil(1);
        sv.step(spielfeld);
        spiegelSimulation(20,0.3,5);
    }
}
