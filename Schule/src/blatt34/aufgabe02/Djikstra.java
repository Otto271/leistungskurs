package blatt34.aufgabe02;

import java.util.ArrayList;

public class Djikstra {
    public int[][] dijkstra(int[][] matrix, int start) {
        int[][] wege = new int[matrix.length][3];
        ArrayList<Integer> L = new ArrayList<>();
        wege[start][0] = 0;
        wege[start][1] = start;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[start][i] > 0) {
                L.add(i);
            }
        }
        while (!L.isEmpty()) {
            for (int i = 0; i < L.size(); i++) {
                int m = matrix[start][L.get(i)];
                if (matrix[start][L.get(i+1)] < m) {
                    m = matrix[start][L.get(i)+1];
                }
            }
        }
    }
}
