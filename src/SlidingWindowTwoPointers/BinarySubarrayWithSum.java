package SlidingWindowTwoPointers;

public class BinarySubarrayWithSum {
    public static int numSubarraysWithSum(int[] nums, int goal){
        return atmost(nums, goal) - atmost(nums,  goal - 1);
    }

    public static int atmost(int[] nums, int goal){
        if(goal < 0) return 0;
        int left = 0; int count = 0; int sum = 0;

        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while (sum > goal){
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int ans = numSubarraysWithSum(nums, 2);
        System.out.print(ans);
    }
}
