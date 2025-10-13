package blatt08;

public class Klammernsprache {
    /**
     * Diese Funktion erkennt ob ein Wort Klammersprache ist oder nicht
     * @param s String
     * @return true/false (Klammersprache/keine Klammersprache)
     */
    public static boolean istKlammerwort(String s) {
        char[] charArray = s.toCharArray();
        int a = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (a < 0) {
                return false;
            }
            if (charArray[i] == '(') {
                a++;
            } else if (charArray[i] == ')') {
                a--;
            } else {
                return false;
            }
        }
        return a == 0;
    }
    public static void main(String[] args) {
        boolean b = istKlammerwort("()()()()");
        System.out.println(b);
    }
}
