package SlidingWindowTwoPointers;

public class CountNiceSubarrays {
    public static int numberOfArray(int[] nums, int k){
        return atmost(nums, k) - atmost(nums, k-1);
    }

    public static int atmost(int[] nums, int k){
        int sum = 0;
        int left = 0;
        int count = 0;

        for(int right = 0; right < nums.length; right++){
            nums[right] = (nums[right] % 2 == 0) ? 0 : 1;
            sum += nums[right];
            while (sum > k){
                nums[left] = (nums[left] % 2 == 0) ? 0 : 1;
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int ans = numberOfArray(nums, 2);
        System.out.print(ans);
    }
}
