package Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

public class Longest0SumSubarray {
    public static int longest0sumSubarray(int[] nums){
        Map<Integer, Integer> firstIndex = new HashMap<>();
        firstIndex.put(0, -1);

        int prefix = 0;
        int best = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];

            if (firstIndex.containsKey(prefix)) {
                best = Math.max(best, i - firstIndex.get(prefix));
            } else {
                firstIndex.put(prefix, i); // store first occurrence only
            }
        }
        return best;
    }
    public static void main(String[] args) {
        int[] nums = {15, -2, 2, -8, 1, 7, 10};
        int ans = longest0sumSubarray(nums);
        System.out.print(ans);
    }
}
