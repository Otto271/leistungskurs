package blatt12;

public class InsertionSort {
    public static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int wert =  arr[i];
            int j = i;
            while (j > 0 && arr[j-1] > wert){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = wert;
        }
        return arr;
    }
    public static void insertionSortInPlace(int[] arr) {
        int[] temp = new int[arr.length];
        int j = 0;
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int k = 1; k < arr.length - 1; k++) {
                if (arr[k] < arr[k - 1]) {
                    j = arr[k];
                    n = k;
                }
            }
            arr[n] = 0;
            temp[i] = j;
        }
    }
}
