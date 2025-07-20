package DynamicProgramming.LIS;

import java.util.Arrays;

public class LIS {
    public static int LIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxlen = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxlen = Math.max(dp[i], maxlen);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int ans = LIS(nums);
        System.out.print(ans);
    }
}
