package DynamicProgramming.Subsequence;

import java.util.Arrays;

public class coinChangeII {
    public static int coinChange(int[] coins, int amount){
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount+1];
        return solve(0, coins, amount, dp);
    }

    public static int solve(int index, int[] coins, int amount, Integer[][] dp){
        if(amount == 0) return 1;
        if(index == coins.length) return 0;

        if(dp[index][amount] != null) return dp[index][amount];

        int ways = 0;
        if(coins[index] <= amount){
            ways += solve(index, coins, amount - coins[index], dp);
        }

        ways += solve(index+1, coins, amount, dp);

        return dp[index][amount] = ways;
    }


    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int ans = coinChange(coins, 5);
        System.out.print(ans);
    }
}
