package DynamicProgramming.grids;

import java.util.Arrays;

public class UniquePaths {
    public static int uniquePathsTabulation(int m, int n){
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) dp[i][0] = 1;
        for(int j = 0; j < n; j++) dp[0][j] = 1;

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public static int uniquePathsMemoization(int m, int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(m-1, n-1, dp);
    }
    public static int solve(int i, int j, int[][] dp){
        if(i == 0 || j == 0) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        dp[i][j] = solve(i-1, j, dp) + solve(i, j-1, dp);
        return dp[i][j];
    }

    public static void main(String[] args) {
        int ans = uniquePathsMemoization(3, 7);
        System.out.print(ans);
    }
}
