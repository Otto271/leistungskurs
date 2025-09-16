package blatt04;
import java.util.Scanner;
import java.util.Random;
public class Topfschlagen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        double topf_x = rand.nextInt(5) + 1; //Stelle des Topfes wird zufällig generiert
        double topf_y = rand.nextInt(5) + 1;
        double player_x = 3; //Variablen festlegen
        double player_y = 3;
        double dif;
        //System.out.println(topf_y + " " + topf_x);
        double alt_dif = Math.sqrt(Math.pow(player_x - topf_x, 2) + Math.pow(player_y - topf_y, 2));
        while (true) { //endlos schleife
            System.out.println("In welche Richtung wollen Sie gehen? (wasd)");
            String steuerung = scanner.next();
            if (steuerung .equals("w")) { //steuerung der figur
                player_y ++;
            }else if (steuerung .equals("a")) {
                player_x --;
            }else if (steuerung .equals("s")) {
                player_y --;
            }else if (steuerung .equals("d")) {
                player_x ++;
            }else { //fehler abfangen
                System.out.println("Falsche Eingabe bitte nochmal!");
                continue;
            } //abfrage ob spiel zu ende ist
            if (player_x == topf_x && player_y == topf_y) {
                break;
            }
            dif = Math.sqrt(Math.pow(player_x - topf_x, 2) + Math.pow(player_y - topf_y, 2)); //berrechnung der differenz
            if (dif < alt_dif) { //hier wird geschaut ob es näher am ziel oder weiter weg ist
                System.out.println("Wärmer!");
            } else if (dif > alt_dif) {
                System.out.println("Kälter!");
            } else if (dif == alt_dif) {
                System.out.println("Neutral!");
            }
            alt_dif = dif; //der dif wird zum alten dif gemacht
        }
        System.out.println("Sie haben den Topf gefunden!!!");
    }
}
