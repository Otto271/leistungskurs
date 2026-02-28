package blatt15;
import schisch_visualizer.*;
import blatt13.Zufall;

public class Spiegel {
    static char[][] spielfeld = new char[40][40];
    static int[] posy = new int[20];
    static int[] posx = new int[20];
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
            for (int i = 0; i < posy.length; i++) {
                if (posy[i] == 0 && spielfeld[1][y/2] != '8' && spielfeld[1][y/2] != '/' && spielfeld[1][y/2] != '\\') {
                    spielfeld[1][y/2] = '>';
                    posy[i] = y/2;
                    posx[i] = 1;
                }
            }
        } else {
            while (true) {
                int zufall = Zufall.zufallGanz(1, spielfeld.length - 2);
                for (int i = 0; i < posy.length; i++) {
                    if (posy[i] == 0 && spielfeld[1][zufall] != '8' && spielfeld[1][zufall] != '/' && spielfeld[1][zufall] != '\\') {
                        spielfeld[1][zufall] = '>';
                        posy[i] = zufall;
                        posx[i] = 1;
                        return;
                    }
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
                                    if (spielfeld[posx[k] + 1][posy[k] - 1] == '/') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] + 2][posy[k] - 1] = '>';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k] + 1][posy[k]] = '\\';
                                            spielfeld[posx[k] + 1][posy[k] - 1] = '\\';
                                        }
                                        posy[k] = posy[k] - 1;
                                        posx[k] = posx[k] + 2;
                                        break;
                                    } else if (spielfeld[posx[k] + 1][posy[k] - 1] == '\\') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k]][posy[k] - 1] = '<';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k] + 1][posy[k]] = '\\';
                                            spielfeld[posx[k] + 1][posy[k] - 1] = '/';
                                        }
                                        posy[k] = posy[k] - 1;
                                        break;
                                    } else if (spielfeld[posx[k] + 1][posy[k] - 1] == 'O') { //TODO Respawn einbinden
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] + 1][posy[k] - 1] = ' ';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k] + 1][posy[k]] = '\\';
                                        }
                                        posx[k] = 0;
                                        posy[k] = 0;
                                        count++;
                                        generierePfeil(1);
                                        break;
                                    } else if (spielfeld[posx[k] + 1][posy[k] - 1] == '8') {
                                        break;
                                    } else {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] + 1][posy[k] - 1] = '^';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k] + 1][posy[k]] = '\\';
                                        }
                                        posy[k] = posy[k] - 1;
                                        posx[k] = posx[k] + 1;
                                        break;
                                    }
                                case '\\':
                                    if (spielfeld[posx[k] + 1][posy[k] + 1] == '/') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k]][posy[k] + 1] = '<';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k] + 1][posy[k]] = '/';
                                            spielfeld[posx[k] + 1][posy[k] + 1] = '\\';
                                        }
                                        posy[k] = posy[k] + 1;
                                        break;
                                    } else if (spielfeld[posx[k] + 1][posy[k] + 1] == '\\') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] + 2][posy[k] + 1] = '>';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k] + 1][posy[k]] = '/';
                                            spielfeld[posx[k] + 1][posy[k] + 1] = '/';
                                        }
                                        posy[k] = posy[k] + 1;
                                        posx[k] = posx[k] + 2;
                                        break;
                                    } else if (spielfeld[posx[k] + 1][posy[k] + 1] == 'O') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] + 1][posy[k] + 1] = ' ';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k] + 1][posy[k]] = '\\';
                                        }
                                        posx[k] = 0;
                                        posy[k] = 0;
                                        count++;
                                        generierePfeil(1);
                                        break;
                                    } else if (spielfeld[posx[k] + 1][posy[k] + 1] == '8') {
                                        break;
                                    } else {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] + 1][posy[k] + 1] = 'V';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k] + 1][posy[k]] = '/';
                                        }
                                        posy[k] = posy[k] + 1;
                                        posx[k] = posx[k] + 1;
                                        break;
                                    }
                                case ' ':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k] + 1][posy[k]] = '>';
                                    posx[k] = posx[k] + 1;
                                    break;
                                case 'O':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k] + 1][posy[k]] = ' ';
                                    posy[k] = 0;
                                    posx[k] = 0;
                                    count++;
                                    generierePfeil(1);
                                    break;
                                case '<':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k] + 1][posy[k]] = ' ';
                                    for (int j = 0; j < posy.length; j++) {
                                        if (posy[j] == posy[k] && posx[k] + 1 == posx[j]) {
                                            posy[j] = 0;
                                            posx[j] = 0;
                                        }
                                    }
                                    posy[k] = 0;
                                    posx[k] = 0;
                                case '>':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k] + 1][posy[k]] = ' ';
                                    for (int j = 0; j < posy.length; j++) {
                                        if (posy[j] == posy[k] && posx[k] + 1 == posx[j]) {
                                            posy[j] = 0;
                                            posx[j] = 0;
                                        }
                                    }
                                    posy[k] = 0;
                                    posx[k] = 0;
                                case '^':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k] + 1][posy[k]] = ' ';
                                    for (int j = 0; j < posy.length; j++) {
                                        if (posy[j] == posy[k] && posx[k] + 1 == posx[j]) {
                                            posy[j] = 0;
                                            posx[j] = 0;
                                        }
                                    }
                                    posy[k] = 0;
                                    posx[k] = 0;
                                case 'V':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k] + 1][posy[k]] = ' ';
                                    for (int j = 0; j < posy.length; j++) {
                                        if (posy[j] == posy[k] && posx[k] + 1 == posx[j]) {
                                            posy[j] = 0;
                                            posx[j] = 0;
                                        }
                                    }
                                    posy[k] = 0;
                                    posx[k] = 0;
                            }
                            break;
                        case '<':
                            switch (spielfeld[posx[k] - 1][posy[k]]) {
                                case '/':
                                    if (spielfeld[posx[k] - 1][posy[k] + 1] == '/') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] - 2][posy[k] + 1] = '<';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k] - 1][posy[k]] = '\\';
                                            spielfeld[posx[k] - 1][posy[k] + 1] = '\\';
                                        }
                                        posy[k] = posy[k] + 1;
                                        posx[k] = posx[k] - 2;
                                        break;
                                    } else if (spielfeld[posx[k] - 1][posy[k] + 1] == '\\') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k]][posy[k] + 1] = '>';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k] - 1][posy[k]] = '\\';
                                            spielfeld[posx[k] - 1][posy[k] + 1] = '/';
                                        }
                                        posy[k] = posy[k] + 1;
                                        posx[k] = posx[k] - 1;
                                        break;
                                    } else if (spielfeld[posx[k] - 1][posy[k] + 1] == 'O') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] - 1][posy[k] + 1] = ' ';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k] + 1][posy[k]] = '\\';
                                        }
                                        posx[k] = 0;
                                        posy[k] = 0;
                                        count++;
                                        generierePfeil(1);
                                        break;
                                    } else if (spielfeld[posx[k] - 1][posy[k] + 1] == '8') {
                                        break;
                                    } else {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] - 1][posy[k] + 1] = 'V';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k] - 1][posy[k]] = '\\';
                                        }
                                        posy[k] = posy[k] + 1;
                                        posx[k] = posx[k] - 1;
                                        break;
                                    }
                                case '\\':
                                    if (spielfeld[posx[k] - 1][posy[k] - 1] == '/') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k]][posy[k] - 1] = '>';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k] - 1][posy[k]] = '/';
                                            spielfeld[posx[k] - 1][posy[k] - 1] = '\\';
                                        }
                                        posy[k] = posy[k] - 1;
                                        break;
                                    } else if (spielfeld[posx[k] - 1][posy[k] - 1] == '\\') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k]][posy[k] - 1] = '>';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k] - 1][posy[k]] = '/';
                                            spielfeld[posx[k] - 1][posy[k] - 1] = '/';
                                        }
                                        posy[k] = posy[k] - 1;
                                        break;
                                    } else if (spielfeld[posx[k] - 1][posy[k] - 1] == 'O') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] - 1][posy[k] - 1] = ' ';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k] - 1][posy[k]] = '/';
                                        }
                                        posx[k] = 0;
                                        posy[k] = 0;
                                        count++;
                                        generierePfeil(1);
                                        break;
                                    } else if (spielfeld[posx[k] - 1][posy[k] - 1] == '8') {
                                        break;
                                    } else {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] - 1][posy[k] - 1] = '^';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k] - 1][posy[k]] = '/';
                                        }
                                        posy[k] = posy[k] - 1;
                                        posx[k] = posx[k] - 1;
                                        break;
                                    }
                                case ' ':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k] - 1][posy[k]] = '<';
                                    posx[k] = posx[k] - 1;
                                    break;
                                case 'O':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k] - 1][posy[k]] = ' ';
                                    posy[k] = 0;
                                    posx[k] = 0;
                                    count++;
                                    generierePfeil(1);
                                    break;
                                case '>':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k] - 1][posy[k]] = ' ';
                                    for (int j = 0; j < posy.length; j++) {
                                        if (posy[j] == posy[k] && posx[k] - 1 == posx[j]) {
                                            posy[j] = 0;
                                            posx[j] = 0;
                                        }
                                    }
                                    posy[k] = 0;
                                    posx[k] = 0;
                                case '<':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k] - 1][posy[k]] = ' ';
                                    for (int j = 0; j < posy.length; j++) {
                                        if (posy[j] == posy[k] && posx[k] - 1 == posx[j]) {
                                            posy[j] = 0;
                                            posx[j] = 0;
                                        }
                                    }
                                    posy[k] = 0;
                                    posx[k] = 0;
                                case '^':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k] - 1][posy[k]] = ' ';
                                    for (int j = 0; j < posy.length; j++) {
                                        if (posy[j] == posy[k] && posx[k] - 1 == posx[j]) {
                                            posy[j] = 0;
                                            posx[j] = 0;
                                        }
                                    }
                                    posy[k] = 0;
                                    posx[k] = 0;
                                case 'V':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k] - 1][posy[k]] = ' ';
                                    for (int j = 0; j < posy.length; j++) {
                                        if (posy[j] == posy[k] && posx[k] - 1 == posx[j]) {
                                            posy[j] = 0;
                                            posx[j] = 0;
                                        }
                                    }
                                    posy[k] = 0;
                                    posx[k] = 0;
                            }
                            break;
                        case '^':
                            switch (spielfeld[posx[k]][posy[k] - 1]) {
                                case '/':
                                    if (spielfeld[posx[k] + 1][posy[k] - 1] == '/') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] + 1][posy[k] - 2] = '^';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k]][posy[k] - 1] = '\\';
                                            spielfeld[posx[k] + 1][posy[k] - 1] = '\\';
                                        }
                                        posy[k] = posy[k] - 2;
                                        posx[k] = posx[k] + 1;
                                        break;
                                    } else if (spielfeld[posx[k] + 1][posy[k] - 1] == '\\') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] + 1][posy[k]] = 'V';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k] + 1][posy[k]] = '\\';
                                            spielfeld[posx[k] + 1][posy[k] - 1] = '/';
                                        }
                                        posx[k] = posx[k] + 1;
                                        break;
                                    } else if (spielfeld[posx[k] + 1][posy[k] - 1] == 'O') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] + 1][posy[k] - 1] = ' ';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k]][posy[k] - 1] = '\\';
                                        }
                                        posx[k] = 0;
                                        posy[k] = 0;
                                        count++;
                                        generierePfeil(1);
                                        break;
                                    } else if (spielfeld[posx[k] + 1][posy[k] - 1] == '8') {
                                        break;
                                    } else {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] + 1][posy[k] - 1] = '>';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k]][posy[k] - 1] = '\\';
                                        }
                                        posy[k] = posy[k] - 1;
                                        posx[k] = posx[k] + 1;
                                        break;
                                    }
                                case '\\':
                                    if (spielfeld[posx[k] - 1][posy[k] - 1] == '/') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] - 1][posy[k]] = 'V';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k]][posy[k] - 1] = '/';
                                            spielfeld[posx[k] + 1][posy[k] - 1] = '\\';
                                        }
                                        posx[k] = posx[k] - 1;
                                        break;
                                    } else if (spielfeld[posx[k] - 1][posy[k] - 1] == '\\') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] - 1][posy[k] - 2] = '^';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k]][posy[k] - 1] = '/';
                                            spielfeld[posx[k] + 1][posy[k] - 1] = '/';
                                        }
                                        posy[k] = posy[k] - 2;
                                        posx[k] = posx[k] - 1;
                                        break;
                                    } else if (spielfeld[posx[k] - 1][posy[k] - 1] == 'O') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] - 1][posy[k] - 1] = ' ';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k]][posy[k] - 1] = '/';
                                        }
                                        posx[k] = 0;
                                        posy[k] = 0;
                                        count++;
                                        generierePfeil(1);
                                        break;
                                    } else if (spielfeld[posx[k] - 1][posy[k] - 1] == '8') {
                                        break;
                                    } else {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] - 1][posy[k] - 1] = '<';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k]][posy[k] - 1] = '/';
                                        }
                                        posy[k] = posy[k] - 1;
                                        posx[k] = posx[k] - 1;
                                        break;
                                    }
                                case ' ':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k]][posy[k] - 1] = '^';
                                    posy[k] = posy[k] - 1;
                                    break;
                                case 'O':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k]][posy[k] - 1] = ' ';
                                    posy[k] = 0;
                                    posx[k] = 0;
                                    count++;
                                    generierePfeil(1);
                                    break;
                                case '<':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k]][posy[k] - 1] = ' ';
                                    for (int j = 0; j < posy.length; j++) {
                                        if (posy[j] == posy[k] - 1 && posx[k] == posx[j]) {
                                            posy[j] = 0;
                                            posx[j] = 0;
                                        }
                                    }
                                    posy[k] = 0;
                                    posx[k] = 0;
                                case '>':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k]][posy[k] - 1] = ' ';
                                    for (int j = 0; j < posy.length; j++) {
                                        if (posy[j] == posy[k] - 1 && posx[k] == posx[j]) {
                                            posy[j] = 0;
                                            posx[j] = 0;
                                        }
                                    }
                                    posy[k] = 0;
                                    posx[k] = 0;
                                case '^':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k]][posy[k] - 1] = ' ';
                                    for (int j = 0; j < posy.length; j++) {
                                        if (posy[j] == posy[k] - 1 && posx[k] == posx[j]) {
                                            posy[j] = 0;
                                            posx[j] = 0;
                                        }
                                    }
                                    posy[k] = 0;
                                    posx[k] = 0;
                                case 'V':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k]][posy[k] - 1] = ' ';
                                    for (int j = 0; j < posy.length; j++) {
                                        if (posy[j] == posy[k] - 1 && posx[k] == posx[j]) {
                                            posy[j] = 0;
                                            posx[j] = 0;
                                        }
                                    }
                                    posy[k] = 0;
                                    posx[k] = 0;
                            }
                            break;
                        case 'V':
                            switch (spielfeld[posx[k]][posy[k] + 1]) {
                                case '/':
                                    if (spielfeld[posx[k] - 1][posy[k] + 1] == '/') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] - 1][posy[k] + 2] = 'V';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k]][posy[k] + 1] = '\\';
                                            spielfeld[posx[k] - 1][posy[k] + 1] = '\\';
                                        }
                                        posy[k] = posy[k] - 1;
                                        posx[k] = posx[k] + 2;
                                        break;
                                    } else if (spielfeld[posx[k] - 1][posy[k] + 1] == '\\') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] - 1][posy[k]] = '^';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k]][posy[k] + 1] = '\\';
                                            spielfeld[posx[k] - 1][posy[k] + 1] = '/';
                                        }
                                        posx[k] = posx[k] - 1;
                                        break;
                                    } else if (spielfeld[posx[k] - 1][posy[k] + 1] == 'O') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] - 1][posy[k] + 1] = ' ';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k]][posy[k] + 1] = '\\';
                                        }
                                        posx[k] = 0;
                                        posy[k] = 0;
                                        count++;
                                        generierePfeil(1);
                                        break;
                                    } else if (spielfeld[posx[k] - 1][posy[k] + 1] == '8') {
                                        break;
                                    } else {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] - 1][posy[k] + 1] = '<';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k]][posy[k] + 1] = '\\';
                                        }
                                        posx[k] = posx[k] - 1;
                                        posy[k] = posy[k] + 1;
                                        break;
                                    }
                                case '\\':
                                    if (spielfeld[posx[k] + 1][posy[k] + 1] == '/') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] + 1][posy[k]] = '^';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k]][posy[k] + 1] = '/';
                                            spielfeld[posx[k] + 1][posy[k] + 1] = '\\';
                                        }
                                        posx[k] = posx[k] + 1;
                                        break;
                                    } else if (spielfeld[posx[k] + 1][posy[k] + 1] == '\\') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] + 1][posy[k] + 2] = '<';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k]][posy[k] + 1] = '/';
                                            spielfeld[posx[k] + 1][posy[k] + 1] = '/';
                                        }
                                        posy[k] = posy[k] + 2;
                                        posx[k] = posx[k] + 1;
                                        break;
                                    } else if (spielfeld[posx[k] + 1][posy[k] + 1] == 'O') {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] + 1][posy[k] + 1] = ' ';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k]][posy[k] + 1] = '\\';
                                        }
                                        posx[k] = 0;
                                        posy[k] = 0;
                                        count++;
                                        generierePfeil(1);
                                        break;
                                    } else if (spielfeld[posx[k] + 1][posy[k] + 1] == '8') {
                                        break;
                                    } else {
                                        spielfeld[posx[k]][posy[k]] = ' ';
                                        spielfeld[posx[k] + 1][posy[k] + 1] = '>';
                                        if (randm < drehwahrscheinlichkeit) {
                                            spielfeld[posx[k]][posy[k] + 1] = '/';
                                        }
                                        posy[k] = posy[k] + 1;
                                        posx[k] = posx[k] + 1;
                                        break;
                                    }
                                case ' ':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k]][posy[k] + 1] = 'V';
                                    posy[k] = posy[k] + 1;
                                    break;
                                case 'O':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k]][posy[k] + 1] = ' ';
                                    posy[k] = 0;
                                    posx[k] = 0;
                                    count++;
                                    generierePfeil(1);
                                    break;
                                case '<':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k]][posy[k] + 1] = ' ';
                                    for (int j = 0; j < posy.length; j++) {
                                        if (posy[j] == posy[k] + 1 && posx[k] == posx[j]) {
                                            posy[j] = 0;
                                            posx[j] = 0;
                                        }
                                    }
                                    posy[k] = 0;
                                    posx[k] = 0;
                                case '>':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k]][posy[k] + 1] = ' ';
                                    for (int j = 0; j < posy.length; j++) {
                                        if (posy[j] == posy[k] + 1 && posx[k] == posx[j]) {
                                            posy[j] = 0;
                                            posx[j] = 0;
                                        }
                                    }
                                    posy[k] = 0;
                                    posx[k] = 0;
                                case '^':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k]][posy[k] + 1] = ' ';
                                    for (int j = 0; j < posy.length; j++) {
                                        if (posy[j] == posy[k] + 1 && posx[k] == posx[j]) {
                                            posy[j] = 0;
                                            posx[j] = 0;
                                        }
                                    }
                                    posy[k] = 0;
                                    posx[k] = 0;
                                case 'V':
                                    spielfeld[posx[k]][posy[k]] = ' ';
                                    spielfeld[posx[k]][posy[k] + 1] = ' ';
                                    for (int j = 0; j < posy.length; j++) {
                                        if (posy[j] == posy[k] + 1 && posx[k] == posx[j]) {
                                            posy[j] = 0;
                                            posx[j] = 0;
                                        }
                                    }
                                    posy[k] = 0;
                                    posx[k] = 0;
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
        spiegelSimulation(100,1,5);
    }
}
