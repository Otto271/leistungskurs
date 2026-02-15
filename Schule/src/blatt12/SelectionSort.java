package blatt12;

import blatt07.ArbeitMitArrays;

public class SelectionSort {
    public static void SelectionSort(int[] arr, boolean max){
        for (int i = 0; i < arr.length - 1; i++) {
            int selectedIndex = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (max) {
                    if (arr[j] > arr[selectedIndex]) {
                        selectedIndex = j;
                    }
                } else {
                    if (arr[j] < arr[selectedIndex]) {
                        selectedIndex = j;
                    }
                }
            }

            int temp = arr[i];
            arr[i] = arr[selectedIndex];
            arr[selectedIndex] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[] {64, 25, 12, 22, 11};
        SelectionSort(arr, false);
        ArbeitMitArrays.printArray(arr);
    }
}
