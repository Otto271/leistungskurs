package blatt32.aufgabe03;

public class Graph {
    int [][] graph;

    public Graph() {
        this.graph = new int[0][0];
    }

    public Graph(int mengeKnoten) {
        this.graph = new  int[mengeKnoten][mengeKnoten+1];
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
}
