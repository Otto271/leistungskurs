package blatt08;

public class SuchenUndErsetzen {
    /**
     * Diese Funktion ersetzt einzelnde Zeichen in einem String
     * @param s String
     * @param c Zeichen das gesucht wird
     * @param d Zeichen womit c ersetzt wird
     * @return Gibt den String mit dem veränderten Zeichen zurück
     */
    public static String ersetzen(String s, char c, char d) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == c) {
                arr[i] = d;
            }
        }
        return new String(arr);
    }
    public static void main(String[] args) {
        String s = "Hallo";
        char c = 'o';
        char d = 'a';
        String ersetzen = ersetzen(s, c, d);
        System.out.println(ersetzen);
    }
}
