package blatt13;

public class Umgebung {
    public static int findeExponent(double b, double e) {
        double temp = b;
        int x = 1;
        while(b>e){
            b *= temp;
            x++;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(findeExponent(0.5, 0.001));
    }
}
