package blatt05;
import java.util.Scanner;
public class Bowling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int frames = 10;
        int wuerfe = 2;
        int pins;
        int multi;
        int score;
        int multi_runde;
        int pins_runde;
        while (frames > 0) {
            while(wuerfe > 0){
                System.out.println("Wieviele Pins haben sie getroffen?");
                pins = input.nextInt();
                if (pins == 10 && wuerfe == 2) {

                }
            }
        }
    }
}
