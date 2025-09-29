package blatt06;
import java.util.Scanner;
public class Fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Wie viele Zahlen sollen ausgegeben werden?");
        int n = input.nextInt();
        int[] fibonacci = new int[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        System.out.println(fibonacci[0] + "\n" + fibonacci[1]);
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            System.out.println(fibonacci[i]);
        }
        double q1 = fibonacci[n - 1];
        double q2 = fibonacci[n - 2];
        double quo = q1 / q2; //Umso höher n umso näher geht der Quotient an 1,618
        System.out.println("Quotient: " + quo);
    }
}
