package blatt14;
import schisch_visualizer.*;

import java.util.stream.IntStream;

public class ErsteUebungenCharacter {
    public static void main(String[] args) {
        SchischVisualizer sv = new SchischVisualizer();
        char[][] arr = blatt14.MultiArrays.createEmpty2DCharArray(11, 14);
        IntStream.range(0, arr.length).forEach(i -> arr[i][0] = '1');
        IntStream.range(0, arr[0].length).forEach(i -> arr[0][i] = '1');
        IntStream.range(0, arr[0].length).forEach(i -> arr[10][i] = '1');
        IntStream.range(0, arr.length).forEach(i -> arr[i][13] = '1');
        IntStream.range(0, arr[0].length-2).forEach(i -> arr[2][i] = '1');
        IntStream.range(0, arr[0].length-2).forEach(i -> arr[8][i] = '1');
        IntStream.range(4, 7).forEach(i -> arr[i][3] = '1');
        IntStream.range(4, 7).forEach(i -> arr[i][5] = '1');
        IntStream.range(3, 5).forEach(i -> arr[i][11] = '1');
        IntStream.range(6, 8).forEach(i -> arr[i][11] = '1');
        arr[5][12] = 'P';
        sv.step(arr);
        sv.start();
    }
}
