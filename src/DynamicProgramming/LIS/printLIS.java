package DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class printLIS {
    public static void printLIS(int[] nums){
        int n = nums.length;

        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);
        for(int i = 0; i < n; i++) prev[i] = i;

        int maxlen = 1;
        int lastIndex = 0;


        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if(dp[i] > maxlen){
                maxlen = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        int k = lastIndex;
        while (prev[k] != k){
            result.add(nums[k]);
            k = prev[k];
        }
        result.add(nums[k]);
        Collections.reverse(result);

        System.out.print(result);
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        printLIS(nums);
    }
}
