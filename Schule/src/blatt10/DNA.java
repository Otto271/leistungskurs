package blatt10;

import java.sql.SQLOutput;

public class DNA {
    public static boolean istDNA(String dna) {
        boolean result = false;
        if (dna.length() % 2 != 0) {
            return false;
        } else  {
            char[] arr = dna.toCharArray();
            for (int i = 0; i < dna.length(); i += 2) {
                if (arr[i] == 'A' && arr[i + 1] == 'T') {
                    result = true;
                } else if (arr[i] == 'T' && arr[i + 1] == 'A') {
                    result = true;
                } else if (arr[i] == 'G' && arr[i + 1] == 'C') {
                    result = true;
                } else if (arr[i] == 'C' && arr[i + 1] == 'G') {
                    result = true;
                } else {
                    return false;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(istDNA("ATGCGCG"));
    }
}
