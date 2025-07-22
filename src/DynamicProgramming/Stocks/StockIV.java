package DynamicProgramming.Stocks;

public class StockIV {
    public static int stockIV(int k, int[] prices){
        int n = prices.length;
        Integer[][][] dp = new Integer[n][2][k+1];
        return solve(0, 0, k, prices, dp);
    }
    public static int solve(int i, int holding, int k, int[] prices, Integer[][][] dp){
        if(i == prices.length || k == 0) return 0;
        if(dp[i][holding][k] != null) return dp[i][holding][k];

        int profit = 0;
        if(holding == 0) {
            int buy = -prices[i] + solve(i+1, 1, k, prices, dp);
            int skip = solve(i+1, 0, k, prices, dp);
            profit = Math.max(buy, skip);
        } else {
            int sell = prices[i] + solve(i+1, 0, k-1, prices, dp);
            int skip = solve(i+1, 1, k, prices, dp);
            profit = Math.max(sell, skip);
        }
        return dp[i][holding][k] = profit;
    }
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int ans = stockIV(2, prices);
        System.out.print(ans);
    }
}
