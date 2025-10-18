package Arrays.Easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarray {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        int currentSum = 0;
        int maxLength = 0;

        sumToIndex.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            int targetSum = currentSum - k;

            if (sumToIndex.containsKey(targetSum)) {
                int length = i - sumToIndex.get(targetSum);
                maxLength = Math.max(maxLength, length);
            }

            if (!sumToIndex.containsKey(currentSum)) {
                sumToIndex.put(currentSum, i);
            }
        }

        return maxLength;
    }
}
