package DynamicProgramming.grids;

public class MinimumFallingPath {
    public static int minFallingPathSum(int[][] matrix){
        int n = matrix.length;
        Integer[][] dp = new Integer[n][n];

        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            min = Math.min(min, solve(0, j, matrix, dp));
        }
        return min;
    }

    public static int solve(int i, int j, int[][] matrix, Integer[][] dp){
        int n = matrix.length;

        if(j < 0 || j >= n) return Integer.MAX_VALUE;
        if(i == n-1) return matrix[i][j];
        if(dp[i][j] != null) return dp[i][j];

        int left =  solve(i+1, j-1, matrix, dp);
        int down = solve(i+1, j, matrix, dp);
        int right = solve(i+1, j+1, matrix, dp);

        dp[i][j] = Math.min(down, Math.min(left, right));
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        System.out.println(minFallingPathSum(matrix));
    }
}
