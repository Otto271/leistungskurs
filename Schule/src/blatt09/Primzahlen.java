package blatt09;

import java.util.Arrays;

public class Primzahlen {
    /**
     * überprüft ob eine Zahl eine Primzhal ist
     * @param a Zahl
     * @return true wenn prim ist, false wenn nicht
     */
    public static boolean istPrim(int a) {
        if (a == 1) {
            return false;
        }
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Diese Methode gibt alle Primzahl bis zu a aus
     * @param a Höchstzahl
     */
    public static void printPrim(int a) {
        for (int i = 1; i < a; i++) {
            if (istPrim(i)) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * Gibt einen Array mit Primzahlen zurück
     * @param n länge des Arrays
     * @return Array
     */
    public static int[] generierePrimzahlen(int n) {
        int j = 0;
        int i = 1;
        int[] arr = new int[n];
        while (true){
            if (istPrim(i)) {
                arr[j] = i;
                j++;
            } else if (j == n) {
                break;
            }
            i++;
        }
        return arr;
    }

    /**
     * Gibt die Primfaktorzerlegung einer gegebenen zahl aus
     * @param n Zahl
     */
    public static void primfaktorzerlegung(int n) {
        System.out.print(n + " = ");
        while (!istPrim(n)) {
            int[] arr = Teiler.teiler(n);
            for (int i = 0; i < arr.length; i++) {
                if (istPrim(arr[i])) {
                    System.out.print(arr[i] + " * ");
                    n = n / arr[i];
                    break;
                }
            }
        }
        System.out.print(n + " ");
    }
    public static void main(String[] args) {
        int[] test = generierePrimzahlen(10);
        System.out.println(Arrays.toString(test));
    }
}