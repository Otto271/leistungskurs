package blatt07;

public class Rechner {
    public static void operation (int a, int b){
        System.out.println(add(a,b));
        System.out.println(sub(a,b));
        System.out.println(mult(a,b));
        System.out.println(div(a,b));
    }
    public static int add(int a, int b){
        return a + b;
    }
    public static int sub(int a, int b){
        return a - b;
    }
    public static int mult(int a, int b){
        return a * b;
    }
    public static int div(int a, int b){
        return a / b;
    }
    public static void main(String[] args) {
        operation(2,3);
    }
}
