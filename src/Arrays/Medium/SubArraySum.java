package Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public static int subarraySum(int[] nums, int k){
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        int sum = 0;
        int count = 0;
        for(int x : nums){
            sum += x;
            int need = sum - k;
            count += freq.getOrDefault(need, 0);
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {

    }
}
