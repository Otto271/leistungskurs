package blatt14;

public class MultiArrays {
    public static void print2DArray(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < arr[i].length - 1; j++) {
                System.out.print(arr[i][j] + " | ");
            }
            System.out.print(arr[i][arr[i].length - 1]);
            System.out.println(" ]");
        }
    }
    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " | ");
            }
            System.out.println(" ]");
        }
    }
    public static void print2DArray(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " | ");
            }
            System.out.println(" ]");
        }
    }
    public static int[][] createRandom2DIntArray(int a, int b, int p, int q) {
        int[][] arr = new int[a][b];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = blatt13.Zufall.zufallGanz(p, q);
            }
        }
        return arr;
    }
    public static double[][] createRandom2DDoubleArray(int a, int b) {
        double[][] arr = new double[a][b];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Math.random();
            }
        }
        return arr;
    }
    public static int[][] createCountingArray(int a, int b) {
        int[][] arr = new int[a][b];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = count;
                count++;
            }
        }
        return arr;
    }
    public static char[][] createEmpty2DCharArray(int a, int b) {
        char[][] arr = new char[a][b];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ' ';
            }
        }
        return arr;
    }
    public static boolean istIdentisch(char[][] arr, char[][] arr2) {
        if (arr.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != arr2[i].length) {
                return false;
            }
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != arr2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static char[][] copy2DCharArray(char[][] arr) {
        char[][] arr2 = new char[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = new char[arr[i].length];
            for (int j = 0; j < arr[i].length; j++) {
                arr2[i][j] = arr[i][j];
            }
        }
        return arr2;
    }
    public static int[][] shiftRows(int[][] arr, int n, int m) {
        for (int j = 0; j < m; j++) {
            int temp = arr[n][0];
            for (int i = 0; i < arr[n].length; i++) {
                arr[n][i] = arr[n][i++];
            }
            arr[n][arr[n].length-1] = temp;
        }
        return arr;
    }
    public static void main(String[] args) {
        print2DArray(shiftRows(new int[][] {{0,1,2,3,4}, {5,6,7,8,9}, {10,11,12,13,14}, {15,16,17,18,19}}, 2, 2));
    }
}
