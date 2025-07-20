package DynamicProgramming.Subsequence;

import java.util.Arrays;

public class coinChange {
    public int coinChange(int[] coins, int amount){
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        int result = solve(coins, amount, memo);
        if(result == Integer.MAX_VALUE) return -1;
        else return result;
    }

    public int solve(int[] coins, int amount, int[] memo){
        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;

        if(memo[amount] != -2) return memo[amount];

        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int res = solve(coins, amount - coin, memo);
            if(res != Integer.MAX_VALUE){
                min = Math.min(min, res + 1);
            }
        }

        memo[amount] = min;
        return min;
    }
}
