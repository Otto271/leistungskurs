package blatt08;

public class Zahlensysteme {
    public static boolean istBinär(int a) {
        int[] b = new int[a];
        for (int i = 0; i < a; i++) {
            if (b[i] != 1 || b[i] != 0) {
                return false;
            }
        }
        return true;
    }
    public
}
