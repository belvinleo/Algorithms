package Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithXORk {
    public static int countSubarrayWithXORk(int[] nums, int k){
        Map<Integer, Integer> freq = new HashMap<>();
        int xor = 0;
        int count = 0;

        for (int v : nums) {
            xor ^= v;

            if (xor == k) count++; // subarray starting at 0

            int need = xor ^ k;    // previous prefix XOR needed
            count += freq.getOrDefault(need, 0);

            freq.put(xor, freq.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {4, 2, 2, 6, 4};
        int ans = countSubarrayWithXORk(nums, 6);
        System.out.print(ans);
    }
}
