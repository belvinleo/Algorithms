package DynamicProgramming.Stocks;

public class StockWithFee {
    public static int maxProfit(int[] prices, int fee){
        int n = prices.length;
        Integer[][] dp = new Integer[n][2];
        return solve(0, 0, fee, prices, dp);
    }
    public static int solve(int i, int holding, int fee, int[] prices, Integer[][] dp){
        if(i == prices.length) return 0;
        if(dp[i][holding] != null) return dp[i][holding];

        int profit = 0;
        if(holding == 0){
            int buy = -prices[i] + solve(i+1, 1, fee, prices, dp);
            int skip = solve(i+1, 0, fee, prices, dp);
            profit = Math.max(buy, skip);
        } else {
            int sell = prices[i] + solve(i+1, 0, fee, prices, dp) - fee;
            int skip = solve(i+1, 1, fee, prices, dp);
            profit = Math.max(sell, skip);
        }
        return dp[i][holding] = profit;
    }

    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int ans = maxProfit(prices, 2);
        System.out.print(ans);
    }
}
