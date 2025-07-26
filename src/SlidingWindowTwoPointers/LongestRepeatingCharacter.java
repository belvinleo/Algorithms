package SlidingWindowTwoPointers;

public class LongestRepeatingCharacter {
    public static int characterReplacement(String s, int k){
        int[] count = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxlen = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            count[c - 'A']++;

            maxFreq = Math.max(maxFreq, count[c - 'A']);

            int window = right - left + 1;

            if(window - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxlen = Math.max(maxlen, right - left + 1);

        }
        return maxlen;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int ans = characterReplacement(s, 1);
        System.out.print(ans);
    }
}
