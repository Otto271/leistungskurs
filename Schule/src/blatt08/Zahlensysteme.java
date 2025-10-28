package blatt08;

public class Zahlensysteme {
    /**
     * Diese Funktion prüft ob die angegebene Zahl in Dezimal schreibweise geschrieben wurde
     * @param s Zahl
     * @return true wenn es eine Dezimalzahl ist, false wenn nicht
     */
    public static boolean istDezimal(String s){
        for (int i = 0; i < s.length(); i++){
            if (!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
    /**
     * Diese Funktion prüft ob die angegebene Zahl in Binär schreibweise geschrieben wurde
     * @param s Zahl
     * @return true wenn es eine Binärzahl ist, false wenn nicht
     */
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
    /**
     * Diese Funktion prüft ob die angegebene Zahl in Hexadezimal schreibweise geschrieben wurde
     * @param s Zahl
     * @return true wenn es eine Hexadezimalzahl ist, false wenn nicht
     */
    public static boolean istHexadezimal(String s){
        if (s.startsWith("(") && s.endsWith(")16")) {
            String hex_zahl = s.substring(1, s.length() - 2);
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

    /**
     * Überprüft in welcher Schreibweise die Zahl ist und wandelt sie dann in Dezimalschreibweise
     * @param s Zahl
     * @return Die Zahl umgewandelt als integer
     */
    public static int zuDezimal(String s){
        if (istBinär(s)){
            String zahl = s.substring(1, s.length() - 2);
            return Integer.parseInt(zahl, 2);
        } else if (istHexadezimal(s)) {
            String zahl = s.substring(1, s.length() - 3);
            return Integer.parseInt(zahl, 16);
        }else if (istDezimal(s)){
            return Integer.parseInt(s);
        }
        return 0;
    }
}
