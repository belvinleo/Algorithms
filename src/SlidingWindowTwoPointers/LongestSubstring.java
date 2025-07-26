package SlidingWindowTwoPointers;

import java.util.HashMap;

public class LongestSubstring {
    public static int longestSubsstring(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int maxlen = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);

            if(map.containsKey(c)){
                left = Math.max(map.get(c) + 1, left);
            }

            map.put(c, right);
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int ans = longestSubsstring(s);
        System.out.print(ans);
    }
}