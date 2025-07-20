package DynamicProgramming.Strings;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static int LCSmemoization(String t1, String t2){
        int m = t1.length();
        int n = t2.length();

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(m-1, n-1, t1, t2, dp);

    }

    public static int solve(int i, int j, String t1, String t2, int[][] dp){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(t1.charAt(i) == t2.charAt(j)) {
            dp[i][j] = 1 + solve(i-1, j-1, t1, t2, dp);
        } else if(t1.charAt(i) != t2.charAt(j)) {
            dp[i][j] = Math.max(solve(i-1, j, t1, t2, dp), solve(i, j-1, t1, t2, dp));
        }
        return dp[i][j];
    }

    public static int LCStabulation(String t1, String t2){
        int m = t1.length();
        int n = t2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(t1.charAt(i-1) == t2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int ans = LCSmemoization("abcde", "ace");
        int ans2 = LCStabulation("abcde", "ace");
        System.out.print(ans2);
    }
}
