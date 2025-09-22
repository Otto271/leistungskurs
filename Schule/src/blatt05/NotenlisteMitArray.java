package blatt05;
import java.util.Scanner;
public class NotenlisteMitArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] noten = new int[10];
        for (int i = 0; i < noten.length; i++) {
            System.out.println("Gebe eine Note ein: ");
            noten[i] = input.nextInt();
        }
        for (int i = 0; i <= noten.length - 1; i++) {
            System.out.println("Note von Index " + i + ": " + noten[i]);
        }
    }
}