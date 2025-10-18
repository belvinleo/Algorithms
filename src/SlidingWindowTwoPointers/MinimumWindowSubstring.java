package SlidingWindowTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t){
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int count = t.length();
        int left = 0;
        int minLen = s.length() + 1;
        int minStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);
            if (freq.containsKey(rChar)) {
                freq.put(rChar, freq.get(rChar) - 1);
                if (freq.get(rChar) >= 0) {
                    count--;
                }
            }

            while (count == 0) {
                int currLen = right - left + 1;
                if (currLen < minLen) {
                    minLen = currLen;
                    minStart = left;
                }
                char lChar = s.charAt(left);
                if (freq.containsKey(lChar)) {
                    freq.put(lChar, freq.get(lChar) + 1);
                    if (freq.get(lChar) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }

        return minLen > s.length() ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans = minWindow(s, t);
        System.out.print(ans);
    }
}
