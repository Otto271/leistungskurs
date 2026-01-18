package blatt15;
import schisch_visualizer.*;
import blatt13.Zufall;
public class Farben {
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
    public static void startPosition(char[][] arr) {
        for (int i = 8; i > 0; i--) {
            arr[Zufall.zufallGanz(1, 40)][Zufall.zufallGanz(1, arr.length-1)] = 'P';
        }
        for (int i = 8; i > 0; i--) {
            arr[Zufall.zufallGanz(41,arr.length-1)][Zufall.zufallGanz(1,arr.length-1)] = 'P';
        }
    }
    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        char[][] arr = new char[40][40];
        initialisiereSpielfeld(arr);
        startPosition(arr);
        sv.step(arr);
        sv.start();
    }
}
