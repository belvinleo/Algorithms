package DynamicProgramming.DP;

import java.util.Arrays;

public class DynamicProgramming {

    public static int fibonacciMemoization(int n, int[] memo){
        if (n <= 1) return n;
        if(memo[n] != -1) return n;

        memo[n] = fibonacciMemoization(n-1, memo) + fibonacciMemoization(n-2, memo);
        return memo[n];
    }

    public static int fibonacciTabulation(int n){
        if(n == 1) return n;
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i < n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //Frog jump problem
    public static int frogJump(int n, int[] height){
        //int n = height.length;
        if(n == 0) return 0;
        int left =  frogJump(n-1, height) + Math.abs(height[n] - height[n-1]);
        int right = 0;
        if(n > 1){
            right = frogJump(n-2, height) + Math.abs(height[n] + height[n-1]);
        }
        return Math.min(left, right);

    }

    //House Robber
    public static int rob(int[] nums, int n){
        int left = n + rob(nums, n-2);
        int right = n-1 + rob(nums, n-3);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        int n = 10;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        System.out.print(fibonacciMemoization(n, memo));
    }
}
