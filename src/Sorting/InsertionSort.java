package Sorting;

public class InsertionSort {
    public static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i <= n-1; i++){
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
