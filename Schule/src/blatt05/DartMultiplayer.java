package blatt05;
import java.util.Scanner;
public class DartMultiplayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib die Anzahl der Spieler an.");
        int a = scanner.nextInt();
        int[] anzahl_spieler = new int[a];
        for (int i = 0; i < anzahl_spieler.length; i++) {
            anzahl_spieler[i] = 501;
        }

        outer: //Das lässt uns beide Schleifen mit einem break outer; Befehl stoppen
        while (true) {
            for (int i = 0; i < anzahl_spieler.length; i++) {
                int counter_temp = anzahl_spieler[i];
                int anzahl_wuerfe = 0;
                while (anzahl_wuerfe < 3) {
                    System.out.println("Player: " + i + "! Gebe deine Punktzahl ein (0-60)");
                    int wurf = scanner.nextInt();
                    counter_temp = counter_temp - wurf;
                    if (counter_temp == 0) {
                        System.out.println("0 Punkte! Du hast gewonnen.");
                        break outer;
                    } else if (counter_temp < 0) {
                        System.out.println("Überworfen! Du hast noch " + anzahl_spieler[i] + " Punkte Rest.");
                        break;
                    }
                    if (anzahl_wuerfe == 2) {
                        anzahl_spieler[i] = counter_temp;
                    }
                    System.out.println("Die aktuelle Punktzahl ist: " + counter_temp);
                    anzahl_wuerfe++;
                }
                System.out.println("Runde beendet.");
                i = 0;
            }
        }
    }
}
