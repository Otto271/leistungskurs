package blatt14;

public class Simulationen {
    public static char[][] fuellen (char[][] arr, char a, double random) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (Math.random() <= random) {
                    arr[i][j] = a;
                }
            }
        }
        return arr;
    }
    public static char[][] fuellen (char[][] arr, char neutral, char ersatz) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == neutral) {
                    arr[i][j] = ersatz;
                }
            }
        }
        return arr;
    }
    public static char[][] platzieren (char[][] arr, char a, boolean dopplung) {
        int zufall01 = blatt13.Zufall.zufallGanz(0, arr.length);
        int zufall02 = blatt13.Zufall.zufallGanz(0, arr[0].length);
        if (dopplung) {
            while (true) {
                if (arr[zufall01][zufall02] != a) {
                    arr[zufall01][zufall02] = a;
                    break;
                } else {
                    zufall01 = blatt13.Zufall.zufallGanz(0, arr.length);
                    zufall02 = blatt13.Zufall.zufallGanz(0, arr[0].length);
                }
            }
        } else {
            arr[zufall01][zufall02] = a;
        }
        return arr;
    }
    public static char getNorden (char[][] arr, int posx, int posy, boolean rand) {
        char nord;
        if (!rand && posy != 0) {
            nord = arr[posx][posy-1];
        } else {
            nord = arr[posx][arr[0].length-1];
        }
        return nord;
    }
    public static char getSueden (char[][] arr, int posx, int posy, boolean rand) {
        char sued;
        if (!rand && posy != arr[0].length-1) {
            sued = arr[posx][posy+1];
        } else {
            sued = arr[posx][0];
        }
        return sued;
    }
    public static char getWesten (char[][] arr, int posx, int posy, boolean rand) {
        char west;
        if (!rand && posx != arr.length-1) {
            west = arr[posx+1][posy];
        } else {
            west = arr[0][posy];
        }
        return west;
    }
    public static char getOsten(char[][] arr, int posx, int posy, boolean rand) {
        char ost;
        if (!rand && posx != 0) {
            ost = arr[posx-1][posy];
        } else {
            ost = arr[arr.length-1][posy];
        }
        return ost;
    }
}
