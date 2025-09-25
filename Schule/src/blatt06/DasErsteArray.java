package blatt06;

public class DasErsteArray {
    public static void main(String[] args) {
        int[] a = new int[990];
        for (int i = 0; i < a.length; i++) {
            a[i] = 10 + i;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        for (int i = 989; i >= 0; i--) {
            System.out.println(a[i]);
        }
    }
}
