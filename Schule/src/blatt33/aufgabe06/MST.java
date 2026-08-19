package blatt33.aufgabe06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import blatt32.aufgabe03.Graph;
import schgraphs.*;

public class MST {

    public static Edge findSmallestWeight(ArrayList<Edge> edges) {
        Edge e = edges.get(0);
        for (int i = 1; i < edges.size(); i++) {
            if (edges.get(i).weight < e.weight) {
                e = edges.get(i);
            }
        }
        return e;
    }

    public static void primMST(int[][] matrix) {
        SchGraphs sg = new SchGraphs();
        int[][] graph = new int[matrix.length][matrix[0].length];
        sg.step(graph);
        ArrayList <Integer> list = new ArrayList<Integer>();
        ArrayList <Integer> already = new ArrayList<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            list.add(i);
        }
        int x = (int)list.getFirst();
        list.remove((Integer)x);
        already.add((Integer)x);
        int count = 0;


        while(!list.isEmpty() ){

            ArrayList<Edge> kanten = new ArrayList<>();

            for (Integer i : already) {
                for (int j = 0;j < matrix.length;j++) {
                    if(matrix[i][j] > 0 && list.contains((Integer)j) && already.contains((Integer)i)){
                        //System.out.println("Accepted");
                        kanten.add(new Edge(i,j,matrix[i][j]));

                    }
                }
            }


            /*
            for(int i = 0; i < matrix.length; i++){
                for (int j = i+1; j < matrix.length; j++){
                    if (matrix[i][j] > 0) {
                        System.out.println("Check for " + i + " -> " + j);
                        System.out.println("Weigth: " + matrix[i][j]);
                        System.out.println(j + " in List " + list.contains((Integer)(j)));
                        System.out.println(i + " in Already " + already.contains((Integer)(i)));
                    }

                    if(matrix[i][j] > 0 && list.contains((Integer)j) && already.contains((Integer)i)){
                        System.out.println("Accepted");
                        kanten.add(new Edge(i,j,matrix[i][j]));

                    }
                }

            }

             */

            if (!kanten.isEmpty()) {

                Edge e = findSmallestWeight(kanten);
                System.out.println("Anzahl Kanten: " + kanten.size());
                System.out.println(e.from + " -> " + e.to + " " + e.weight);
                graph[e.from][e.to] = e.weight;
                graph[e.to][e.from] = e.weight;

                list.remove((Integer)(e.to));
                already.add((Integer)(e.to));


            }

            sg.step(graph);

            count++;

        }
        sg.start();
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.importGraph("C:\\Users\\JuliusHillenbrand\\Downloads\\graph04");
        primMST(g.getAdjacencyMatrix());
    }
}
