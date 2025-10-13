package blatt07;

public class Rechner {
    /**
     * Diese Methode addiert, subtrahiert, multipliziert und dividiert zwei Zahlen
     * @param a erste Zahl
     * @param b zweite Zahl
     */
    public static void operation (int a, int b){
        System.out.println(add(a,b));
        System.out.println(sub(a,b));
        System.out.println(mult(a,b));
        System.out.println(div(a,b));
    }

    /**
     * addiert zwei Zahlen
     * @param a Zahl 1
     * @param b Zahl 2
     * @return Ergebnis
     */
    public static int add(int a, int b){
        return a + b;
    }

    /**
     * subtrahiert zwei Zahlen
     * @param a Zahl 1
     * @param b Zahl 2
     * @return Ergebnis
     */
    public static int sub(int a, int b){
        return a - b;
    }

    /**
     * multipliziert zwei Zahlen
     * @param a Zahl 1
     * @param b Zahl 2
     * @return Ergebnis
     */
    public static int mult(int a, int b){
        return a * b;
    }

    /**
     * dividiert zwei Zahlen
     * @param a Zahl 1
     * @param b Zahl 2
     * @return Ergebnis
     */
    public static int div(int a, int b){
        return a / b;
    }
    public static void main(String[] args) {
        operation(2,3);
    }
}
