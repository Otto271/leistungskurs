package blatt05;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else  {
                b = b - a;
            }
        }
    }
}
