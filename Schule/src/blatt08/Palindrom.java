package blatt08;

public class Palindrom {
    /**
     * Diese Funktion gibt den gegebene String umgedreht zurück
     * @param s String
     * @return Umgedrehter String
     */
    public static String umdrehen(String s){
        char[] arr = s.toCharArray();
        int len = arr.length;
        char[] palindrom = new char[len];
        for(int i = 0; i < arr.length; i++){
            palindrom[i] = arr[len - 1];
            len--;
        }
        String palindromStr = new String(palindrom);
        return palindromStr;
    }

    /**
     * Diese Funktion überprüft ob ein String ein Palindrom ist
     * @param s String
     * @return true/false (ist ein Palindrom/ist kein Palindrom)
     */
    public static boolean istPalindrom(String s){
        String palindromStr = umdrehen(s);
        if (s.equals(palindromStr)){
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        String palindrom = "otto";
        String palindromStr = umdrehen(palindrom);
        System.out.println(palindromStr);
        Boolean bool = istPalindrom(palindrom);
        System.out.println(bool);
    }
}
