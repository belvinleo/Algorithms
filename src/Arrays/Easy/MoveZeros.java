package Arrays.Easy;

public class MoveZeros {
    public static void MoveZeros(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                for(int j = i; j < n-1; j++){
                    arr[j] = arr[j+1];
                }
                arr[n-1] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 5, 6};
        MoveZeros(nums);
        System.out.print(nums);
    }
}
