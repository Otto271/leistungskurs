package blatt33.aufgabe05;

import java.util.Stack;

public class GraphSuche {
    public boolean isPath(int[][] matrix, String path) {
        int ct = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(ct == path.length()) {
                    return true;
                }
                if(j == path.charAt(ct) && i == path.charAt(ct+1)) {
                    ct++;
                }
            }
        }
        return false;
    }

    public int pathLength(int[][] matrix, String path) {
        int ct = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(ct == path.length()) {
                    return ct;
                }
                if(j == path.charAt(ct) && i == path.charAt(ct+1)) {
                    ct++;
                }
            }
        }
        return 0;
    }

    public void zyklensuche(int[][] matrix) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            visited[i] = false;
        }
        stack.push(0);
        visited[0] = true;
        boolean flag = false;
        while(!stack.isEmpty()) {
            int x = stack.pop();
            for(int i = 0; i < matrix.length; i++) {
                if(!visited[i] && matrix[x][i] > 0) {
                    stack.push(i);
                    visited[i] = true;
                } else if(visited[i] && matrix[x][i] > 0) {
                    flag = true;
                }
            }
        }
        if(flag) {
            System.out.println("Zyklus gefunden!");
        }
    }
}
