package DynamicProgramming.LIS;

import java.util.Arrays;

public class NumberOfLIS {
    public static int numberOfLIS(int[] nums){
        int n = nums.length;

        int[] dp = new int[n];
        int[] count  = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int maxlen = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]) {
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if(dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }

        int total = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == maxlen){
                total += count[i];
            }
        }
        return total;
    }
    public static void main(String[] args){
        int[] nums = {1, 2, 5, 4, 7};
        int ans = numberOfLIS(nums);
        System.out.print(ans);
    }
}
