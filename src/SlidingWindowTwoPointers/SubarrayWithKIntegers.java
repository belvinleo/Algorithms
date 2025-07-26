package SlidingWindowTwoPointers;

import java.util.Map;
import java.util.HashMap;

public class SubarrayWithKIntegers {
    public static int subarrayWithKDistinctIntegers(int[] nums, int k){
        return atmost(nums, k) - atmost(nums, k-1);
    }
    public static int atmost(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;

        for(int right = 0; right < nums.length; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() > k){
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            result += right - left;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int ans  = subarrayWithKDistinctIntegers(nums, 2);
        System.out.print(ans);
    }
}
