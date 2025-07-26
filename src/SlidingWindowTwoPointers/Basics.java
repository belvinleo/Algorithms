package SlidingWindowTwoPointers;

public class Basics {
    public static void constantWindow(int[] nums){
        int n = nums.length;
        int window_size = 4;

        int left = 0;
        int right = window_size - 1;

        int sum = 0;
        while (right < n){
            sum = sum - nums[left];
            left++;
            right++;
            sum = sum + nums[right];
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 23, 4, 65, 90, 2, 545, 345, 73, 5, 7 , 2, 6456, 98};
    }
}
