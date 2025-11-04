package blatt09;

public class Teiler {
    public static boolean istTeiler(int a, int b) {
        if (a % b == 0){
            return true;
        }
        return false;
    }
    public static void alleTeiler(int a){
        for(int i = a; i > 0; i--){
            if (istTeiler(a, i)){
                System.out.println(i);
            }
        }
    }
    public static int anzahlTeiler(int a){
        int anzahl = 0;
        for(int i = a; i > 0; i--){
            if (istTeiler(a, i)){
                anzahl++;
            }
        }
        return anzahl;
    }
    public static int[] teiler(int a){
        int[] arr = new int[anzahlTeiler(a)];
        int j = 0;
        for(int i = a; i > 0; i--){
            if (istTeiler(a, i)){
                arr[j] = i;
                j++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        System.out.println(anzahlTeiler(10));
    }
}
