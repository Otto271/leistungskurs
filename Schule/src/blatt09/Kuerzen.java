package blatt09;

public class Kuerzen {
    public static boolean istKuerzbar(int a, int b) {
        if (a > b) {
            for (int i = 2; i <= a; i++) {
                if (a % i == 0 && b % i == 0) {
                    return true;
                }
            }
        } else if (a < b) {
            for  (int i = 2; i <= b; i++) {
                if (a % i == 0 && b % i == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void kuerzen(int a, int b) {
        while (true) {
            if (istKuerzbar(a, b)) {
                if (a > b) {
                    for (int i = 2; i <= a; i++) {
                        a /= i;
                        b /= i;
                    }
                } else if (a < b) {
                    for (int i = 2; i <= b; i++) {
                        a /= i;
                        b /= i;
                    }
                }
            } else {
                break;
            }
        }
        System.out.println(a + "/" + b);
    }
    public static void main(String[] args) {
        kuerzen(2, 4);
    }
}
