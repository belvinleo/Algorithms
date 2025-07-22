package DynamicProgramming.Stocks;

public class StockIII {
    public static int stockIII(int[] prices){
        int n = prices.length;
        Integer[][][] dp = new Integer[n][2][3];
        return solve(0, 0, 2, prices, dp);
    }

    public static int solve(int i, int holding, int txn, int[] prices, Integer[][][] dp){
        if(i == prices.length || txn == 0) return 0;
        if(dp[i][holding][txn] != null) return dp[i][holding][txn];

        int profit = 0;
        if(holding == 0){
            int buy = -prices[i] + solve(i+1, 1, txn, prices, dp);
            int skip = solve(i+1, 0, txn, prices, dp);
            profit = Math.max(buy, skip);
        } else {
            int sell = prices[i] + solve(i+1, 0, txn -1, prices, dp);
            int skip = solve(i+1, 1, txn, prices, dp);
            profit = Math.max(sell, skip);
        }
        return dp[i][holding][txn] = profit;
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        int ans = stockIII(prices);
        System.out.print(ans);
    }
}
