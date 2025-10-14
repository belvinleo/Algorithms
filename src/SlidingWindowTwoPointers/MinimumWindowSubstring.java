package SlidingWindowTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t){
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> requiredFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            requiredFreq.put(c, requiredFreq.getOrDefault(c, 0) + 1);
        }

        int requiredCount = t.length();
        int l = 0;
        int minLen = s.length() + 1;
        int minStart = 0;

        for (int r = 0; r < s.length(); r++) {
            char rChar = s.charAt(r);

            if (requiredFreq.containsKey(rChar)) {
                requiredFreq.put(rChar, requiredFreq.get(rChar) - 1);

                if (requiredFreq.get(rChar) >= 0) {
                    requiredCount--;
                }
            }

            while (requiredCount == 0) {
                int currentLen = r - l + 1;

                if (currentLen < minLen) {
                    minLen = currentLen;
                    minStart = l;
                }

                char lChar = s.charAt(l);

                if (requiredFreq.containsKey(lChar)) {
                    requiredFreq.put(lChar, requiredFreq.get(lChar) + 1);

                    if (requiredFreq.get(lChar) > 0) {
                        requiredCount++;
                    }
                }

                l++;
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
