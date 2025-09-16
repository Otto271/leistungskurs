package blatt04;
import  java.util.Scanner;
public class Reihen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Wie viele Zahlen wollen Sie in dieser Reihe augegeben bekommen."); //abfrage wie viele zahlen für zeile 1 ausgegeben werden sollen
        int zahlen_menge = input.nextInt(); //variabeln
        int zahlenreihe_1 = 1;
        int zahlenreihe_2 = 2;
        int zahlenreihe_3 = 1;
        int zahlenreihe_4 = 1;
        int zahlen_menge_2 = 1;
        int zahlen_menge_3 = 1;
        if (zahlen_menge <= 0) {
            System.out.println("Bitte geben Sie eine höhere Zahl als 0 ein!");
            System.exit(0);
        }
        System.out.println("Reihe 1:");
        while (zahlen_menge > 0) { //Schleife und berechnung der folge
            System.out.print(zahlenreihe_1 + " ");
            zahlenreihe_1 ++;
            zahlen_menge --;
        }
        System.out.println();
        System.out.println();
        System.out.println("Wie viele Zahlen wollen Sie in dieser Reihe augegeben bekommen.");//abfrage wie viele zahlen für zeile 2 ausgegeben werden sollen
        zahlen_menge = input.nextInt();
        if (zahlen_menge <= 0) {
            System.out.println("Bitte geben Sie eine höhere Zahl als 0 ein!");
            System.exit(0);
        }
        System.out.println("Reihe 2:");
        while (zahlen_menge > 0) { //Schleife und berechnung der folge
            System.out.print(zahlenreihe_2 + " ");
            zahlenreihe_2 += 2;
            zahlen_menge --;
        }
        System.out.println();
        System.out.println();
        System.out.println("Wie viele Zahlen wollen Sie in dieser Reihe augegeben bekommen.");//abfrage wie viele zahlen für zeile 3 ausgegeben werden sollen
        zahlen_menge = input.nextInt();
        if (zahlen_menge <= 0) {
            System.out.println("Bitte geben Sie eine höhere Zahl als 0 ein!");
            System.exit(0);
        }
        System.out.println("Reihe 3:");
        while (zahlen_menge >= zahlen_menge_2) { //Schleife und berechnung der folge
            System.out.print(zahlenreihe_3 + " ");
            zahlen_menge_2 ++;
            zahlenreihe_3 = zahlen_menge_2 * zahlen_menge_2;
        }
        System.out.println();
        System.out.println();
        System.out.println("Wie viele Zahlen wollen Sie in dieser Reihe augegeben bekommen.");//abfrage wie viele zahlen für zeile 4 ausgegeben werden sollen
        zahlen_menge = input.nextInt();
        if (zahlen_menge <= 0) {
            System.out.println("Bitte geben Sie eine höhere Zahl als 0 ein!");
            System.exit(0);
        }
        System.out.println("Reihe 4:");
        while (zahlen_menge >= zahlen_menge_3) { //Schleife und berechnung der folge
            System.out.print(zahlenreihe_4 + " ");
            zahlen_menge_3 ++;
            zahlenreihe_4 = (int) (Math.pow(-1, zahlen_menge_3 + 1) * Math.ceil(zahlen_menge_3 / 2.0)); //Math.pow sorgt für die abwechselnden vorzeichen, Math.ceil berechnet die zahl die wiederholt wird
        }
    }
}
