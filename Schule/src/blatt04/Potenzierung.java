package blatt04;
import java.util.Scanner;
public class Potenzierung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double gesamt = 1; //Variablen
        double gesamt_minus = 1;
        System.out.println("Geben Sie ihre Basis an!"); //Abfrage nach der Basis
        double basis = input.nextDouble();
        System.out.println("Geben Sie ihren Exponenten ein! (Bitte nur ganzzahlige Exponenten)"); //Abfrage nach der Potenz
        int exponent = input.nextInt();
        if (exponent == 0) { //Wenn Exponent = 0 dann ist ergebnis immer 1
            System.out.println("Das Ergebnis ist: 1");
            System.exit(0);
        }
        while (exponent >= 1) { //Rechnung mit positivem Exponenten
            gesamt = gesamt * basis;
            exponent --;
        }
        while (exponent <= -1) { //Rechnung mit negativem Exponenten
            gesamt_minus = (gesamt_minus * basis);
            exponent ++;
        }
        if (gesamt_minus == 1) { //Hier wird geschaut ob die lösung für das negative oder für das positive benutzt wird
            System.out.println("Das Ergebnis ist: " + gesamt);
        } else {
            gesamt_minus = 1 / gesamt_minus;
            System.out.println("Das Ergebnis ist: " + gesamt_minus);
        }
    }
}
