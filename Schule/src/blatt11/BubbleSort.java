package blatt11;
import static blatt07.ArbeitMitArrays.istSortiert;
public class BubbleSort {
    public static void swap(int[] arr, int j){
        int a =  arr[j];
        arr[j] = arr[j++];
        arr[j] = a;
    }
    public static int[] bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - 1; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j);
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {2,6,1,7,5,3,8,4,0,9};
        int[] sort = bubbleSort(arr);
        boolean b = istSortiert(sort);
        System.out.println(b);
    }
}
