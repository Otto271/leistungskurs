package blatt12;

import blatt07.ArbeitMitArrays;

public class SelectionSort {
    public static void SelectionSort(int[] arr){
        int[] temp = new int[arr.length];
        int i = 1;
        int j = 0;
        int n = 0;
        while (i < arr.length) {
            int k = i;
            while (k < arr.length) {
                if (arr[k] < arr[k - 1]) {
                    j = arr[k];
                    n = k;
                }
                k++;
            }
            arr[n] = 999999999;
            temp[i--] = j;
            System.out.println(arr[i--]);
            i++;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] {64, 25, 12, 22, 11};
        SelectionSort(arr);
        ArbeitMitArrays.printArray(arr);
    }
}
