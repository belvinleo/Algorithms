package DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LDS {
    public static List<Integer> largestDivisibleSubset(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);

        int maxlen = 1;
        int maxIndex = 0;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if(dp[i] > maxlen){
                maxlen = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        int k = maxIndex;
        while (prev[k] != k){
            result.add(nums[k]);
            k = prev[k];
        }
        result.add(nums[k]);

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<Integer> ans = largestDivisibleSubset(nums);
        System.out.print(ans);
    }
}
