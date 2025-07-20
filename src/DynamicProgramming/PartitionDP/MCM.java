package DynamicProgramming.PartitionDP;

import java.util.Arrays;

public class MCM {
    public static int mcmMemoization(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(nums, 1, n-1, dp);
    }
    public static int solve(int[] nums, int i, int j, int[][] dp){
        if(i == j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int cost = solve(nums, i, k, dp) + solve(nums, k+1, j, dp) + (nums[i-1] * nums[k] * nums[j]);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }

    public static int mcmTabulation(int[] nums){
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {10, 30, 5, 60};
        int ans = mcmMemoization(nums);
        System.out.print(ans);
    }
}
