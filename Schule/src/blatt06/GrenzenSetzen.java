package blatt06;
import java.util.Arrays;
import java.util.Scanner;
public class GrenzenSetzen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Gebe erst deine Ober- und dann deine Untergrenze ein:");
        int o = input.nextInt();
        int u = input.nextInt();
        int laenge = o - u + 1;
        int[] grenzen = new int[laenge];
        for (int i = 0; i < laenge; i++) {
            grenzen[i] = u + i;
        }
        System.out.println(Arrays.toString(grenzen));
    }
}
