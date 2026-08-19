package blatt33.aufgabe05;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
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

    public void zyklensuche(int[][] matrix, int x) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            visited[i] = false;
        }
        stack.push(x);
        visited[x] = true;
        boolean flag = false;
        while(!stack.isEmpty()) {
            int y = stack.pop();
            for(int i = 0; i < matrix.length; i++) {
                if(!visited[i] && matrix[y][i] > 0) {
                    stack.push(i);
                    visited[i] = true;
                } else if(visited[i] && matrix[y][i] > 0) {
                    flag = true;
                }
            }
        }
        if(flag) {
            System.out.println("Zyklus gefunden!");
        }
    }

    public void erreichbarkeit(int[][] matrix, int x) {
        Queue <Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            visited[i] = false;
        }
        queue.add(x);
        visited[x] = true;
        while(!queue.isEmpty()) {
            int y = queue.poll();
            for(int i = 0; i < matrix.length; i++) {
                if(!visited[i] && matrix[y][i] > 0) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            if(!visited[i]) {
                System.out.println(i + " ist nicht erreichbar!");
            }
        }
    }
}
