package Arrays.Easy;

public class RotateArray {
    public static void RotateArray(int[] arr, int k){
        int n = arr.length;
        for(int i = 0; i < k; i++){
            int temp = arr[0];
            for(int j = 0; j < n-1; j++){
                arr[j] = arr[j+1];
            }
            arr[n-1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 5, 6};
        RotateArray(nums, 2);
        System.out.print(nums);
    }
}
