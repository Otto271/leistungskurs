package blatt03;
import  java.util.Scanner;
public class MinMax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nenne drei ganze Zahlen!"); //drei Zahlen werden abgefragt
        int zahl_1 = input.nextInt();
        int zahl_2 = input.nextInt();
        int zahl_3 = input.nextInt();

        if (zahl_1 < zahl_3 && zahl_2 < zahl_3) { //in diesem Teil wird geschaut was die größte Zahl ist
            System.out.println("Die dritte Zahl ist die größte Zahl!");
        } else if (zahl_1 > zahl_3 && zahl_1 > zahl_2) {
            System.out.println("Die erste Zahl ist die größte Zahl!");
        } else if (zahl_2 > zahl_1 && zahl_2 > zahl_3) {
            System.out.println("Die zweite Zahl ist die größte Zahl!");
        }

        if (zahl_1 > zahl_3 && zahl_2 > zahl_3) { //in diesem Teil wird geschaut was die kleinste Zahl ist
            System.out.println("Die dritte Zahl ist die kleinste Zahl!");
        } else if (zahl_1 < zahl_3 && zahl_1 < zahl_2) {
            System.out.println("Die erste Zahl ist die kleinste Zahl!");
        } else if (zahl_2 < zahl_1 && zahl_2 < zahl_3) {
            System.out.println("Die zweite Zahl ist die kleinste Zahl!");
        }
    }
}
