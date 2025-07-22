package DynamicProgramming.Stocks;

public class StockWithCooldown {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][] dp = new Integer[n+2][2];
        return solve(0, 0, prices, dp);
    }
    public static int solve(int i, int holding, int[] prices, Integer[][] dp){
        if(i >= prices.length) return 0;
        if(dp[i][holding] != null) return dp[i][holding];

        int profit = 0;
        if(holding == 0){
            int buy = -prices[i] + solve(i+1, 1, prices, dp);
            int skip = solve(i+1, 0, prices, dp);
            profit = Math.max(buy, skip);
        } else {
            int sell = prices[i] + solve(i+2, 0, prices, dp);
            int skip = solve(i+1, 1, prices, dp);
            profit = Math.max(sell, skip);
        }
        return dp[i][holding] = profit;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        int ans = maxProfit(prices);
        System.out.print(ans);
    }
}
