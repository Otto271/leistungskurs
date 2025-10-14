package blatt08;

public class Zahlensysteme {
    /**
     * Diese Funktion prüft ob die angegebene Zahl in Dezimal schreibweise geschrieben wurde
     * @param s Zahl
     * @return
     */
    public static boolean istDezimal(String s){
        for (int i = 0; i < s.length(); i++){
            if (!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public static boolean istBinär(String s) {
        if (s.startsWith("(") && s.endsWith(")2")) {
            String binär_zahl = s.substring(1, s.length() - 2);
            for (int i = 0; i < binär_zahl.length(); i++) {
                if (binär_zahl.charAt(i) != '0' && binär_zahl.charAt(i) != '1') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public static boolean istHexadezimal(String s){
        if (s.startsWith("(") && s.endsWith(")16")) {
            String hex_zahl = s.substring(1, s.length() - 3);
            for (int i = 0; i < hex_zahl.length(); i++) {
                char c = hex_zahl.charAt(i);
                if (!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f'))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public static int zuDezimal(String s) {
        int dezimal = 0;
        int binär = 1;
        if (istDezimal(s)){
            dezimal = Integer.parseInt(s);
            return dezimal;
        } else if (istBinär(s)) {
            String zahl = s.substring(1, s.length() - 2);
            dezimal = Integer.parseInt(zahl, 2);
            return dezimal;
        }else if (istHexadezimal(s)){
            String zahl = s.substring(1, s.length() - 3);
            dezimal = Integer.parseInt(zahl, 16);
            return dezimal;
        }
        System.out.println("i");
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(zuDezimal("(1010101111000001001000111010)2"));
    }
}
