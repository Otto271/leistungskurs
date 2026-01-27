package blatt15;
import blatt14.MultiArrays;
import schisch_visualizer.*;
import blatt13.Zufall;

public class Spiegel {
    public static void print2DArraySpiegel(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < arr[i].length - 1; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print(arr[i][arr[i].length - 1]);
            System.out.println(" ]");
        }
    }
    public static void zufallSpiegel(char[][] arr) {
        Farben.initialisiereSpielfeld(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int zufall = Zufall.zufallGanz(1,4);
                if (arr[i][j] == ' ') {
                    if (zufall == 1) {
                        arr[i][j] = '/';
                    } else if (zufall == 2) {
                        arr[i][j] = '\\';
                    }
                }
            }
        }
    }
    public static void zufallZiele(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != '/' && arr[i][j] != '\\' && arr[i][j] != '8') {
                    if (Zufall.zufallGanz(1, 3) == 1) {
                        arr[i][j] = 'O';
                    }
                }
            }
        }
    }
    public static void generierePfeil(char[][] arr, int y) {
        arr[y/2][1] = '>';
    }
    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        char[][] spielfeld = blatt14.MultiArrays.createEmpty2DCharArray(40,40);
        zufallSpiegel(spielfeld);
        zufallZiele(spielfeld);
        generierePfeil(spielfeld, 2);
        print2DArraySpiegel(spielfeld);
        sv.step(spielfeld);
        sv.start();
    }
}
