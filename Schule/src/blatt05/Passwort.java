package blatt05;
import java.util.Scanner;
public class Passwort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean gross = false;
        boolean klein = false;
        boolean zahlen = false;
        boolean sonder = false;
        boolean sehr_sicher = false;
        while (true) {
            System.out.println("Gebe dein Passwort ein:");
            String passwort = input.nextLine();
            for (int i = 0; i < passwort.length(); i++) {
                char c = passwort.charAt(i);

                if (Character.isUpperCase(c)) {
                    gross = true;
                } else if (Character.isLowerCase(c)) {
                    klein = true;
                } else if (Character.isDigit(c)) {
                    zahlen = true;
                } else {
                    sonder = true;
                }

                if (gross && klein && zahlen && sonder) {
                    break;
                }
            }
            if (passwort.length() > 8) {
                if (gross && klein && zahlen && sonder) {
                    if (passwort.length() > 14) {
                        sehr_sicher = true;
                    }
                    break;
                }
            }
            System.out.println("Dein Passwort brauch alles aus der Bedingung!");
        }
        if (sehr_sicher) {
            System.out.println("Das Passwort ist sehr sicher!");
        } else {
            System.out.println("Das Passwort ist sicher!");
        }
    }
}
