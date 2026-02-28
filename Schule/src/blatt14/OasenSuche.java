package blatt14;

import schisch_visualizer.SchischVisualizer;

public class OasenSuche {
    static char[][] spielfeld;
    static int posx;
    static int posy;
    static int energie;
    public static void initialisiereSpielfeld (int x, int y) {
        spielfeld = MultiArrays.createEmpty2DCharArray(x,y);
    }
    public static void zufallsPositionSpieler() {
        if (spielfeld != null) {
            int zufallx = blatt13.Zufall.zufallGanz(0, spielfeld.length-1);
            int zufally = blatt13.Zufall.zufallGanz(0, spielfeld[0].length-1);
            spielfeld[zufallx][zufally] = 'P';
            posx = zufallx;
            posy = zufally;
        }
    }
    public static void wasserZufall(double wahrscheinlichkeit) {
        if (spielfeld != null) {
            for (int i = 0; i < spielfeld.length; i++) {
                for (int j = 0; j < spielfeld[i].length; j++) {
                    if (spielfeld[i][j] == ' ' && Math.random() <= wahrscheinlichkeit) {
                        spielfeld[i][j] = '6';
                    }
                }
            }
        }
    }
    public static void steinZufall(double wahrscheinlichkeit) {
        if (spielfeld != null) {
            for (int i = 0; i < spielfeld.length; i++) {
                for (int j = 0; j < spielfeld[i].length; j++) {
                    if (spielfeld[i][j] == ' ' && Math.random() <= wahrscheinlichkeit) {
                        spielfeld[i][j] = '8';
                    }
                }
            }
        }
    }
    public static void energie(int energie) {
        OasenSuche.energie = energie;
    }
    public static void findeWasser(int energie, int x, int y, double zufallwasser, double zufallstein) {
        SchischVisualizer sv = new SchischVisualizer();
        initialisiereSpielfeld(x,y);
        zufallsPositionSpieler();
        wasserZufall(zufallwasser);
        steinZufall(zufallstein);
        sv.step(spielfeld);
        energie(energie);
        while (OasenSuche.energie > 0) {
            char norden = Simulationen.getNorden(spielfeld, posx, posy, true);
            char westen = Simulationen.getWesten(spielfeld, posx, posy, true);
            char sueden = Simulationen.getSueden(spielfeld, posx, posy, true);
            char osten = Simulationen.getOsten(spielfeld, posx, posy, true);
            if (norden == '6' || westen == '6' || sueden == '6' || osten == '6') {
                energie++;
            }
            if ((norden == '8' || norden == '6') && (westen == '8' || westen == '6') &&
                    (sueden == '8' || sueden == '6') && (osten == '8' || osten == '6')) {
                System.out.println("Press F to Pay Respects.STUCK!");
                break;
            }

            boolean bewegung = false;
            int versuche = 0;
            while (!bewegung && versuche < 100) {
                int randm = blatt13.Zufall.zufallGanz(0, 3);

                if (randm == 0 && norden != '8' && norden != '6' && norden != '1') {
                    spielfeld[posx][posy] = '1';
                    posy = (posy == 0) ? spielfeld[0].length - 1 : posy - 1;
                    spielfeld[posx][posy] = 'P';
                    bewegung = true;
                } else if (randm == 1 && westen != '8' && westen != '6' && westen != '1') {
                    spielfeld[posx][posy] = '1';
                    posx = (posx == 0) ? spielfeld.length - 1 : posx - 1;
                    spielfeld[posx][posy] = 'P';
                    bewegung = true;
                } else if (randm == 2 && sueden != '8' && sueden != '6' && sueden != '1') {
                    spielfeld[posx][posy] = '1';
                    posy = (posy == spielfeld[0].length - 1) ? 0 : posy + 1;
                    spielfeld[posx][posy] = 'P';
                    bewegung = true;
                } else if (randm == 3 && osten != '8' && osten != '6' && osten != '1') {
                    spielfeld[posx][posy] = '1';
                    posx = (posx == spielfeld.length - 1) ? 0 : posx + 1;
                    spielfeld[posx][posy] = 'P';
                    bewegung = true;
                }
                if (versuche >= 99 && !bewegung) {
                    if (randm == 0 && norden != '8' && norden != '6') {
                        spielfeld[posx][posy] = '1';
                        posy = (posy == 0) ? spielfeld[0].length - 1 : posy - 1;
                        spielfeld[posx][posy] = 'P';
                        bewegung = true;
                    } else if (randm == 1 && westen != '8' && westen != '6') {
                        spielfeld[posx][posy] = '1';
                        posx = (posx == 0) ? spielfeld.length - 1 : posx - 1;
                        spielfeld[posx][posy] = 'P';
                        bewegung = true;
                    } else if (randm == 2 && sueden != '8' && sueden != '6') {
                        spielfeld[posx][posy] = '1';
                        posy = (posy == spielfeld[0].length - 1) ? 0 : posy + 1;
                        spielfeld[posx][posy] = 'P';
                        bewegung = true;
                    } else if (randm == 3 && osten != '8' && osten != '6') {
                        spielfeld[posx][posy] = '1';
                        posx = (posx == spielfeld.length - 1) ? 0 : posx + 1;
                        spielfeld[posx][posy] = 'P';
                        bewegung = true;
                    }
                }
                versuche++;
            }
            OasenSuche.energie--;
            sv.step(spielfeld);
        }
        sv.start();
        System.out.println("Press F to Pay Respects.");
    }
    public static void main(String[] args) {
        findeWasser(50, 60, 60, 0.03, 0.15);
    }
}
