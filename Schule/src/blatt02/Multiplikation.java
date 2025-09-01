package blatt02;
import java.util.Scanner;
public class Multiplikation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nenne die erste (ganze) Zahl.");
        int zahl_1 = input.nextInt();
        System.out.println("Nenne die zweite (ganze) Zahl.");
        int zahl_2 = input.nextInt();
        int gesamt = zahl_1 * zahl_2;
        System.out.println(zahl_1 + " * " + zahl_2 + " = " + gesamt);
    }
}
