package blatt09;

import java.util.Arrays;

public class Teiler {
    /**
     * Schaut ob eine Zahl der Teiler einer anderen Zahl ist
     * @param a Erste Zahl
     * @param b Teiler
     * @return true wenn teiler, false wenn nicht
     */
    public static boolean istTeiler(int a, int b) {
        if (a % b == 0){
            return true;
        }
        return false;
    }

    /**
     * gibt alle Teiler einer zahl aus
     * @param a Zahl
     */
    public static void alleTeiler(int a){
        for(int i = a; i > 0; i--){
            if (istTeiler(a, i)){
                System.out.println(i);
            }
        }
    }

    /**
     * Gibt die Anzahl an teilern einer Zahl zurück
     * @param a Zahl
     * @return Teileranzahl
     */
    public static int anzahlTeiler(int a){
        int anzahl = 0;
        for(int i = a; i > 0; i--){
            if (istTeiler(a, i)){
                anzahl++;
            }
        }
        return anzahl;
    }

    /**
     * Erstellt eine Liste an Teilern von einer Zahl
     * @param a Zahl
     * @return Liste der Teiler
     */
    public static int[] teiler(int a){
        int[] arr = new int[anzahlTeiler(a)];
        int j = 0;
        for(int i = a; i > 0; i--){
            if (istTeiler(a, i)){
                arr[j] = i;
                j++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = teiler(20);
        System.out.println(Arrays.toString(arr));
    }
}
