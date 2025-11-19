package blatt10;

import java.sql.SQLOutput;

public class DNA {
    public static boolean istDNA(String arr) {
        if (arr.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < arr.length() - 1; i = i + 2) {
            if (arr.charAt(i) == 'A') {
                if (arr.charAt(i + 1) != 'T') {
                    return false;
                }
            }

            if (arr.charAt(i) == 'T') {
                if (arr.charAt(i + 1) != 'A') {
                    return false;
                }
            }
            if (arr.charAt(i) == 'G') {
                if (arr.charAt(i + 1) != 'C') {
                    return false;
                }
            }
            if (arr.charAt(i) == 'C') {
                if (arr.charAt(i + 1) != 'G') {
                    return false;
                }
            }

            if (arr.charAt(i) != 'A' && arr.charAt(i) != 'T' && arr.charAt(i) != 'G' && arr.charAt(i) != 'C') {
                return false;
            }
        }

        return true;
    }
    public static boolean istDNA(boolean[] arr) {
        if (arr.length % 4 != 0) {
            return false;
        }
        for (int i = 0; i < arr.length - 1; i = i + 4) {
            if (arr[i] == false && arr[i + 1] == false) {
                if (!(((arr[i + 2] == false) && (arr[i + 3] == true)))) {
                    return false;
                }
            }
            if (arr[i] == false && arr[i + 1] == true) {
                if (!(((arr[i + 2] == false) && (arr[i + 3] == false)))) {
                    return false;
                }
            }
            if (arr[i] == true && arr[i + 1] == false) {
                if (!(((arr[i + 2] == true) && (arr[i + 3] == true)))) {
                    return false;
                }
            }
            if (arr[i] == true && arr[i + 1] == true) {
                if (!(((arr[i + 2] == true) && (arr[i + 3] == false)))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean istDNA(byte[] arr) {

        if (arr.length % 2 != 0) {
            return false;
        }
        for (int i = 0; i < arr.length - 1; i = i + 2) {
            if (arr[i] == 0) {
                if (arr[i + 1] != 1) {
                    return false;
                }
            }

            if (arr[i] == 1) {
                if (arr[i + 1] != 0) {
                    return false;
                }
            }
            if (arr[i] == 2) {
                if (arr[i + 1] != 3) {
                    return false;
                }
            }
            if (arr[i] == 3) {
                if (arr[i + 1] != 2) {
                    return false;
                }
            }

            if (arr[i] != 0 && arr[i] != 1 && arr[i] != 2 && arr[i] != 3) {
                return false;
            }
        }

        return true;
    }

    public static byte[] zuDNA(String dna) {
        if (istDNA(dna)) {
            byte[] dnaArr = new byte[dna.length()];
            for (int i = 0; i < dna.length(); i++) {
                switch (dna.charAt(i)) {
                    case 'A':
                        dnaArr[i] = 0;
                        break;
                    case 'T':
                        dnaArr[i] = 1;
                        break;
                    case 'G':
                        dnaArr[i] = 2;
                        break;
                    case 'C':
                        dnaArr[i] = 3;
                        break;

                }
            }
            return dnaArr;
        } else {
            return null;
        }
    }

    public static String zuDNA(byte[] dna) {
        if (istDNA(dna)) {
            String dnaStr = "";
            for (int i = 0; i < dna.length; i++) {
                switch (dna[i]) {
                    case 0:
                        dnaStr += "A";
                        break;
                    case 1:
                        dnaStr += "T";
                        break;
                    case 2:
                        dnaStr += "G";
                        break;
                    case 3:
                        dnaStr += "C";
                        break;

                }
            }
            return dnaStr;
        } else {
            return null;
        }
    }

    public static boolean[] zuDNA_Bool(String dna) {
        if (istDNA(dna)) {
            boolean[] dnaArr = new boolean[dna.length() * 2];
            for (int i = 0; i < dna.length(); i++) {
                switch (dna.charAt(i)) {
                    case 'A':
                        dnaArr[i] = false;
                        dnaArr[i + 1] = false;
                        break;
                    case 'T':
                        dnaArr[i] = false;
                        dnaArr[i + 1] = true;
                        break;
                    case 'G':
                        dnaArr[i] = true;
                        dnaArr[i + 1] = false;
                        break;
                    case 'C':
                        dnaArr[i] = true;
                        dnaArr[i + 1] = true;
                        break;
                }
            }
            return dnaArr;

        }
        return null;
    }

    public static String zuDNA_Bool(boolean[] dna) {
        if (istDNA(dna)) {
            String dnaStr = "";
            for (int i = 0; i < dna.length; i+=2) {
                if (dna[i]) {
                    if (dna[i + 1]) {
                        dnaStr += "C";
                    } else {
                        dnaStr += "G";
                    }
                } else {
                    if (dna[i + 1]) {
                        dnaStr += "T";
                    } else {
                        dnaStr += "A";
                    }
                }
            }
            return dnaStr;
        }
        return null;
    }
    public static byte[] zuDNA_effizient(String dna) {
        String dnaStr = "";
        if (istDNA(dna)) {
            byte[] dnaArr = new byte[dna.length()/4];
            for (int i = 0; i < dna.length(); i++) {
                if (dna.charAt(i) == 'A'){
                    dnaStr += "00";
                }
                if (dna.charAt(i) == 'T'){
                    dnaStr += "01";
                }
                if (dna.charAt(i) == 'C'){
                    dnaStr += "11";
                }
                if (dna.charAt(i) == 'G'){
                    dnaStr += "10";
                }
            }
            for (int i = 0; i < dnaStr.length(); i+=9) {
                String coc = dnaStr.substring(i, i+8);
                dnaArr[i] = Byte.parseByte(coc, 2);
            }
            return dnaArr;
        }
        return null;
    }

    public static void main(String[] args) {
        String j = "ATGC";
        boolean[] arr = zuDNA_Bool(j);
        blatt07.ArbeitMitArrays.printArray(arr);
    }
}//h nicht sehr viel
//k weniger als davor
