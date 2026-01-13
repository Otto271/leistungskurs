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
        char nord = 0;
        if (posy != 0) {
            nord = arr[posx][posy-1];
        } else if (rand) {
            nord = arr[posx][arr[0].length-1];
        } else {
            nord = arr[posx][posy];
        }
        return nord;
    }
    public static char getSueden (char[][] arr, int posx, int posy, boolean rand) {
        char sued;
        if (posy != arr[0].length-1) {
            sued = arr[posx][posy+1];
        } else if (rand) {
            sued = arr[posx][0];
        } else {
            sued = arr[posx][posy];
        }
        return sued;
    }
    public static char getWesten (char[][] arr, int posx, int posy, boolean rand) {
        char west;
        if (posx != 0) {
            west = arr[posx-1][posy];
        } else if (rand) {
            west = arr[arr.length-1][posy];
        }  else {
            west = arr[posx][posy];
        }
        return west;
    }
    public static char getOsten(char[][] arr, int posx, int posy, boolean rand) {
        char ost;
        if (posx != arr.length-1) {
            ost = arr[posx+1][posy];
        } else if (rand) {
            ost = arr[0][posy];
        } else {
            ost = arr[posx][posy];
        }
        return ost;
    }
    public static char getNordWest (char[][] arr, int posx, int posy, boolean rand) {
        if (posx == 0) {
            if (!rand) {
                return '-';
            } else {
                posx = arr.length-1;
            }
        } else {
            posx--;
        }
        if (posy == 0) {
            if (!rand) {
                return '-';
            } else {
                posy = arr[0].length-1;
            }
        } else  {
            posy--;
        }
        return arr[posx][posy];
    }
    public static char getNordOst (char[][] arr, int posx, int posy, boolean rand) {
        if (posx == arr.length-1) {
            if (!rand) {
                return '-';
            } else {
                posx = 0;
            }
        } else {
            posx++;
        }
        if (posy == 0) {
            if (!rand) {
                return '-';
            } else {
                posy = arr[0].length-1;
            }
        } else  {
            posy--;
        }
        return arr[posx][posy];
    }
    public static char getSuedWest (char[][] arr, int posx, int posy, boolean rand) {
        if (posx == 0) {
            if (!rand) {
                return '-';
            } else {
                posx = arr.length-1;
            }
        } else {
            posx--;
        }
        if (posy == arr[0].length-1) {
            if (!rand) {
                return '-';
            } else {
                posy = 0;
            }
        } else  {
            posy++;
        }
        return arr[posx][posy];
    }
    public static char getSuedOst (char[][] arr, int posx, int posy, boolean rand) {
        if (posx == arr.length-1) {
            if (!rand) {
                return '-';
            } else {
                posx = 0;
            }
        } else  {
            posx++;
        }
        if (posy == arr[0].length-1) {
            if (!rand) {
                return '-';
            } else {
                posy = 0;
            }
        } else {
            posy++;
        }
        return arr[posx][posy];
    }
    public static int zaehlenVier (char[][] arr, int posx, int posy, boolean rand, char suche) {
        int menge = 0;
        if (getNorden(arr, posx, posy, rand) == suche) {
            menge++;
        }
        if (getSueden(arr, posx, posy, rand) == suche) {
            menge++;
        }
        if (getWesten(arr, posx, posy, rand) == suche) {
            menge++;
        }
        if (getOsten(arr, posx, posy, rand) == suche) {
            menge++;
        }
        return menge;
    }
    public static int zaehlenAcht(char[][] arr, int posx, int posy, boolean rand, char suche) {
        int menge = 0;
        if (getNorden(arr, posx, posy, rand) == suche) {
            menge++;
        }
        if (getSueden(arr, posx, posy, rand) == suche) {
            menge++;
        }
        if (getWesten(arr, posx, posy, rand) == suche) {
            menge++;
        }
        if (getOsten(arr, posx, posy, rand) == suche) {
            menge++;
        }
        if (getNordWest(arr, posx, posy, rand) == suche) {
            menge++;
        }
        if (getSuedWest(arr, posx, posy, rand) == suche) {
            menge++;
        }
        if (getNordOst(arr, posx, posy, rand) == suche) {
            menge++;
        }
        if (getSuedOst(arr, posx, posy, rand) == suche) {
            menge++;
        }
        return menge;
    }
}
