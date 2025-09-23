package blatt05;

import java.util.Scanner;

public class Handwerkbetrieb {
    public static void main(String args[]) {
        int summe = 0;
        int anzahl = 0;
        int[] auftrag = new int[]{9000, 23000, 41000, 6000, 13000, 22000, 38000, 16000, 7000, 14000, 12000, 5000, 17000};
        int speicher = auftrag[1];
        auftrag[1] = auftrag[2];
        auftrag[2] = speicher;
        //System.out.println(auftrag[1] + " " + auftrag[2]);
        for (int i = 0; i < auftrag.length; i++) {
            speicher = auftrag[i];
            auftrag[i] = auftrag[i++];
            auftrag[i--] = speicher;
        }
        for (int i = 0; i < auftrag.length; i++) {
            System.out.println(auftrag[i]);
        }
        for (int i = 0; i < auftrag.length; i++) {
            summe += auftrag[i];
        }
        System.out.println("Summe: " + summe);

        for (int i = 0; i < auftrag.length; i++) {
            if (auftrag[i] > 15000) {
                anzahl++;
            }
        }
        System.out.println("Anzahl: " + anzahl);
    }
}
