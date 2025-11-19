package blatt13;

public class QuadratApproximation {
    public static double flaecheQuadrat(double a) {
        return a * a;
    }
    public static double sucheSeitemlaenge(double a) {
        double x = 0;
        double temp = 0;
        while(temp < 0.00001){
            if (x < a) {
                x += 0.00001;
            } else {
                x -= 0.00001;
            }
            temp = flaecheQuadrat(x) - a;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(sucheSeitemlaenge(9));
    }
}
