package DynamicProgramming.Subsequence;

public class SubsetWithTarget {

    public static boolean isSubsetSumMemoization(int[] nums, int target){
        int n = nums.length;
        Boolean[][] dp = new Boolean[n][target + 1];
        return solve(nums, n-1, target, dp);
    }

    private static boolean solve(int[] nums, int index, int target, Boolean[][] dp){
        if(target == 0) return true;
        if(index < 0) return false;

        if(dp[index][target] != null) return dp[index][target];

        //exclude current element
        boolean notTake = solve(nums, index - 1, target, dp);

        //include current element
        boolean take = false;
        if(nums[index] <= target){
            take = solve(nums, index - 1, target - nums[index], dp);
        }

        return dp[index][target] = take || notTake;
    }

    public static boolean isSubsetSumTabulation(int[] nums, int target){
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][target + 1];

        // Subset sum = 0 is always possible
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Build the table
        for (int i = 1; i <= n; i++) {
            for (int sum = 1; sum <= target; sum++) {
                if (nums[i - 1] <= sum) {
                    dp[i][sum] = dp[i - 1][sum] || dp[i - 1][sum - nums[i - 1]];
                } else {
                    dp[i][sum] = dp[i - 1][sum];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = {3, 34, 4, 12, 5, 2};
        int target = 9;
        System.out.println(isSubsetSumMemoization(nums, target));
        System.out.println(isSubsetSumTabulation(nums, target));
    }
}
