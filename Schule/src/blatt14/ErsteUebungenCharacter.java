package blatt14;
import schisch_visualizer.*;
public class ErsteUebungenCharacter {
    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        char[][] arr = blatt14.MultiArrays.createEmpty2DCharArray(11,14);
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr[0].length; i++) {
                if (j == 0 || j == 2 || j == arr[0].length - 1 || j == arr[0].length - 3) {
                    arr[i][j] = '1';
                }
                sv.step(arr);
                if (i == 0 || i == arr.length-1) {
                    arr[i][j] = '1';
                } else if (i == 3 || i == 5 && j == 4 || j == 5 || j == 6) {
                    arr[i][j] = '1';
                } else if (i == 11 && j == 3 || j == 4 || j == 6) {
                    arr[i][j] = '1';
                }
            }
        }
        //arr[12][0] = '1';
        //arr[12][5] = 'O';
        //arr[12][arr[12].length-1] = '1';
        sv.step(arr);
        sv.start();
    }
}
