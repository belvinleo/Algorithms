package DynamicProgramming.Stocks;

public class StockI {
    public static int stockI(int[] nums){
        int n = nums.length;;
        Integer[][] dp = new Integer[n][2];
        return solve(0, 0, nums, dp);
    }
    public static int solve(int i, int holding, int[] nums, Integer[][] dp){
        if(i == nums.length) return 0;
        if(dp[i][holding] != null) return dp[i][holding];

        int profit = 0;
        if(holding == 0){
            //either buy or skip if holding is 0
            int buy = -nums[i] + solve(i+1,1, nums, dp);
            int skip = solve(i+1, 0, nums, dp);
            profit = Math.max(buy, skip);
        } else {
            //either sell or skip if holding is 1
            int sell = nums[i] + solve(i+1, 0, nums, dp);
            int skip = solve(i+1, 1, nums, dp);
            profit = Math.max(sell, skip);
        }
        return dp[i][holding] = profit;
    }
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        int ans = stockI(nums);
        System.out.print(ans);
    }
}
