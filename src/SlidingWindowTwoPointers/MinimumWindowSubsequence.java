package SlidingWindowTwoPointers;

public class MinimumWindowSubsequence {
    public String minWindow(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (m < n) {
            return "";
        }

        int minLen = m + 1;
        int minStart = -1;

        int l = 0;

        for (int r = 0; r < m; r++) {

            int i = 0;

            // Forward search for s2 as a subsequence in s1[l...r]
            for (int k = l; k <= r; k++) {
                if (s1.charAt(k) == s2.charAt(i)) {
                    i++;
                }
                if (i == n) {
                    break;
                }
            }

            if (i == n) {
                // Backward search to find the minimum starting index (newL)
                int newL = l;
                int j = n - 1;

                for (int k = r; k >= l; k--) {
                    if (s1.charAt(k) == s2.charAt(j)) {
                        j--;
                    }
                    if (j < 0) {
                        newL = k;
                        break;
                    }
                }

                int currentLen = r - newL + 1;
                if (currentLen < minLen) {
                    minLen = currentLen;
                    minStart = newL;
                }

                // Move the main left pointer past the found window's start
                l = newL + 1;
            }
        }

        return minStart == -1 ? "" : s1.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {

    }
}
