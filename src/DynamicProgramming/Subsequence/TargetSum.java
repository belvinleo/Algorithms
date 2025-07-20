package DynamicProgramming.Subsequence;

public class TargetSum {
    public static int targetSum(int[] nums, int target){
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }

        if((sum + target) % 2 != 0 || sum < Math.abs(target)) return 0;

        int sumP = (target + sum) / 2;
        int[][] dp = new int[n+1][sumP+1];

        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 0; j<= sumP; j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sumP];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int ans = targetSum(nums, 3);
        System.out.print(ans);
    }
}
