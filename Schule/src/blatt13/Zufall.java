package blatt13;

public class Zufall {

    public static double zufall(int b) {
        return Math.random() * b;
    }
    public static int zufallGanz(int b) {
        double random = Math.random() * b;
        return (int) random;
    }
    public static double zufall(int a, int b) {
        return Math.random() * (b - a) + a;
    }
    public static int zufallGanz(int a, int b) {
        double random = Math.random() * (b - a) + a;
        return (int) random;
    }
    public static int[] zufallArray(int a, int b, int i) {
        int[] zufall = new int[i];
        for(int j = 0; j < i; j++){
            zufall[j] = zufallGanz(a, b);
        }
        return zufall;
    }
    public static void main(String[] args) {
        blatt07.ArbeitMitArrays.printArray(zufallArray(5,10,10));
    }
}
