package DynamicProgramming.PartitionDP;

public class BurstBalloons {
    public static int burstBalloons(int[] nums){
        int n = nums.length;

        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;

        for(int i = 0; i < n; i++){
            arr[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];
        return solve(arr, 0, n+1, dp);
    }

    public static int solve(int[] arr, int left, int right, int[][] dp){
        return 0;
    }

    public static void main(String[] args) {

    }
}
