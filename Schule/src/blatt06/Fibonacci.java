package blatt06;
import java.util.Scanner;
public class Fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Wie Lang soll n sein!");
        int n = input.nextInt();
        int[] fibonacci = new int[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        System.out.print(fibonacci[0] + " " + fibonacci[1] + " ");
        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            System.out.print(fibonacci[i] + " ");
        }
        int quo = fibonacci[n--] / fibonacci[n - 2];
        System.out.println("Quotient: " + quo);
    }
}
