package blatt07;

public class ArbeitMitArrays {
    public static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println(" ]");
    }
    public static void printArray(double[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println(" ]");
    }
    public static void printArray(boolean[] arr) {
        System.out.println("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println(" ]");
    }
    public static void printArray(char[] arr) {
        System.out.println("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println(" ]");
    }
    public static void printArray(String[] arr) {
        System.out.println("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
        System.out.println(" ]");
    }
    public static boolean istSortiert(int[] arr){
        boolean a = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                a = false;
                break;
            } else {
                a = true;
            }
        }
        return a;
    }
    public static int[] addieren(int[] arr_1, int[] arr_2) {
        int[] arr_3 = new int[arr_1.length];
        if (arr_1.length < arr_2.length){
            arr_3 = new int[arr_2.length];
            for (int i = 0; i < arr_2.length; i++) {
                if (i != arr_1.length) {
                    arr_3[i] = arr_1[i] + arr_2[i];
                } else {
                    arr_3[i] = arr_2[i];
                }
            }
        } else if (arr_2.length < arr_1.length) {
            for (int i = 0; i < arr_1.length; i++) {
                if (i != arr_2.length) {
                    arr_3[i] = arr_2[i] + arr_1[i];
                } else {
                    arr_3[i] = arr_2[i];
                }
            }
        } else {
            for (int i = 0; i < arr_1.length; i++) {
                arr_3[i] = arr_1[i] + arr_2[i];
            }
        }
        return arr_3;
    }
    public static int[] shiftLeft(int[] arr){
        int a = arr[0];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i++];
        }
        arr[arr.length - 1] = a;
        return arr;
    }
    public static int[] shiftLeftAbsolute(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i++];
        }
        arr[arr.length - 1] = 0;
        return arr;
    }
    public static int[] shiftRightAbsolute(int[] arr){
        for (int i = arr.length; i > 0; i--) {
            arr[i] = arr[i--];
        }
        arr[0] = 0;
        return arr;
    }
    public static void main(String[] args) {

    }
}
