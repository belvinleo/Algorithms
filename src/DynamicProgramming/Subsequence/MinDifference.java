package DynamicProgramming.Subsequence;

public class MinDifference {
    public static int minDifference(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Base case: sum 0 is always possible (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Build DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Find the minimum difference
        int minDiff = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= sum / 2; s1++) {
            if (dp[n][s1]) {
                int s2 = sum - s1;
                minDiff = Math.min(minDiff, Math.abs(s2 - s1));
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(minDifference(nums));
    }
}
