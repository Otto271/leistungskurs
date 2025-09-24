package blatt06;
import java.util.Scanner;
public class Wertetabelle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Wie groß soll der Grad sein.");
        int grad = input.nextInt();
        double[] koeff = new double[grad++];

        for (int i = grad++; i != 0; i--){
            koeff[i] = input.nextDouble();
        }
    }
}
