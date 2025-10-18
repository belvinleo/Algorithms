package Arrays.Easy;

public class MissingNumber {
    public static int MissingNumber(int[] arr){
        int n = arr.length;
        int sum1 = n*((n+1)/2);
        int sum2 = 0;
        for(int i = 0; i < n; i++){
            sum2 = sum2 + arr[i];
        }
        return sum1 - sum2;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 5, 6};
        int ans = MissingNumber(nums);
        System.out.print(ans);
    }
}
