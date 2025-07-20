package DynamicProgramming.grids;

import java.util.*;

public class MinimumPathTriangle {
    public static int triangle(List<List<Integer>> grid){
        int n = grid.size();
        Integer[][] dp = new Integer[n][n];
        return solve(0, 0, grid, dp);
    }
    public static int solve(int i, int j, List<List<Integer>> grid, Integer[][] dp){
        if(i == grid.size()-1) return grid.get(i).get(j);

        if(dp[i][j] != null) return dp[i][j];
        int left = solve(i+1, j, grid, dp);
        int right = solve(i+1, j+1, grid, dp);

        dp[i][j] = grid.get(i).get(j) + Math.min(left, right);
        return dp[i][j];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        int ans = triangle(triangle);
        System.out.print(ans);
    }
}
