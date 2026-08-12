package blatt32.aufgabe03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Graph {
    int [][] graph;

    public Graph() {
        this.graph = new int[0][0];
    }

    public Graph(int mengeKnoten) {
        this.graph = new  int[mengeKnoten][mengeKnoten];
    }

    public void addVertex() {
        int [][] newGraph = new int [this.graph.length+1][this.graph.length+1];
        for (int i = 0; i < this.graph.length; i++) {
            for (int j = 0; j < this.graph[i].length; j++) {
                newGraph[i][j] = this.graph[i][j];
            }
        }
        this.graph = newGraph;
    }

    public void addEdge(int from, int to) {
        this.graph[to][from] = 1;
        this.graph[from][to] = 1;
    }

    public void addEdge(int from, int to, boolean isDirected) {
        if (isDirected) {
            this.graph[to][from] = 1;
        } else {
            this.graph[to][from] = 1;
            this.graph[from][to] = 1;
        }
    }

    public void addEdge(int from, int to, int weight) {
        this.graph[to][from] = weight;
        this.graph[from][to] = weight;
    }

    public void addEdge(int from, int to, int weight, boolean isDirected) {
        if (isDirected) {
            this.graph[to][from] = weight;
        } else {
            this.graph[to][from] = weight;
            this.graph[from][to] = weight;
        }
    }

    public int[] size() {
        int[] dimension =new int[] {this.graph.length, this.graph[0].length};
        return dimension;
    }

    public boolean isWeighted() {
        for (int i = 0; i < this.graph.length; i++) {
            for (int j = 0; j < this.graph[i].length; j++) {
                if (this.graph[i][j] > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    //public boolean isDirected() {}

    public int[][] getAdjacencyMatrix() {
        return this.graph.clone();
    }

    public ArrayList<Integer> getNeighbours(int knoten) {
        ArrayList <Integer> neighbours = new ArrayList<Integer>();
        for (int i = 0; i < this.graph[knoten].length; i++) {
            if (this.graph[knoten][i] > 0) {
                neighbours.add(i);
            }
        }
        return neighbours;
    }

    public void exportHTML() throws IOException {
        File f = new File("io\\Adjazenzmatrix.html");
        FileWriter fw = new FileWriter(f);
        fw.write("""
                <!DOCTYPE html>
                <html>
                <head>
                <title>Graph</title>
                </head>
                <body>
                <h1>Graph</h1>
                <table>
                """);
        for (int i = 0; i < this.graph[0].length; i++) {
            fw.write("<tr>");
            for (int j = 0; j < this.graph.length; j++) {
                fw.write("""
                        <td>"""+this.graph[j][i]+ "</td>" +
                        "</tr>");
            }
        }
        fw.write("""
                </table>
                </body>
                </html>
                """);
        fw.close();
    }

    public void exportGraph() throws IOException {
        File f = new File("io\\Graph.txt");
        BufferedWriter bw = new  BufferedWriter(new FileWriter(f));
        bw.write(size()[0] + " " + size()[1]);
        for (int i = 0; i < this.graph[0].length; i++) {
            bw.newLine();
            for (int j = 0; j < this.graph.length; j++) {
                bw.write(graph[j][i] + " ");
            }
        }
    }
}
