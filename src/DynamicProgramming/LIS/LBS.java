package DynamicProgramming.LIS;

import java.util.Arrays;

public class LBS {
    public static int longestBitonicSubsequence(int[] nums){
        int n = nums.length;
        int[] lis = new int[n];
        int[] lds = new int[n];

        //lis
        Arrays.fill(lis, 1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] && lis[j] + 1 > lis[j]){
                    lis[i] = lis[j] + 1;
                }
            }
        }


        //lds
        Arrays.fill(lds, 1);
        for(int i = n-2; i >= 0; i--){
            for(int j = n-1; j > i; j--){
                if(nums[j] > nums[i] && lds[j] + 1 > lds[i]){
                    lds[i] = lds[j] + 1;
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, lis[i] + lds[i] - 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7, 2, 1};
        System.out.println(longestBitonicSubsequence(nums));
    }
}
