package blatt18;

public class Summe {
    public static int summe(int n) {
        if (n < 0) {
            return -1;
        }else if (n == 0) {
            return 0;
        } else if (n==1) {
            return 1;
        } else  {
            return n + summe(n-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(summe(5));
    }
}
