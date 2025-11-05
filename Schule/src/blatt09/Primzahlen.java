package blatt09;

import java.util.Arrays;

public class Primzahlen {
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

    public static void printPrim(int a) {
        for (int i = 1; i < a; i++) {
            if (istPrim(i)) {
                System.out.print(i + " ");
            }
        }
    }

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

    public static void primfaktorzerlegung(int n) {
        int[] arr_2 = new int[n];
        int i = 0;
        while (true) {
            if (n %  arr[i] == 0) {
                arr_2[i] = arr[i];
            }
            i++;
        }
    }
    public static void main(String[] args) {
        int[] arr = generierePrimzahlen(10);
        System.out.println(Arrays.toString(arr));
    }
}