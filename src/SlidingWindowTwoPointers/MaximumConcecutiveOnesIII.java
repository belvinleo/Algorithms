package SlidingWindowTwoPointers;

public class MaximumConcecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int left = 0; int right = 0;
        int maxlen = 0;
        int zeroCount = 0;

        while(right < nums.length){

            if(nums[right] == 0){
                zeroCount++;
            }

            while (zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }

            maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int ans = longestOnes(nums, 2);
        System.out.print(ans);
    }
}
