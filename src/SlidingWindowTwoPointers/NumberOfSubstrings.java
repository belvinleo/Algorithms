package SlidingWindowTwoPointers;

public class NumberOfSubstrings {
    public static int numberOfSubstring(String s){
        int[] count = new int[3];
        int left = 0;
        int result = 0;

        for(int right = 0; right < s.length(); right++){
            count[s.charAt(right) - 'a']++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0){
                result += s.length() - right;
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        int ans = numberOfSubstring(s);
        System.out.print(ans);
    }
}
