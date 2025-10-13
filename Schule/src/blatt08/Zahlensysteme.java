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
        if (s.startsWith("(") && s.endsWith(")₂")) {
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
        if (s.startsWith("(") && s.endsWith(")₁₆")) {
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
    public static int zuDezimal(String s){
        if (istDezimal(s)){
            String zahl = s.substring(1, s.length() - 2);
            return Integer.parseInt(s);
        } else if (istBinär(s)) {
            String zahl = s.substring(1, s.length() - 2);
            return Integer.parseInt(s);
        }else if (istHexadezimal(s)){
            String zahl = s.substring(1, s.length() - 2);
            return Integer.parseInt(s);
        }
        return 0;
    }
}
