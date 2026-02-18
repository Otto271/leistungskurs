package blatt12;

import blatt07.ArbeitMitArrays;

public class InsertionSort {
    public static int[] insertionSort(int[] arr) {
        int[] sortiert = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && sortiert[j] > temp) {
                sortiert[j + 1] = sortiert[j];
                j--;
            }

            sortiert[j + 1] = temp;
        }

        return sortiert;
    }
    public static void insertionSortInPlace(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {64, 25, 12, 22, 11, 65, 77, 100, 1, 77};
        arr = insertionSort(arr);
        ArbeitMitArrays.printArray(arr);
    }
}
