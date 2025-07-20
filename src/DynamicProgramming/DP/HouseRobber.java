package DynamicProgramming.DP;

public class HouseRobber {
    public static int houseRobber(int[] nums){
        int n = nums.length;
        Integer[] dp = new Integer[n];
        return solve(n-1, nums, dp);
    }

    public static int solve(int index, int[] nums, Integer[] dp){
        if(index < 0) return 0;
        if(dp[index] != null) return dp[index];

        int rob = nums[index] + solve(index - 2, nums, dp);
        int skip = solve(index - 1, nums, dp);

        return dp[index] = Math.max(rob, skip);
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int ans = houseRobber(nums);
        System.out.print(ans);
    }
}
