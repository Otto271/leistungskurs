package blatt04;
import java.util.Scanner;
import java.util.Random;
public class Topfschlagen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int topf_x = rand.nextInt(5) + 1;
        int topf_y = rand.nextInt(5) + 1;
        int player_x = 3;
        int player_y = 3;
        int dif;
        while (true) {
            System.out.println("In welche Richtung wollen Sie gehen? (wasd)");
            String steuerung = scanner.next();
            if (steuerung .equals("w")) {
                player_y ++;
            }else if (steuerung .equals("a")) {
                player_x --;
            }else if (steuerung .equals("s")) {
                player_y --;
            }else if (steuerung .equals("d")) {
                player_x ++;
            }else {
                System.out.println("Falsche Eingabe bitte nochmal!");
                continue;
            }
            if (player_x == topf_x && player_y == topf_y) {
                break;
            }
            //dif = player_x + player_y - topf_x + topf_y;
            //if (dif )
        }
        System.out.println("Sie haben den Topf gefunden!!!");
    }
}
