package DynamicProgramming.LIS;

import java.util.Arrays;

public class LSC {
    public static int longestStrChain(String[] words){
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxlen = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(isPredecessor(words[j], words[i])){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            if(dp[i] > maxlen){
                maxlen = dp[i];
            }
        }
        return maxlen;
    }

    public static boolean isPredecessor(String a, String b){
        if(b.length() - a.length() != 1) return false;

        int i = 0; int j = 0;
        boolean skipped = false;
        while (i < a.length() && j < b.length()){
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            } else {
                if(skipped) return false;
                skipped = true;
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        System.out.println(longestStrChain(words)); // Output: 4
    }
}
