package DynamicProgramming.Subsequence;

public class PartionWithSubsetSum {
    public static boolean canPartitionMemoization(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;

        int target = sum / 2;
        Boolean[][] dp = new Boolean[n][target+1];
        return solve(nums, n-1, target, dp);
    }

    private static boolean solve(int[] nums, int index, int target, Boolean[][]  dp){
        if(target == 0) return true;
        if(index < 0) return false;

        if(dp[index][target] != null) return dp[index][target];

        //Excluding the element
        boolean notTake = solve(nums, index - 1, target, dp);

        //Including the element
        boolean take = false;
        if(nums[index] <= target) {
            take = solve(nums, index - 1, target - nums[index], dp);
        }

        return dp[index][target] = take || notTake;
    }

    public static boolean canPartitionTabulation(int[] nums){
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }

        if(sum % 2 != 0) return false;
        int target = sum / 2;
        Boolean[][] dp = new Boolean[n+1][target + 1];

        for(int i = 0; i <= n; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= target; j++){
                if(nums[i] <= j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i-1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.print(canPartitionMemoization(nums));
    }
}
