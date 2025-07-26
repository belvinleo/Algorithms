package SlidingWindowTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class FruitBaskets {
    public static int fruitBaskets(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxlen = 0;

        for(int right = 0; right < nums.length; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() > 2){
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] fruits = {1, 2, 3, 2, 2};
        int ans = fruitBaskets(fruits);
        System.out.print(ans);
    }
}
