package blatt01;

public class Zuweisungen {
    public static void main(String[] args) {
        int a = 10;
        int b = a;
        a += 3;
        a *= 4;
        a -= 8;
        a /= 2;
        b *= 2;
        a -= b;
        System.out.println(a);
    }
}
