package blatt19;

public class QuickSort {
    public static int[] trennenLinks(int[] arr,int pospov) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != pospov) {
                if (arr[i] <= arr[pospov]) {
                    count++;
                }
            }
        }
        int[] kleiner = new int[count];
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != pospov) {
                if (arr[i] <= arr[pospov]) {
                    kleiner[count] = arr[i];
                    count++;
                }
            }
        }
        return kleiner;
    }
    public static int[] trennenRechts(int[] arr,int pospov) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != pospov) {
                if (arr[i] >= arr[pospov]) {
                    count++;
                }
            }
        }
        int[] groesser = new int[count];
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != pospov) {
                if (arr[i] >= arr[pospov]) {
                    groesser[count] = arr[i];
                    count++;
                }
            }
        }
        return groesser;
    }
    public static int[] zusammenfuegen(int[] arr1 ,int[] arr2 ,int pivot) {
        int[] zusammen = new int[arr1.length + arr2.length + 1];
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] <= pivot) {
                zusammen[count] = pivot;
            } else {
                zusammen[count] = arr1[i];
                count++;
            }
        }
        zusammen[count] = pivot;
        for (int i = 0; i < arr2.length; i++) {
            zusammen[count] = arr2[i];
            count++;
        }
        return zusammen;
    }
    /*public static int[] quickSort(int[] arr) {
        if (arr.length != 0) {
            int pivot = arr[0];
            int[] kUnso = trennenLinks(arr,0);
            int[] gUnso = trennenRechts(arr,0);

        }
    }*/
}
