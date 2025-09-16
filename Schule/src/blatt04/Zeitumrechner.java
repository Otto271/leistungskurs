package blatt04;
import java.util.Scanner;
public class Zeitumrechner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Gebe eine positive Zahl an Sekunden ein:");
        int zahl = input.nextInt();
        int tag = 0;
        int stunde = 0;
        int minute = 0;
        int sekunde = 0;
        while (zahl != 0) {
            if (zahl > 86400) {
                tag ++;
                zahl -= 86400;
            } else if (zahl > 3600) {
                stunde ++;
                zahl -= 3600;
            } else if (zahl > 60) {
                minute ++;
                zahl -= 60;
            } else if (zahl < 60) {
                sekunde = zahl;
                zahl = 0;
            }
        }
        System.out.println(tag + " Tage, " + stunde + " Stunde, " + minute + " Minute " + sekunde + " Sekunden");
    }
}
