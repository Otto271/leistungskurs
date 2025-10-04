package blatt07;

public class Stein {
    public static double steinGGT(int a, int b){
        int k = 0;
        double ggt = 0;
        while (a != 0 || b != 0) {
            if (a % 2 == 0 && b % 2 == 0) {
                a /= 2;
                b /= 2;
                k++;
            } else if (a % 2 == 0) {
                a /= 2;
                k++;
            } else if (b % 2 == 0) {
                b /= 2;
                k++;
            } else if (a >= b){
                a = a - b / 2;
                k++;
            } else {
                b = b - a / 2;
                k++;
            }
        }
        if (a == 0){
            ggt = b * Math.pow(2, k);
        } else {
            ggt = a * Math.pow(2, k);
        }
        return ggt;
    }
}
