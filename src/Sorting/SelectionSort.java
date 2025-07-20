package Sorting;

public class SelectionSort {
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i = 0; i <= n-2; i++){
            int mini = i;
            for(int j = i+1; j <= n-1; j++){
                if(arr[j] < arr[mini]){
                    mini = j;
                }
            }
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
