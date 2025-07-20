package DynamicProgramming.Strings;

public class LCSubstring {
    public static String LCSubstring(String t1, String t2){
        int m = t1.length();
        int n = t2.length();

        int[][] dp = new int[m+1][n+1];

        int maxlen = 0;
        int endIdx = 0;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(t1.charAt(i-1) == t2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(dp[i][j] > maxlen){
                        maxlen = dp[i][j];
                        endIdx = i;
                    }
                }
            }
        }
        String result = t1.substring(endIdx - maxlen, endIdx);
        return result;
    }
    public static void main(String[] args) {
        String ans = LCSubstring("abcde", "cde");
        System.out.print(ans);
    }
}
