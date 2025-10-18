package SlidingWindowTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static int kDistinctChar(String s, int k){
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxlen = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k){
                char charLeft = s.charAt(left);
                map.put(charLeft, map.get(charLeft) - 1);
                if(map.get(charLeft) == 0){
                    map.remove(charLeft);
                }
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int ans = kDistinctChar(s, 2);
        System.out.print(ans);
    }
}
