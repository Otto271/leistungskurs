package blatt03;
import java.util.Scanner;
public class Notenrechner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Was war die Maximale Punktzahl!"); //Max. Punkzahl wird abgefragt
        double maximal_punktzahl = input.nextDouble();
        System.out.println("Was war die erreichte Punktzahl!"); //Erreichte Punktzahl wird abgefragt
        double erreichte_punktzahl = input.nextDouble();
        double prozent = erreichte_punktzahl / maximal_punktzahl * 100; //Prozentzahl wird ausgerrechnet

        if (prozent == 100) { //wenn 100% erreicht wurde
            System.out.println("Glückwunsch Sie haben 100% erreicht!");
            System.exit(0);
        }
        if (prozent >= 85) { //wenn 85% oder mehr erreicht wurden
            System.out.println("Sie haben eine 1!");
            System.out.printf("Erreichte Prozentzahl: %.2f", prozent);
            System.out.println("%");
            System.exit(0);
        }
        if (prozent >= 70) { //wenn 70% oder mehr erreicht wurden
            System.out.println("Sie haben eine 2!");
            System.out.printf("Erreichte Prozentzahl: %.2f", prozent);
            System.out.println("%");
            System.exit(0);
        }
        if (prozent >= 55) { //wenn 55% oder mehr erreicht wurden
            System.out.println("Sie haben eine 3!");
            System.out.printf("Erreichte Prozentzahl: %.2f", prozent);
            System.out.println("%");
            System.exit(0);
        }
        if (prozent >= 39) { //wenn 39% oder mehr erreicht wurden
            System.out.println("Sie haben eine 4!");
            System.out.printf("Erreichte Prozentzahl: %.2f", prozent);
            System.out.println("%");
            System.exit(0);
        }
        if (prozent >= 17) { //wenn 17% oder mehr erreicht wurden
            System.out.println("Sie haben eine 5!");
            System.out.printf("Erreichte Prozentzahl: %.2f" , prozent);
            System.out.println("%");
        } else { //wenn weniger 17% erreicht wurden
            System.out.println("Sie haben eine 6!");
            System.out.printf("Erreichte Prozentzahl: %.2f", prozent);
            System.out.println("%");
        }
    }
}
